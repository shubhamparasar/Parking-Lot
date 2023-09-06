package respositories;

import models.Gate;
import models.ParkingLot;

import java.util.Map;
import java.util.Optional;
import java.util.TreeMap;

public class ParkingLotRepository {

    private Map<Long, ParkingLot> parkingLotMap = new TreeMap<>();
    public ParkingLot parkingLotForGate(Gate gate){
        for(ParkingLot parkingLot : parkingLotMap.values()){
            if(parkingLot.getGates().contains(gate)){
                return parkingLot;
            }
        }
        return null;
    }
}
