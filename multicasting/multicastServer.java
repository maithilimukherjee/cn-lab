import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
public class multicastServer
{
    public static void main(String args[])
    {
        System.out.println("Multicast Server is running...");
        
        try
        {
            InetAddress group = InetAddress.getByName("230.0.0.1");
            int port = 4446;

            DatagramSocket socket = new DatagramSocket();

            String message = "Hello from multicast server!";
            byte[] buffer = message.getBytes();

            DatagramPacket packet = new DatagramPacket(buffer, buffer.length, group, port);
            System.out.println("Broadcasting message: " + message);
            socket.send(packet);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
