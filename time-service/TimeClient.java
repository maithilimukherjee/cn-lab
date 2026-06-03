import java.util.*;
import java.io.*;
import java.net.*;

public class TimeClient
{
    public static void main(String args[])
    {
        try
        {
            Socket client = new Socket("localhost", 1313);

            ObjectInputStream in = new ObjectInputStream(client.getInputStream());

            Date serverTime = (Date) in.readObject();

            System.out.println("Current time from server: " + serverTime.toString());

            in.close();
            client.close();

        }
        catch (IOException e)
        {
            System.out.println("Error: " + e.getMessage());
        }
        catch (ClassNotFoundException e)
        {
            System.out.println("Error: " + e.getMessage());
        }
    }
}