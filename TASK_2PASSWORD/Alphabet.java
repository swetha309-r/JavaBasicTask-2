public class Alphabet {
    private String alphabet;

    public Alphabet(boolean includeUpper, boolean includeLower, boolean includeNum, boolean includeSym) {
        StringBuilder sb = new StringBuilder();

        if (includeUpper) {
            sb.append("ABCDEFGHIJKLMNOPQRSTUVWXYZ");
        }
        if (includeLower) {
            sb.append("abcdefghijklmnopqrstuvwxyz");
        }
        if (includeNum) {
            sb.append("0123456789");
        }
        if (includeSym) {
            sb.append("!@#$%^&*()-_=+\\/~?");
        }

        this.alphabet = sb.toString();
    }

    public String getAlphabet() {
        return this.alphabet;
    }
}
