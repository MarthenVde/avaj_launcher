package weather;

import java.io.FileWriter;
import java.io.IOException;

public class Logger {
    private static FileWriter writer;

    public static void initFile(String filename) {
        try {
            writer = new FileWriter(filename);
        } catch (Exception e) {
            System.err.println("Error! couldn't create file");
            System.exit(1);
        }
    }

    public static void log(String message) {
        if ((message != null) && (writer != null)) {
            try {
                writer.write(message + "\n");
            } catch (IOException e) {
                System.err.println("Error! couldn't write to output file");
                System.exit(1);
            }
        }
    }

    public static void closeLogger() {
        if (writer != null) {
            try {
                writer.close();
            } catch (IOException e) {
                System.err.println("Error! could not close file");
                System.exit(1);
            }
        }
    }
}