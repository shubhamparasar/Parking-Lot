package strategies;

import models.ParkingSpot;

public class RandomSpotAllotmentStrategy implements SpotAllotmentStrategy{
    @Override
    public ParkingSpot getSpot() {
        return new ParkingSpot();
    }
}
