package generator;

import shared.Utils;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadLocalRandom;

public class GeneratorPassword implements IGenerator<String> {

    private int length;
    private char[] alphabet;
    private char[] specialChars;
    private int generatePasswords;
    private List<String> passwords = new ArrayList<>();

    public GeneratorPassword(int length, char[] specialChars, int generatePasswords) {
        this.length = length;
        this.specialChars = specialChars;
        this.generatePasswords = generatePasswords;
        alphabet = Utils.generateAlphabet(false);

    }

    public GeneratorPassword(int length, String specialChars, int generatePasswords) {
        this(length, specialChars.toCharArray(), generatePasswords);
    }

    private void addNewPassword(String pw) {
        System.out.println(pw);
        passwords.add(pw);
    }

    @Override
    public String generate() {
        int threads = 10;
        int generatePasswordsPerThread = generatePasswords / threads;
        int extraPasswords = generatePasswords % threads;

        ExecutorService executorService = Executors.newFixedThreadPool(threads);

        for(int i = 0; i < threads; i++) {
            executorService.execute(new Runnable() {
                @Override
                public void run() {
                    for(int z = 0; z < generatePasswordsPerThread; z++) {
                        String password = "";
                        for(int i = 0; i < length; i++) {
                            char randomChar = getRandomChar();
                            while(password.length() > 0 && password.toCharArray()[password.length() - 1] == randomChar)
                                randomChar = getRandomChar();
                            password += randomChar;
                        }
                        addNewPassword(password);
                    }
                }
            });
        }
        return "";
    }

    /**
     * Generates a Random Char.
     * To Achieve this, this Method calls two Methods that generate either a Letter or,
     * if any present in the {@code specialChars} array, a Special Character.
     * */
    private char getRandomChar() {
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
