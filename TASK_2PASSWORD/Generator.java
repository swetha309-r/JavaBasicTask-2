import java.util.Scanner;
import javax.crypto.SecretKey;

public class Generator {
    Alphabet alphabet;
    public static Scanner keyboard;

    public Generator(Scanner scanner) {
        keyboard = scanner;
    }

    public Generator(boolean includeUpper, boolean includeLower, boolean includeNum, boolean includeSym) {
        alphabet = new Alphabet(includeUpper, includeLower, includeNum, includeSym);
    }

    public void mainLoop() {
        System.out.println("Welcome to Ziz Password Services :)");
        printMenu();

        String userOption = "-1";

        while (!userOption.equals("4")) {
            userOption = keyboard.next();

            switch (userOption) {
                case "1" -> {
                    requestPassword();
                    printMenu();
                }
                case "2" -> {
                    checkPassword();
                    printMenu();
                }
                case "3" -> {
                    printUsefulInfo();
                    printMenu();
                }
                case "4" -> printQuitMessage();
                default -> {
                    System.out.println();
                    System.out.println("Kindly select one of the available commands");
                    printMenu();
                }
            }
        }
    }

    private Password generatePassword(int length) {
        final StringBuilder pass = new StringBuilder("");

        final int alphabetLength = alphabet.getAlphabet().length();

        int max = alphabetLength - 1;
        int min = 0;
        int range = max - min + 1;

        for (int i = 0; i < length; i++) {
            int index = (int) (Math.random() * range) + min;
            pass.append(alphabet.getAlphabet().charAt(index));
        }

        return new Password(pass.toString());
    }

    private void requestPassword() {
        System.out.println("Enter the desired password length:");
        int length = keyboard.nextInt();

        // Gather parameters for Alphabet (assuming boolean flags are entered as 'true'
        // or 'false')
        System.out.println("Include uppercase letters? (true/false):");
        boolean includeUpper = keyboard.nextBoolean();
        System.out.println("Include lowercase letters? (true/false):");
        boolean includeLower = keyboard.nextBoolean();
        System.out.println("Include numbers? (true/false):");
        boolean includeNum = keyboard.nextBoolean();
        System.out.println("Include symbols? (true/false):");
        boolean includeSym = keyboard.nextBoolean();

        // Initialize Alphabet with user-specified criteria
        alphabet = new Alphabet(includeUpper, includeLower, includeNum, includeSym);

        // Generate password
        final Password password = generatePassword(length);

        try {
            // Encrypt password
            SecretKey key = EncryptionUtils.generateKey();
            String encryptedPassword = EncryptionUtils.encrypt(password.toString(), key);
            System.out.println("Your encrypted password: " + encryptedPassword);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void checkPassword() {
        System.out.println("Enter the password to check:");
        String passwordStr = keyboard.next();
        Password password = new Password(passwordStr);
        int score = password.calculateScore();
        System.out.println("Password score: " + score);
    }

    private void printUsefulInfo() {
        System.out.println("Useful Information:");
        System.out.println("1. Use a combination of uppercase, lowercase, numbers, and symbols for strong passwords.");
        System.out.println("2. Avoid using common words and personal information.");
        System.out.println("3. Use different passwords for different accounts.");
        System.out.println("4. Change your passwords regularly.");
    }

    private void printMenu() {
        System.out.println();
        System.out.println("Enter 1 - Password Generator");
        System.out.println("Enter 2 - Password Strength Check");
        System.out.println("Enter 3 - Useful Information");
        System.out.println("Enter 4 - Quit");
        System.out.print("Choice: ");
    }

    private void printQuitMessage() {
        System.out.println("Thank you for using Ziz Password Services. Stay safe!");
    }
}
