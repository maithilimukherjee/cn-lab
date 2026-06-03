import java.io.*;
import java.util.*;
import java.net.*;

public class AnyMachineIP
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("enter host name: ");

        try
        {
            String host = sc.nextLine();

            InetAddress ip = InetAddress.getByName(host);
            System.out.println("Host name: " + ip.getHostName());
            System.out.println("IP address: " + ip.getHostAddress());
        }
        catch (UnknownHostException e)
        {
            System.out.println("Host not found.");
        }
    }
}