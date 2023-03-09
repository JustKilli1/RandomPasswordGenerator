package shared;

public class Utils {

    public static char[] generateAlphabet(boolean capital) {
        String alphabet = "abcdefghijklmnopqrstuvwxyz";
        return capital ? alphabet.toUpperCase().toCharArray() : alphabet.toCharArray();
    }

}
