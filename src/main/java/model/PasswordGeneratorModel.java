package model;

import generator.GeneratorPassword;

public class PasswordGeneratorModel {


    /**
     * Generate a Random Password with the given params
     * @param length Length of the Passwords
     * @param specialChars Special Character that need to be included in the new Generated Password
     * @return New Random Generated Password
     * */
    public String generatePassword(int length, String specialChars) {
        GeneratorPassword generator = new GeneratorPassword(length, specialChars);
        return generator.generate();
    }

}
