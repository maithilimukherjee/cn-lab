import java.io.*;
import java.net.*;

public class LowercaseClient {
    public static void main(String[] args) {
        try (Socket socket = new Socket("localhost", 5000)) {
            BufferedReader console = new BufferedReader(new InputStreamReader(System.in));
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            System.out.print("Enter a lowercase string: ");
            String input = console.readLine();

            out.println(input);
            String response = in.readLine();

            System.out.println("Response from server: " + response);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
