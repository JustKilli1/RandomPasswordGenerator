package generator;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GeneratorPasswordTest {

    String specialCharStr = "§\"!$%/&()=?";

    @Test
    void shouldReturnZeroCharPass() {
        var generator = new GeneratorPassword(0, "");
        String value = generator.generate();

        assertEquals(0, value.length());
        assertFalse(containsChars(specialCharStr, value));
    }

    @Test
    void shouldReturnEightyCharPass() {
        var generator = new GeneratorPassword(80, "");
        String value = generator.generate();

        assertEquals(80, value.length());
        assertFalse(containsChars(specialCharStr, value));
    }

    @Test
    void shouldReturnTwoHundredCharPass() {
        var generator = new GeneratorPassword(200, "");
        String value = generator.generate();

        assertEquals(200, value.length());
        assertFalse(containsChars(specialCharStr, value));
    }

    @Test
    void shouldReturnZeroCharPassWithSpecialChar() {
        var generator = new GeneratorPassword(0, specialCharStr);
        String value = generator.generate();

        assertEquals(0, value.length());
        assertFalse(containsChars(specialCharStr, value));
    }

    @Test
    void shouldReturnEightyCharPassWithSpecialChar() {
        var generator = new GeneratorPassword(80, specialCharStr);
        String value = generator.generate();

        assertEquals(80, value.length());
    }

    @Test
    void shouldReturnTwoHundredCharPassWithSpecialChar() {
        var generator = new GeneratorPassword(200, specialCharStr);
        String value = generator.generate();
        assertEquals(200, value.length());
    }

    boolean containsChars(String sequence, String target) {
        for(char seqChar : sequence.toCharArray()) {
            for(char tarChar : target.toCharArray()) {
                if(tarChar == seqChar) return true;
            }
        }
        return false;
    }

}