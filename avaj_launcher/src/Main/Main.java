package Main;
import aircraft.AircraftFactory;
import aircraft.Flyable;
import weather.WeatherTower;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Main {
    public static void main(final String[] args) throws Exception {
        // String[] simData = getSimData();

        WeatherTower mainTower = new WeatherTower();

        List<Flyable> flyables = new ArrayList<>();

        int simCycles = 2;

        for (int i = 0; i < simCycles; i++) {
            String name = "_B" + i;
            Flyable flyable = AircraftFactory.newAircraft("Balloon", name, 0, 0, 0);
            // Flyable aircraft = new AircraftFactory.newAircraft("Balloon", name, 0, 0, 0);
            flyables.add(flyable);
        }

        Iterator<Flyable> flyableIterator = flyables.iterator();
        while (flyableIterator.hasNext()) {
            flyableIterator.next().registerTower(mainTower);
        }
        
        for (int i = 0; i < simCycles; i++) {
            mainTower.changeWeather();
        }

        // Read number of times sim should run
        // Read in flyables
        // Create list of 
    }
    
    private static String[] getSimData() {
        String filename = "simulation.txt";
        String[] data;

        
        try {
            File simFile = new File(filename);
            Scanner reader = new Scanner(simFile);

            while (reader.hasNextLine()) {
                String line = reader.nextLine();
                System.out.println(line);
            }
        } catch (FileNotFoundException e) {
            System.out.println("Could not open file!");
            e.printStackTrace();
        }

        return null;
    }
}
