import java.util.*;
import java.io.*;
import java.net.*;

public class ipClassFromHost
{
    public static void main(String args[])
    {
        try
        {
            InetAddress ip = InetAddress.getLocalHost();
            String ipAddress = ip.getHostAddress();
            System.out.println("IP Address: "+ipAddress);

            String[] parts = ipAddress.split("\\.");

            int first = Integer.parseInt(parts[0]);

            if (first >= 1 && first <= 126)
            {
                System.out.println("Class A");
            }
            else if (first == 127) {
                System.out.println("Loopback Address (Reserved)");
            } 

            else if (first >= 128 && first <= 191)
            {
                System.out.println("Class B");
            }
            else if (first >= 192 && first <= 223)
            {
                System.out.println("Class C");
            }
            else if (first >= 224 && first <= 239)
            {
                System.out.println("Class D");
            }
            else if (first >= 240 && first <= 255)
            {
                System.out.println("Class E");
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
}
