package aircraft;

import aircraft.Coordinates;
import weather.WeatherTower;
import weather.Logger;

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
                Logger.log("JetPlane#" + this.name + "(" + this.id + ")" + ": Ouch the sun is burning my eyes!");
            case "RAIN":
                this.coordinates = new Coordinates(this.coordinates.getLongitude(), this.coordinates.getLatitude() + 5, this.coordinates.getHeight());
                Logger.log("JetPlane#" + this.name + "(" + this.id + ")" + ": Drip drip drip, why won't it stop raining");
            case "FOG":
                this.coordinates = new Coordinates(this.coordinates.getLongitude(), this.coordinates.getLatitude() + 1, this.coordinates.getHeight());
                Logger.log("JetPlane#" + this.name + "(" + this.id + ")" + ": Somebody vaping around here?");
            case "SNOW":
                this.coordinates = new Coordinates(this.coordinates.getLongitude(), this.coordinates.getLatitude(), this.coordinates.getHeight()  - 7);
                Logger.log("JetPlane#" + this.name + "(" + this.id + ")" + ": Crap! did I just hit Santa's sled!?");
        }

        if (this.coordinates.getHeight() == 0) {
            Logger.log("JetPlane#" + this.name + "(" + this.id + ")" +" Landing at: long[" + this.coordinates.getLongitude() + "] lat[" + this.coordinates.getLatitude() + "]");
            Logger.log("Tower says:JetPlane#" + this.name + "(" + this.id + ") unregistered from weather tower.");
            this.weatherTower.unregister(this);
        }
    }

    public void registerTower(WeatherTower weatherTower) {
        this.weatherTower = weatherTower;
        this.weatherTower.register(this);
        Logger.log("Tower says: JetPlane#" + this.name + "(" + this.id + ")" + " registered to weather tower.");
    }
}