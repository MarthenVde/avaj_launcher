package aircraft;

import aircraft.Coordinates;

public class JetPlane extends Aircraft implements Flyable {
    JetPlane(String name, Coordinates coordinates) {
        super(name, coordinates);
    }

    public void updateConditions() {
        System.out.println("Updating jetplane conditions");
    }

    // public void registerTower(WeatherTower weatherTower) {
    //     System.out.println("registering jetplane");
    // }
}