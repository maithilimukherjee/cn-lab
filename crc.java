import java.util.Scanner;

public class CRCChecker {

    // Method to perform XOR operation
    static String xor(String a, String b) {
        StringBuilder result = new StringBuilder();

        for (int i = 1; i < b.length(); i++) {
            if (a.charAt(i) == b.charAt(i)) {
                result.append('0');
            } else {
                result.append('1');
            }
        }

        return result.toString();
    }

    // Method to perform CRC division
    static String divide(String dividend, String divisor) {
        int pick = divisor.length();

        String temp = dividend.substring(0, pick);

        while (pick < dividend.length()) {

            if (temp.charAt(0) == '1') {
                temp = xor(divisor, temp) + dividend.charAt(pick);
            } else {
                temp = xor("0".repeat(pick), temp) + dividend.charAt(pick);
            }

            pick++;
        }

        // Last step
        if (temp.charAt(0) == '1') {
            temp = xor(divisor, temp);
        } else {
            temp = xor("0".repeat(pick), temp);
        }

        return temp;
    }

    // Method to encode data with CRC
    static String encodeData(String data, String divisor) {

        int divisorLength = divisor.length();

        // Append zeros
        String appendedData = data + "0".repeat(divisorLength - 1);

        // Find remainder
        String remainder = divide(appendedData, divisor);

        // Append remainder to original data
        return data + remainder;
    }

    // Method to check received data
    static boolean checkData(String receivedData, String divisor) {

        String remainder = divide(receivedData, divisor);

        // If remainder contains only 0s → no error
        for (int i = 0; i < remainder.length(); i++) {
            if (remainder.charAt(i) != '0') {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter data bits: ");
        String data = sc.nextLine();

        System.out.print("Enter divisor: ");
        String divisor = sc.nextLine();

        // Sender side
        String transmittedData = encodeData(data, divisor);

        System.out.println("Encoded Data (Data + CRC): " + transmittedData);

        // Receiver side
        System.out.print("Enter received data: ");
        String receivedData = sc.nextLine();

        boolean isValid = checkData(receivedData, divisor);

        if (isValid) {
            System.out.println("No Error Detected");
        } else {
            System.out.println("Error Detected");
        }

        sc.close();
    }
}
