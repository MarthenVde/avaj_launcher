package aircraft;

import weather.WeatherTower;

public class Balloon extends Aircraft implements Flyable {
    private WeatherTower weatherTower;

    Balloon(String name, Coordinates coordinates) {
        super(name, coordinates);
    }

    public void updateConditions() {
        System.out.println("Updating balloon conditions");
        // get current weather
        // update corrdinates
            // check if nsow, rain etc...
            // write message

        // check if landed
    }

    public void registerTower(WeatherTower weatherTower) {
        this.weatherTower = weatherTower;
        this.weatherTower.register(this);
        System.out.println("Tower says: Balloon#" + this.name + "(" + this.id + ")" + " registered to weather tower.");
    }
}