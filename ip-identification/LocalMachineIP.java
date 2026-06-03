import java.io.*;
import java.util.*;
import java.net.*;

public class LocalMachineIP
{
    public static void main(String args[])
    {
        try
        {
            InetAddress localIP = InetAddress.getLocalHost();

            System.out.println("Local machine host name: " + localIP.getHostName());
            System.out.println("Local machine IP address: " + localIP.getHostAddress());
        }
        catch (UnknownHostException e)
        {
            System.out.println("Local machine not found.");
        }
    }
}