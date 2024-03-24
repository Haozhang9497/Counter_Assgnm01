import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * this is to test the CounterModel class implementation
 * @author Hao Zhang
 * @version 1.0.0
 */

@DisplayName("Test CounterModel implementation")
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class CounterModelTest {
    private CounterModel model;

    @BeforeEach
    public void setUp() {
        model = new CounterModel();
    }
    @Test
    @DisplayName("test with none input")
    public final void testWithNoneInput() {
        model.processInput("");
        assertEquals(0, model.getLineCount());
        assertEquals(0, model.getWordCount());
        assertEquals(0, model.getCharCount());
        assertEquals(0, model.getDigitCount());
    }

    @Test
    @DisplayName("test with four enters")
    public final void testWithFourEnters() {
        model.processInput("\n\n\n\n");
        assertEquals(5, model.getLineCount());
        assertEquals(0, model.getWordCount());
        assertEquals(4, model.getCharCount());
        assertEquals(0, model.getDigitCount());
    }

    @Test
    @DisplayName("test with normal input")
    public final void testWithNormalInput() {
        model.processInput("Hello World!\nSince 2022");
        assertEquals(2, model.getLineCount());
        assertEquals(3, model.getWordCount());
        assertEquals(23, model.getCharCount());
        assertEquals(4, model.getDigitCount());
    }


}

