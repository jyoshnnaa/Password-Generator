import java.util.Random;

public class PasswordGenerator {
    public static void main(String[] args) {
        int length = 12;  
        String password = generatePassword(length);
        System.out.println("Generated Password: " + password);
    }

    public static String generatePassword(int length) {
        String uppercase = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String lowercase = "abcdefghijklmnopqrstuvwxyz";
        String digits = "0123456789";
        String specialCharacters = "!@#$%^&*()-_=+[]{}|;:,.<>?/";
        
        String allCharacters = uppercase + lowercase + digits + specialCharacters;
        
        Random random = new Random();
        StringBuilder password = new StringBuilder();

        password.append(uppercase.charAt(random.nextInt(uppercase.length())));
        password.append(lowercase.charAt(random.nextInt(lowercase.length())));
        password.append(digits.charAt(random.nextInt(digits.length())));
        password.append(specialCharacters.charAt(random.nextInt(specialCharacters.length())));

        for (int i = password.length(); i < length; i++) {
            password.append(allCharacters.charAt(random.nextInt(allCharacters.length())));
        }

        return shuffleString(password.toString());
    }

    public static String shuffleString(String input) {
        Random random = new Random();
        StringBuilder shuffledString = new StringBuilder(input);
        
        for (int i = 0; i < shuffledString.length(); i++) {
            int j = random.nextInt(shuffledString.length());
            char temp = shuffledString.charAt(i);
            shuffledString.setCharAt(i, shuffledString.charAt(j));
            shuffledString.setCharAt(j, temp);
        }

        return shuffledString.toString();
    }
}


