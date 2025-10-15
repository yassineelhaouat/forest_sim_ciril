package yassine.utils;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;

class ConfigParserTest {

    @Test
    void testParseFirePositions() {
        String input = "(0,1) (2,3) (4,5)";
        int[][] result = ConfigParser.parseFirePositions(input);
        
        assertEquals(3, result.length);
        assertArrayEquals(new int[]{0, 1}, result[0]);
        assertArrayEquals(new int[]{2, 3}, result[1]);
    }

    @Test
    void testParseFirePositions_InvalidFormat() {
        String input = "(0,1,2)"; 

        assertThrows(IllegalArgumentException.class, () -> {
            ConfigParser.parseFirePositions(input);
        });
    }
}