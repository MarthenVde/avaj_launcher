package aircraft;

public class Aircraft {
    protected long _id;
    protected String _name;
    protected Coordinates _coordinates;
    private static long idCounter = 0;

    public Aircraft(String name, Coordinates coordinates) {
        _name = name;
        _coordinates = coordinates;
        _id = idCounter;
        idCounter++;
    }
}