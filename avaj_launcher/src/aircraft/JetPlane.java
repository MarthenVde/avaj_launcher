package avaj_launcher.src.aircraft;

import avaj_launcher.src.aircraft.Coordinates;

public class JetPlane extends Aircraft implements Flyable {
    JetPlane(String name, Coordinates Coordinates) {
        super(name, coordinates);
    }

    public void updateConditions() {
        System.out.println("Updating jetplane conditions");
    }

    // public void registerTower(WeatherTower weatherTower) {
    //     System.out.println("registering jetplane");
    // }
}