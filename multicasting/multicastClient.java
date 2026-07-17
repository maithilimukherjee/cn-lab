import java.net.DatagramPacket;     // Added missing import
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.MulticastSocket;
import java.net.NetworkInterface;
import java.net.SocketAddress;

public class multicastClient
{
    public static void main(String args[])
    {
        System.out.println("Multicast Client is running...");

        try
        {
            int port = 4446;
            MulticastSocket socket = new MulticastSocket(port);

            InetAddress group = InetAddress.getByName("230.0.0.1");

            SocketAddress groupAddress = new InetSocketAddress(group, port);

            NetworkInterface netIf = NetworkInterface.getByInetAddress(InetAddress.getLocalHost());
            socket.joinGroup(groupAddress, netIf);

            byte[] buffer = new byte[256];
            DatagramPacket packet = new DatagramPacket(buffer, buffer.length);

            socket.receive(packet);
            String received = new String(packet.getData(), 0, packet.getLength());
            System.out.println("Received message: " + received);

            socket.leaveGroup(groupAddress, netIf);
            socket.close();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
