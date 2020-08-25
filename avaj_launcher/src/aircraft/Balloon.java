package aircraft;

public class Balloon extends Aircraft implements Flyable {
    Balloon(String name, Coordinates coordinates) {
        super(name, coordinates);
    }

    public void updateConditions() {
        System.out.println("Updating balloon conditions");
    }

    // public void registerTower(WeatherTower weatherTower) {
    //     System.out.println("registering balloon");
    // }
}