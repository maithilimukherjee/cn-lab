import java.io.*;
import java.util.*;
import java.net.*;

public class EchoServer
{
    public static void main(String args[])
    {
        try
        {
            ServerSocket server = new ServerSocket(1414);
            System.out.println("Echo Server is running on port 1414...");

            while(true)
            {
                Socket client = server.accept();

                System.out.println("client connected successfully");

                //read data from client

                BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream()));
                String message = in.readLine();

                PrintWriter out = new PrintWriter(client.getOutputStream(), true);
                out.println("Echo: " + message);

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