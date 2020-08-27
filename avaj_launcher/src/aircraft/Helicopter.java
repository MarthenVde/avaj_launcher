package aircraft;

import weather.WeatherTower;

public class Helicopter extends Aircraft implements Flyable {
    private WeatherTower weatherTower;

    Helicopter(String name, Coordinates coordinates) {
        super(name, coordinates);
    }

    @Override
    public void updateConditions() {
        String weather = this.weatherTower.getWeather(coordinates);

        switch (weather) {
            case "SUN":
                this.coordinates = new Coordinates(this.coordinates.getLongitude() + 2, this.coordinates.getLatitude(), this.coordinates.getHeight() + 4);
                System.out.println("Helicopter#" + this.name + "(" + this.id + ")" + ": Ahhh! it's burning my eyes.");
            case "RAIN":
                this.coordinates = new Coordinates(this.coordinates.getLongitude(), this.coordinates.getLatitude(), this.coordinates.getHeight()  - 5);
                System.out.println("Helicopter#" + this.name + "(" + this.id + ")" + ": It's raining I guess.");
            case "FOG":
                this.coordinates = new Coordinates(this.coordinates.getLongitude(), this.coordinates.getLatitude(), this.coordinates.getHeight()  - 3);
                System.out.println("Helicopter#" + this.name + "(" + this.id + ")" + ": It be foggy, Arrrggg!");
            case "SNOW":
                this.coordinates = new Coordinates(this.coordinates.getLongitude(), this.coordinates.getLatitude(), this.coordinates.getHeight()  - 15);
                System.out.println("Helicopter#" + this.name + "(" + this.id + ")" + ": Sheeet! hope my rotors don't freeze.");
        }

        if (this.coordinates.getHeight() == 0) {
            System.out.println("Helicopter#" + this.name + "(" + this.id + ")" +" Landing at: long(" + this.coordinates.getLongitude() + ") lat(" + this.coordinates.getLatitude() + ")");
            System.out.println("Tower says:Helicopter#" + this.name + "(" + this.id + ") unregistered from weather tower.");
            this.weatherTower.unregister(this);
        }
    }

    @Override
    public void registerTower(WeatherTower weatherTower) {
        this.weatherTower = weatherTower;
        this.weatherTower.register(this);
        System.out.println("Tower says: Helicopter#" + this.name + "(" + this.id + ")" + " registered to weather tower.");
    }
}