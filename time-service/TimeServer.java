import java.io.*;
import java.net.*;
import java.util.*;

public class TimeServer
{
    public static void main(String args[])
    {
        try
        {
            ServerSocket server = new ServerSocket(1313);
            System.out.println("Time server is running on port 1313...");

            while(true)
            {
                Socket client = server.accept();

                System.out.println("Client connected successsfully.");

                Date now = new Date();

                ObjectOutputStream out = new ObjectOutputStream(client.getOutputStream());

                out.writeObject(now);
                out.flush();
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
