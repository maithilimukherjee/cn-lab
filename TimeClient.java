import java.io.*;
import java.net.*;
import java.util.*;

public class TimeClient {
    public static void main(String[] args) {
        try {
            // Connect to server at localhost:1313
            Socket sock = new Socket("localhost", 1313);

            // Receive date and time
            ObjectInputStream in = new ObjectInputStream(sock.getInputStream());
            Date serverDate = (Date) in.readObject();

            // Print result
            System.out.println("Current Date & Time from Server: " + serverDate);

            // Close connection
            in.close();
            sock.close();
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Client error: " + e.getMessage());
        }
    }
}
