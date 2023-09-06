package respositories;

import models.Vehicle;
import models.VehicleType;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class VehicleRespository {

    Map<Long, Vehicle> vehicleMap = new HashMap<>();
    private int index = 0;
    public Optional<Vehicle> getByNumber(String number){
        for(Vehicle vehicle : vehicleMap.values()){
            if(vehicle.getVehicleNumber().equals(number)){
                return Optional.of(vehicle);
            }

        }
        return Optional.empty();
    }

    public Vehicle saveVehicle(Vehicle vehicle){

        vehicleMap.put((long)index, vehicle);
        index++;
        return vehicle;
    }
}
