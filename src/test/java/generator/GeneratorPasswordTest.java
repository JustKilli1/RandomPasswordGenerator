package generator;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GeneratorPasswordTest {

    @Test
    void generateRandomTwentyCharPasswordWithSpecialCharString() {
        var generator = new GeneratorPassword(20, "§\"!$%/&()=?");
        generator.generate();
    }

}