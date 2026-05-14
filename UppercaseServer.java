import java.io.*;
import java.net.*;

public class UppercaseServer {
    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(5000)) {
            System.out.println("Server is running and waiting for client...");

            Socket socket = serverSocket.accept();
            System.out.println("Client connected!");

            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

            String input = in.readLine();
            System.out.println("Received from client: " + input);

            String output = input.toUpperCase();
            out.println(output);
            System.out.println("Sent back to client: " + output);

            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
