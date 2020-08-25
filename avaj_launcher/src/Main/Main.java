package Main;
import aircraft.Aircraft;
import aircraft.Coordinates;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static void main(final String[] args) throws Exception {
        System.out.println("Hello, World!");
        // Coordinates coord = new Coordinates(1,2,3);
        // Aircraft a1 = new Aircraft("a1", coord);
        // Aircraft a2 = new Aircraft("a2", coord);
        // Aircraft a3 = new Aircraft("a3", coord);

        
        
        String[] simData = getSimData();
        
        
        // Read simulator.txt
        
        // System.out.println(a1._id);
        // System.out.println(a2._id);
        // System.out.println(a3._id);
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
