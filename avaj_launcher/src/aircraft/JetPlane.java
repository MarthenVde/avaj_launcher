package aircraft;

import aircraft.Coordinates;
import weather.WeatherTower;

public class JetPlane extends Aircraft implements Flyable {
    private WeatherTower weatherTower;
    
    JetPlane(String name, Coordinates coordinates) {
        super(name, coordinates);
    }

    @Override
    public void updateConditions() {
        String weather = this.weatherTower.getWeather(coordinates);

        switch (weather) {
            case "SUN":
                this.coordinates = new Coordinates(this.coordinates.getLongitude(), this.coordinates.getLatitude() + 10, this.coordinates.getHeight() + 2);
                System.out.println("JetPlane#" + this.name + "(" + this.id + ")" + ": Ouch the sun is burning my eyes!");
            case "RAIN":
                this.coordinates = new Coordinates(this.coordinates.getLongitude(), this.coordinates.getLatitude() + 5, this.coordinates.getHeight());
                System.out.println("JetPlane#" + this.name + "(" + this.id + ")" + ": Drip drip drip, why won't it stop raining");
            case "FOG":
                this.coordinates = new Coordinates(this.coordinates.getLongitude(), this.coordinates.getLatitude() + 1, this.coordinates.getHeight());
                System.out.println("JetPlane#" + this.name + "(" + this.id + ")" + ": Somebody vaping around here?");
            case "SNOW":
                this.coordinates = new Coordinates(this.coordinates.getLongitude(), this.coordinates.getLatitude(), this.coordinates.getHeight()  - 7);
                System.out.println("JetPlane#" + this.name + "(" + this.id + ")" + ": Crap! did I just hit Santa's sled!?");
        }

        if (this.coordinates.getHeight() == 0) {
            System.out.println("JetPlane#" + this.name + "(" + this.id + ")" +" Landing at: long(" + this.coordinates.getLongitude() + ") lat(" + this.coordinates.getLatitude() + ")");
            System.out.println("Tower says:JetPlane#" + this.name + "(" + this.id + ") unregistered from weather tower.");
            this.weatherTower.unregister(this);
        }
    }

    public void registerTower(WeatherTower weatherTower) {
        this.weatherTower = weatherTower;
        this.weatherTower.register(this);
        System.out.println("Tower says: JetPlane#" + this.name + "(" + this.id + ")" + " registered to weather tower.");
    }
}