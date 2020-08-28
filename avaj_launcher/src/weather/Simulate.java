package weather;

import aircraft.AircraftFactory;
import aircraft.Flyable;
import weather.WeatherTower;

import java.io.*;
import java.util.*;

public class Simulate  {

    public static void main(final String[] args) throws Exception {
        // private static PrintWriter writer;
        
        if (args.length < 1) {
            System.err.println("Error! no simulation file found");
        } else {
            WeatherTower mainTower = new WeatherTower();
            List<Flyable> flyables = new ArrayList<>();
            
            
            try {
                BufferedReader reader = new BufferedReader(new FileReader(args[0]));
                String currentLine = reader.readLine();
                int simCycles = Integer.parseInt(currentLine.replaceAll("\\s+",""));

                if (simCycles < 1) {
                    System.err.print("Error! Invalid ammount of cycles");
                    System.exit(1);
                }
                
                while((currentLine = reader.readLine()) != null) {
                    String[] lineData = currentLine.split(" ");

                    Flyable flyable = AircraftFactory.newAircraft(
                            lineData[0], lineData[1], Integer.parseInt(lineData[2]),
                            Integer.parseInt(lineData[3]), Integer.parseInt(lineData[4])
                            );
                    if (flyable != null) {
                        flyables.add(flyable);
                    } else {
                        System.err.println(currentLine);
                        System.err.println("Error! Invalid aircraft type");
                        System.exit(1);
                    }
                }

                if (flyables.size() >= 1) {
                    Iterator<Flyable> flyableIterator = flyables.iterator();
                    while (flyableIterator.hasNext()) {
                        flyableIterator.next().registerTower(mainTower);
                    }
                    for (int i = 0; i < simCycles; i++) {
                        mainTower.changeWeather();
                    }
                } else {
                    System.err.println("Error! no aircraft found in file");
                }

            } catch (IOException | NumberFormatException | ArrayIndexOutOfBoundsException e) {
                System.err.println("Error! file doesn't exist or file is invalid");
            } 
            // finally {
        
            // }

        }
    }
}
