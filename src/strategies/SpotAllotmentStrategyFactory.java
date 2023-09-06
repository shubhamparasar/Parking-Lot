package strategies;

import models.SpotAllotmentStrategyType;

import java.util.HashMap;
import java.util.Map;

public class SpotAllotmentStrategyFactory {

    private final static Map<SpotAllotmentStrategyType, SpotAllotmentStrategy> strategyMap = new HashMap<>();
    public SpotAllotmentStrategyFactory(){
        strategyMap.put(SpotAllotmentStrategyType.RANDOM, new RandomSpotAllotmentStrategy());
        strategyMap.put(SpotAllotmentStrategyType.NON_RANDOM, new NonRandomSpotAllotmentStrategy());

    }

    public static SpotAllotmentStrategy getStrategy(SpotAllotmentStrategyType spotAllotmentStrategyType){
        return strategyMap.get(spotAllotmentStrategyType);
    }
}
