package weather;

import aircraft.AircraftFactory;
import aircraft.Flyable;

import java.io.*;
import java.util.*;

public class Simulate  {
    public static PrintWriter writer;

    public static void main(final String[] args) throws Exception {
        String outFilename = "simulation.txt";
        
        if (args.length < 1) {
            System.err.println("Error! no simulation file found");
        } else {
            WeatherTower mainTower = new WeatherTower();
            List<Flyable> flyables = new ArrayList<>();
            
            if (args[0] == outFilename) {
                System.err.println("Error! can't use output filename");
            }
             
            try {
                BufferedReader reader = new BufferedReader(new FileReader(args[0]));
                String currentLine = reader.readLine();
                int simCycles = Integer.parseInt(currentLine.replaceAll("\\s+",""));
                Logger.initFile(outFilename);

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
                reader.close();

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
            } catch (NullPointerException e) {
                System.err.println("Error! empty ");
            } catch (IOException e) {
                System.err.println("Error! file doesn't exist");
            } catch (ArrayIndexOutOfBoundsException  | NumberFormatException e) {
                System.err.println("Error! file is invalid");
            } finally {
                Logger.closeLogger();
            }
        }
    }
}
