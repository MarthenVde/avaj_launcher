package avaj_launcher.src.Main;
import avaj_launcher.src.aircraft.Aircraft;
import avaj_launcher.src.aircraft.Coordinates;

public class Main {
    public static void main(final String[] args) throws Exception {
        System.out.println("Hello, World!");
        Coordinates coord = new Coordinates(1,2,3);
        Aircraft a1 = new Aircraft("a1", coord);
        Aircraft a2 = new Aircraft("a2", coord);
        Aircraft a3 = new Aircraft("a3", coord);

        String filename = "simulation.txt";



        // Read simulator.txt
        
        // System.out.println(a1._id);
        // System.out.println(a2._id);
        // System.out.println(a3._id);
    }
}
