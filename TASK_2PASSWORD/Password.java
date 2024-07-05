public class Password {
    private String password;

    public Password(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return password;
    }

    public int calculateScore() {
        int score = 0;

        // Length criteria
        if (password.length() >= 8) {
            score += 2;
        } else if (password.length() >= 4) {
            score += 1;
        }

        // Uppercase letters criteria
        if (password.matches(".*[A-Z].*")) {
            score += 2;
        }

        // Lowercase letters criteria
        if (password.matches(".*[a-z].*")) {
            score += 2;
        }

        // Numbers criteria
        if (password.matches(".*[0-9].*")) {
            score += 2;
        }

        // Special characters criteria
        if (password.matches(".*[!@#$%^&*()-_=+\\\\/~?].*")) {
            score += 2;
        }

        return score;
    }
}
