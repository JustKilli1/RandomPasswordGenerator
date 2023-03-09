package generator;

import shared.Utils;

import java.util.concurrent.ThreadLocalRandom;

public class GeneratorPassword implements IGenerator<String> {

    private int length;
    private char[] alphabet, specialChars;

    public GeneratorPassword(int length, char[] specialChars) {
        this.length = length;
        this.specialChars = specialChars;
        alphabet = Utils.generateAlphabet(false);
    }

    public GeneratorPassword(int length, String specialChars) {
        this(length, specialChars.toCharArray());
    }

    @Override
    public String generate() {
        String password = "";
        for(int i = 0; i < length; i++) password += randomChar();
        return password;
    }

    private char randomChar() {
        if(specialChars != null && specialChars.length > 0)
            return ThreadLocalRandom.current().nextInt(0, 10) < 4 ? getRandomSpecialChar() : getRandomLetter();
        else return getRandomLetter();
    }

    private char getRandomLetter() {
        ThreadLocalRandom random = ThreadLocalRandom.current();
        char randomChar = alphabet[random.nextInt(alphabet.length)];
        return random.nextInt() % 2 == 0 ? Character.toUpperCase(randomChar) : Character.toLowerCase(randomChar);
    }

    private char getRandomSpecialChar() {
        return specialChars[ThreadLocalRandom.current().nextInt(specialChars.length)];
    }
}