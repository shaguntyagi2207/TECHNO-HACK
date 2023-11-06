import java.security.SecureRandom;
import java.util.Scanner;

public class main {
    private static final String LOWERCASE_CHARACTERS = "abcdefghijklmnopqrstuvwxyz";
    private static final String UPPERCASE_CHARACTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String DIGITS = "0123456789";
    private static final String SPECIAL_CHARACTERS = "!@#$%^&*()-_+=<>?";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Password Generator");
        System.out.print("Enter the length of the password: ");
        int passwordLength = scanner.nextInt();
        scanner.nextLine();  // Consume the newline character

        System.out.print("Include lowercase letters? (y/n): ");
        boolean includeLowercase = scanner.nextLine().equalsIgnoreCase("y");

        System.out.print("Include uppercase letters? (y/n): ");
        boolean includeUppercase = scanner.nextLine().equalsIgnoreCase("y");

        System.out.print("Include numbers? (y/n): ");
        boolean includeNumbers = scanner.nextLine().equalsIgnoreCase("y");

        System.out.print("Include special characters? (y/n): ");
        boolean includeSpecialChars = scanner.nextLine().equalsIgnoreCase("y");

        String password = generatePassword(passwordLength, includeLowercase, includeUppercase, includeNumbers, includeSpecialChars);

        System.out.println("Generated Password: " + password);

        scanner.close();
    }

    public static String generatePassword(int length, boolean includeLowercase, boolean includeUppercase, boolean includeNumbers, boolean includeSpecialChars) {
        StringBuilder characters = new StringBuilder();

        if (includeLowercase) {
            characters.append(LOWERCASE_CHARACTERS);
        }
        if (includeUppercase) {
            characters.append(UPPERCASE_CHARACTERS);
        }
        if (includeNumbers) {
            characters.append(DIGITS);
        }
        if (includeSpecialChars) {
            characters.append(SPECIAL_CHARACTERS);
        }

        if (characters.length() == 0) {
            System.out.println("You must select at least one character type.");
            return "";
        }

        SecureRandom random = new SecureRandom();
        StringBuilder password = new StringBuilder();

        for (int i = 0; i < length; i++) {
            int randomIndex = random.nextInt(characters.length());
            password.append(characters.charAt(randomIndex));
        }

        return password.toString();
    }
}
