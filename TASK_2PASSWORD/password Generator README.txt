Project Overview
This project implements a secure password generator in Java, which helps users create strong passwords to enhance security against rising cyber threats. The application allows users to:

Generate random passwords based on specified criteria (uppercase, lowercase, numbers, symbols).
Encrypt generated passwords for secure storage.
Check the strength of existing passwords.
Provide useful tips on creating strong passwords.
Features
Password Generation:

Users can specify the inclusion of uppercase letters, lowercase letters, numbers, and symbols.
The generated password can be of a user-defined length.
Password Encryption:

Generated passwords are encrypted using AES encryption for secure storage.
Password Strength Check:

Users can check the strength of their existing passwords.
The application evaluates the password based on length, and the inclusion of uppercase letters, lowercase letters, numbers, and symbols.
Useful Information:

The application provides useful tips for creating strong passwords.


Classes and Methods
Main.java
Main: Entry point of the application. Initializes the scanner and starts the main loop of the Generator class.
Alphabet.java
Alphabet: Constructs a character set based on user preferences for uppercase letters, lowercase letters, numbers, and symbols.
Alphabet(boolean includeUpper, boolean includeLower, boolean includeNum, boolean includeSym): Constructor to build the character set.
getAlphabet(): Returns the constructed character set.
Password.java
Password: Manages passwords and calculates their strength.
Password(String password): Constructor to initialize the password.
calculateScore(): Evaluates and returns the strength score of the password.
EncryptionUtils.java
EncryptionUtils: Provides encryption functionalities.
encrypt(String data, SecretKey key): Encrypts the provided data using AES encryption.
generateKey(): Generates a new AES secret key.
Generator.java
Generator: Handles the main logic of the application.
Generator(Scanner scanner): Constructor to initialize the scanner.
mainLoop(): The main interaction loop for the application.
generatePassword(int length): Generates a password based on specified criteria.
requestPassword(): Gathers user input for password criteria, generates the password, and displays the encrypted password.
checkPassword(): Checks the strength of an existing password.
printUsefulInfo(): Displays tips for creating strong passwords.
printMenu(): Displays the menu options.
printQuitMessage(): Displays a quit message.