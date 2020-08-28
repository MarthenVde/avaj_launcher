package aircraft;

import weather.WeatherTower;
import weather.Logger;

public class Baloon extends Aircraft implements Flyable {
    private WeatherTower weatherTower;

    Baloon(String name, Coordinates coordinates) {
        super(name, coordinates);
    }

    @Override
    public void updateConditions() {
        String weather = this.weatherTower.getWeather(coordinates);

        switch (weather) {
            case "SUN":
                this.coordinates = new Coordinates(this.coordinates.getLongitude() + 2, this.coordinates.getLatitude(), this.coordinates.getHeight() + 4);
                Logger.log("Baloon#" + this.name + "(" + this.id + ")" + ": Hmmm, tasty vitamin D.");
            case "RAIN":
                this.coordinates = new Coordinates(this.coordinates.getLongitude(), this.coordinates.getLatitude(), this.coordinates.getHeight()  - 5);
                Logger.log("Baloon#" + this.name + "(" + this.id + ")" + ": Oh no! the clouds are pissing one me :(");
            case "FOG":
                this.coordinates = new Coordinates(this.coordinates.getLongitude(), this.coordinates.getLatitude(), this.coordinates.getHeight()  - 3);
                Logger.log("Baloon#" + this.name + "(" + this.id + ")" + ": Dammit! can't see a thing in this fog.");
            case "SNOW":
                this.coordinates = new Coordinates(this.coordinates.getLongitude(), this.coordinates.getLatitude(), this.coordinates.getHeight()  - 15);
                Logger.log("Baloon#" + this.name + "(" + this.id + ")" + ": BRrrr! it's freezing, hope my Baloon doesn't fall out of the sky.");
        }

        if (this.coordinates.getHeight() == 0) {
            Logger.log("Baloon#" + this.name + "(" + this.id + ")" +" Landing at: long[" + this.coordinates.getLongitude() + "] lat[" + this.coordinates.getLatitude() + "]");
            Logger.log("Tower says: Baloon#" + this.name + "(" + this.id + ") unregistered from weather tower.");
            this.weatherTower.unregister(this);
        }
    }

    @Override
    public void registerTower(WeatherTower weatherTower) {
        this.weatherTower = weatherTower;
        this.weatherTower.register(this);
        Logger.log("Tower says: Baloon#" + this.name + "(" + this.id + ")" + " registered to weather tower.");
    }
}