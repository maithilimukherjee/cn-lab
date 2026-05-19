import java.util.*;

class CRC {

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

    static String divide(String dividend, String divisor) {

        int divisorLength = divisor.length();
        int pick = divisorLength;

        String temp = dividend.substring(0, pick);

        while (pick < dividend.length()) {

            if (temp.charAt(0) == '1') {
                temp = xor(divisor, temp) + dividend.charAt(pick);
            } else {
                temp = xor("0".repeat(divisorLength), temp) + dividend.charAt(pick);
            }

            pick++;
        }

        if (temp.charAt(0) == '1') {
            temp = xor(divisor, temp);
        } else {
            temp = xor("0".repeat(divisorLength), temp);
        }

        return temp;
    }

    static String encodeData(String data, String divisor) {

        int divisorLength = divisor.length();

        String appendedData = data + "0".repeat(divisorLength - 1);

        String remainder = divide(appendedData, divisor);

        return data + remainder;
    }

    static boolean checkData(String receivedData, String divisor) {

        String remainder = divide(receivedData, divisor);

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
        String data = sc.next();

        System.out.print("Enter divisor: ");
        String divisor = sc.next();

        String encodedData = encodeData(data, divisor);

        System.out.println("Encoded Data (Data + CRC): " + encodedData);

        System.out.print("Enter received data: ");
        String receivedData = sc.next();

        if (checkData(receivedData, divisor)) {
            System.out.println("No Error Detected");
        } else {
            System.out.println("Error Detected");
        }

        sc.close();
    }
}
