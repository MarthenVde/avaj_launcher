package aircraft;

import weather.WeatherTower;

public interface Flyable {
    public void updateConditions();
    void registerTower(WeatherTower weatherTower);
}