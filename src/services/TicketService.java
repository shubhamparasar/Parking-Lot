package services;

import models.*;
import respositories.GateRepository;
import respositories.ParkingLotRepository;
import respositories.TicketRepository;
import respositories.VehicleRespository;
import strategies.SpotAllotmentStrategy;
import strategies.SpotAllotmentStrategyFactory;

import java.util.Date;
import java.util.Optional;

public class TicketService {

    private GateRepository gateRepository;
    private VehicleRespository vehicleRespository;
    private ParkingLotRepository parkingLotRepository;
    private TicketRepository ticketRepository;

    public Ticket issueTicket(VehicleType vehicleType,
                         String vehicleNumber,
                         String ownersName,
                         Long gateId){
        Ticket newAssignedTicket = new Ticket();
        newAssignedTicket.setEntryTime(new Date());
        Optional<Gate> gate = gateRepository.getById(gateId);
        newAssignedTicket.setGeneratedAt(gate.get());
        newAssignedTicket.setOperator(gate.get().getOperator());

        Vehicle savedVehicle;

        Optional<Vehicle> optionalVehicle = vehicleRespository.getByNumber(vehicleNumber);
        if(optionalVehicle.isEmpty()){
            Vehicle vehicle = new Vehicle();
            vehicle.setVehicleType(vehicleType);
            vehicle.setVehicleNumber(vehicleNumber);
            vehicle.setOwnerName(ownersName);
            savedVehicle = vehicleRespository.saveVehicle(vehicle);
        }
        else {
            savedVehicle = optionalVehicle.get();
        }
        newAssignedTicket.setVehicle(savedVehicle);


        ParkingLot parkingLot = parkingLotRepository.parkingLotForGate(gate.get());
        SpotAllotmentStrategyType spotAllotmentStrategyType = parkingLot.getSpotAllotmentStrategyType();

        SpotAllotmentStrategy spotAllotmentStrategy = SpotAllotmentStrategyFactory.getStrategy(spotAllotmentStrategyType);
        ParkingSpot parkingSpot = spotAllotmentStrategy.getSpot();
        newAssignedTicket.setAssignedSpot(parkingSpot);

        return ticketRepository.saveTicket(newAssignedTicket);


    }
}
