import java.net.*;

public class multicastClient
{
    public static void main(String args[])
    {
        try
        {
            int port = 4446;

            InetAddress group = InetAddress.getByName("231.0.0.1");

            MulticastSocket socket = new MulticastSocket(port);

            socket.joinGroup(group);

            byte[] buffer = new byte[256];

            DatagramPacket packet =
                new DatagramPacket(buffer, buffer.length);

            socket.receive(packet);

            String message =
                new String(packet.getData(), 0, packet.getLength());

            System.out.println(
                "Received message from multicast group: "
                + message);

            socket.leaveGroup(group);

            socket.close();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
}
