package avaj_launcher.src.aircraft;

public class Balloon extends Aircraft {
    Balloon(String name, Coordinates coordinates) {
        super(name, coordinates);
    }

    public void updateConditions() {
        System.out.println("Updating balloon conditions");
    }

    // public void registerTower(WeatherTower weatherTower) {
    //     System.out.println("Updating balloon conditions");
    // }
}