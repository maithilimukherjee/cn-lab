package a5;

import java.net.*;

public class accessIP {
    
    public static void main(String args[]) throws UnknownHostException {
        
        InetAddress ipaddress = InetAddress.getLocalHost();
        System.out.println("Local Host: " + ipaddress);

        
        ipaddress = InetAddress.getByName("moonshop.com");
        System.out.println("Domain IP: " + ipaddress);
    }
}
