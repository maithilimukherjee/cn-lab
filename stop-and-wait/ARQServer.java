import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class ARQServer
{
    public static void main(String args[])
    {
        System.out.println("Server is listening: ");
        
        try
        {
            ServerSocket server = new ServerSocket(7000);
            Socket socket = server.accept();

            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

            int expectedFrame = 0;

            while(true)
            {
                String frameStr = in.readLine();

                if(frameStr==null || frameStr.equalsIgnoreCase("EXIT"))
                {
                    System.out.println("Transmission finished.");
                    break;
                }

                int receivedFrame= Integer.parseInt(frameStr);
                System.out.println("Received Frame: "+receivedFrame);

                if (receivedFrame == expectedFrame)
                {
                    System.out.println("Match");
                    System.out.println("sending ACK: "+expectedFrame);

                    out.println(expectedFrame);
                    expectedFrame = 1 - expectedFrame;

                }

                else
                {
                    System.out.println("Duplicate frame detected.");
                    System.out.println("Resending last ACK: "+(1-expectedFrame));
                    out.println(1-expectedFrame);

                }
            }
        }
            catch(Exception  e)
            {
                e.printStackTrace();
            }
            }



        }
