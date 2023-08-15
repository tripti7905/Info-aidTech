import java.util.Random;
import java.util.Scanner;

public class PasswordGenerator {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter the length of the password: ");
        int passwordLength = scanner.nextInt();
        
        System.out.print("Enter the character set (1 for lowercase, 2 for uppercase, 3 for numbers, 4 for special characters, or 7 for a combination of lowercase, uppercase, and special characters): ");
        int characterSet = scanner.nextInt();
        
        String generatedPassword = generatePassword(passwordLength, characterSet);
        System.out.println("Generated Password: " + generatedPassword);
        
        scanner.close();
    }

    public static String generatePassword(int length, int characterSet) {
        String lowercaseChars = "abcdefghijklmnopqrstuvwxyz";
        String uppercaseChars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String numberChars = "0123456789";
        String specialChars = "!@#$%^&*()-_=+[]{}|;:,.<>?";

        String allowedChars = "";
        if ((characterSet & 1) != 0) allowedChars += lowercaseChars;
        if ((characterSet & 2) != 0) allowedChars += uppercaseChars;
        if ((characterSet & 3) != 0) allowedChars += numberChars;
        if ((characterSet & 4) != 0) allowedChars += specialChars;

        Random random = new Random();
        StringBuilder password = new StringBuilder();

        for (int i = 0; i < length; i++) {
            int randomIndex = random.nextInt(allowedChars.length());
            char randomChar = allowedChars.charAt(randomIndex);
            password.append(randomChar);
        }
        return password.toString();
    }
}
