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
        for(int i = 0; i < length; i++) {
            char randomChar = randomChar();
            if(password.length() > 0) {
                while(password.toCharArray()[password.length() - 1] == randomChar) {
                    randomChar = randomChar();
                }
            }
            password += randomChar;
        }
        return password;
    }

    /**
     * Generates a Random Char.
     * To Achieve this, this Method calls two Methods that generate either a Letter or,
     * if any present in the {@code specialChars} array, a Special Character.
     * */
    private char randomChar() {
        if(specialChars != null && specialChars.length > 0)
            return ThreadLocalRandom.current().nextInt(0, 10) < 4 ? getRandomSpecialChar() : getRandomLetter();
        else return getRandomLetter();
    }

    /**
     * Gets a Random Letter from the {@code alphabet} array.
     * Returns it either as Upper or Lower Case char.
     * */
    private char getRandomLetter() {
        ThreadLocalRandom random = ThreadLocalRandom.current();
        char randomChar = alphabet[random.nextInt(alphabet.length)];
        return random.nextInt() % 2 == 0 ? Character.toUpperCase(randomChar) : Character.toLowerCase(randomChar);
    }

    /**
     * Gets a random Special Character from the {@code specialChars} array.
     * Notice that this Method does not check if the array is null
     * */
    private char getRandomSpecialChar() {
        return specialChars[ThreadLocalRandom.current().nextInt(specialChars.length)];
    }
}
