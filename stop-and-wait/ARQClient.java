import java.io.*;
import java.net.Socket; 
import java.net.SocketTimeoutException;

public class ARQClient
{
    public static void main(String args[])
    {
        System.out.println("Client starting: ");

        try
        {
            Socket socket = new Socket("localhost", 7000);
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            
            socket.setSoTimeout(2000);

            int totalFramesToSend = 4;
            int sequenceNumber = 0;

            for(int i = 0; i < totalFramesToSend; i++)
            {
                boolean ackReceived = false;

                while(!ackReceived)
                {
                    try {
                        System.out.println("Sender sending frame: " + i + " with sequence number: " + sequenceNumber);
                        out.println(sequenceNumber); // FIX: Actually transmit the frame over the network

                        String response = in.readLine();
                        int ack = Integer.parseInt(response);

                        System.out.println("Received ACK: " + ack);

                        if(ack == sequenceNumber)
                        {
                            System.out.println("ACK matched. Moving to next frame.");
                            ackReceived = true;
                            sequenceNumber = 1 - sequenceNumber;
                        }

                        else
                        {
                            System.out.println("ACK did not match. Resending frame: " + i + " with sequence number: " + sequenceNumber);
                            out.println(sequenceNumber);
                        }
                    }
                    catch(SocketTimeoutException e)
                    {
                        System.out.println("Timeout occurred. Resending frame: " + i + " with sequence number: " + sequenceNumber);
                    }
                }
            }

            out.println("EXIT");
            System.out.println("Transmission finished.");
            
            // Clean up resources cleanly
            socket.close();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
}
