import java.io.*;
import java.net.*;
import java.util.*;

public class TimeServer {
    public static void main(String[] args) {
        try {
            // Create server socket on port 1313
            ServerSocket servSock = new ServerSocket(1313);
            System.out.println("Time Server started. Waiting for client...");

            while (true) {
                // Accept client connection
                Socket clientSock = servSock.accept();
                System.out.println("Client connected.");

                // Get current date and time
                Date now = new Date();

                // Send to client
                ObjectOutputStream out = new ObjectOutputStream(clientSock.getOutputStream());
                out.writeObject(now);
                out.flush();

                // Close connection
                out.close();
                clientSock.close();
            }
        } catch (IOException e) {
            System.out.println("Server error: " + e.getMessage());
        }
    }
}
