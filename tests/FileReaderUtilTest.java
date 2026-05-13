import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.Vector;


public class FileReaderUtilTest {

    @Test
    void testReadFile() {
        FileReaderUtil reader = new FileReaderUtil();

        Vector<Token> tokens = reader.ReadFile("src/resources/guategrafo.txt");

        assertNotNull(tokens);
        assertFalse(tokens.isEmpty());

        // verificar primer elemento válido
        Token t = tokens.get(0);

        assertNotNull(t.getOrigin());
        assertNotNull(t.getDestination());
        assertTrue(t.getDistance() > 0);
    }

    @Test
    void testInvalidFile() {
        FileReaderUtil reader = new FileReaderUtil();

        assertThrows(IllegalArgumentException.class, () -> {
            reader.ReadFile("archivo_que_no_existe.txt");
        });
    }
}