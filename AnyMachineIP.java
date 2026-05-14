import java.util.*;
import java.net.InetAddress;

public class AnyMachineIP
{
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);	
		System.out.println("Enter host name: ");

		try{

		String host = sc.nextLine();

		InetAddress ip = InetAddress.getByName(host);

		System.out.println("Host Name: "+ip.getHostName());
		System.out.println("IP Address: "+ip.getHostAddress());

		}

		catch(Exception e)
		{
			System.out.println("Error: "+e);
		}

		sc.close();
	}
}
