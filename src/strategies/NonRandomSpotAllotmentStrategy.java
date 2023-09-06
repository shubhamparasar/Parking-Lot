package strategies;

import models.ParkingSpot;

public class NonRandomSpotAllotmentStrategy implements SpotAllotmentStrategy{
    @Override
    public ParkingSpot getSpot() {
        return new ParkingSpot();
    }
}
