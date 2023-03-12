package model;

import generator.GeneratorPassword;

public class PasswordGeneratorModel {

    public String generatePassword(int length, String specialChars) {
        GeneratorPassword generator = new GeneratorPassword(length, specialChars);
        return generator.generate();
    }

}
