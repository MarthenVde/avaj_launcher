package weather;

import aircraft.Coordinates;

public class WeatherProvider {
    private static WeatherProvider weatherProvider = new WeatherProvider();
    private static String[] weather = {"RAIN", "FOG", "SUN", "SNOW"};

    private WeatherProvider() {
    }

    public static WeatherProvider getProvider() {
        return weatherProvider;
    }

    public String getCurrentWeather(Coordinates coordinates) {
        int coordSum = coordinates.getHeight() + coordinates.getLatitude() + coordinates.getLongitude();
        int index = ((coordSum % 4) >= 0) ? (coordSum % 4) : ((coordSum % 4) * -1);
        return weather[index];
    }
}