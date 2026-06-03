package crc;

import java.util.*;
import java.io.*;
import java.net.*;

public class CRC
{
   static String xor(String a, String b)
   {
    StringBuilder result = new StringBuilder();

    for(int i = 1; i <b.length(); i++)
    {
        if(a.charAt(i) == b.charAt(i))
        {
            result.append('0');
        }
        else
        {
            result.append('1');
        }
    }

    return result.toString();

   }

   static String divide(String dividend, String divisor)
   {
    int divisorLength = divisor.length();
    int pick = divisorLength;

    String temp = dividend.substring(0, pick);

    while(pick<dividend.length())
    {
        if(temp.charAt(0)=='1')
       {
        temp = xor(divisor,temp) + dividend.charAt(pick);
        }

        if(temp.charAt(0)=='0')
        {
            temp = xor("0".repeat(divisorLength),temp) + dividend.charAt(pick);
        }

        pick++;

    }

    if(temp.charAt(0)=='1')
    {
        temp = xor(divisor,temp);
    }
    else
    {
        temp = xor("0".repeat(divisorLength),temp);
    }

    return temp;

   }

   static String encodeData(String data, String divisor)
   {
    int divisorLength = divisor.length();
    String remainder = divide(data + "0".repeat(divisorLength - 1), divisor);
    return data + remainder;

   }

    public static void main(String args[])
    {
     Scanner sc = new Scanner(System.in);
     System.out.println("Enter data to be transmitted: ");
     String data = sc.nextLine();
    
     System.out.println("Enter divisor: ");
     String divisor = sc.nextLine();
    
     String encodedData = encodeData(data, divisor);
     System.out.println("Encoded data to be transmitted: " + encodedData);

     System.out.println("Enter received data: ");
     String receivedData = sc.nextLine();

        String remainder = divide(receivedData, divisor);
        if(remainder.equals("0".repeat(divisor.length() - 1)))
        {
            System.out.println("Data received is correct.");
        }
        else
        {
            System.out.println("Data received is incorrect.");
        }
    }
}