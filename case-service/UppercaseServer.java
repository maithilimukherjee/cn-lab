import java.io.*;
import java.util.*;
import java.net.*;

public class UppercaseServer
{
    public static void main(String args[])
    {
        try{
            ServerSocket server = new ServerSocket(1313);
            System.out.println("Uppercase server is running on port 1313...");

            while(true)
            {
                Socket client = server.accept();

                System.out.println("Client connected successfully");

                BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream()));
                PrintWriter out = new PrintWriter(client.getOutputStream(), true);

                String message = in.readLine();
                String uppercaseMessage = message.toUpperCase();
                out.println(uppercaseMessage);
                in.close();
                out.close();
                client.close();

            }
        }
        catch (IOException e)
        {
            System.out.println("Error: " + e.getMessage());
        }
    }
}