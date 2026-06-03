
import java.util.*;
import java.io.*;
import java.net.*;

public class EchoClient {

    public static void main(String[] args) {

        try
        {
            Socket client = new Socket("localhost",1414);

            PrintWriter out = new PrintWriter(client.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream()));

            Scanner sc = new Scanner(System.in);
            System.out.println("Enter a message to send to the server: ");
            String message = sc.nextLine();

            out.println(message);

            String response = in.readLine();
            System.out.println("Response from server: " + response);
            out.close();
            in.close();
            client.close();
            
        }

        catch (IOException e)
        {
            System.out.println("Error: " + e.getMessage());
        }
    
}
}
