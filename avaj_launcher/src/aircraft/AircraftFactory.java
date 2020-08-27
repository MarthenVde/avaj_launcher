package aircraft;

public class AircraftFactory {
    public static Flyable newAircraft(String type, String name, int longitude, int latitude, int height) {
        Coordinates coord = new Coordinates(longitude, latitude, height);

        switch (type) {
            case "Balloon":
                return new Balloon(name, coord);
            case "Helicopter":
                return new Helicopter(name, coord);
            case "JetPlane":
                return new JetPlane(name, coord);
            default:
                return null;
        }
    }
}