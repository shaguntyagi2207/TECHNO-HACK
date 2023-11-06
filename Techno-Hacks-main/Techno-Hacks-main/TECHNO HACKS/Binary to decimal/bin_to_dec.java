import java.util.Scanner;

public class bin_to_dec {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a binary number: ");
        String binaryStr = scanner.nextLine();

        int decimal = binaryToDecimal(binaryStr);

        System.out.println("Decimal equivalent: " + decimal);

        scanner.close();
    }

    public static int binaryToDecimal(String binaryStr) {
        int decimal = 0;
        int binaryLength = binaryStr.length();

        for (int i = 0; i < binaryLength; i++) {
            char binaryDigit = binaryStr.charAt(i);

            // Check if the character is '0' or '1'
            if (binaryDigit != '0' && binaryDigit != '1') {
                System.err.println("Invalid binary input.");
                System.exit(1);
            }

            // Convert the binary digit to decimal and add to the result
            int power = binaryLength - i - 1;
            decimal += (binaryDigit - '0') * Math.pow(2, power);
        }

        return decimal;
    }
}
