import javafx.embed.swing.JFXPanel;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * this is to test the CounterConcrete class implementation
 * @author Hao Zhang
 * @version 1.0.0
 */

@DisplayName("Test CounterModel implementation")
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class CounterConcreteTest {
    @BeforeEach
    public void setUp() {
        new JFXPanel();
    }

    @Test
    @DisplayName("Test updateCounts method with normal input")
    void testWithNormalInput() {
        CounterView view = new CounterView();
        CounterModel model = new CounterModel();
        CounterConcrete counter = new CounterConcrete();
        counter.view = view;
        counter.model = model;

        view.getUserInput().setText("Hello World!\nSince 2022");

        counter.updateCounts();
        assertEquals("  Number of lines:  2", view.getLineCountLabel().getText());
        assertEquals("  Number of words:  3", view.getWordCountLabel().getText());
        assertEquals("  Number of chars:  23", view.getCharCountLabel().getText());
        assertEquals("  Number of digits:  4", view.getDigitCountLabel().getText());
    }

    @Test
    @DisplayName("Test updateCounts method with none input")
    void testWithNoneInput() {
        CounterView view = new CounterView();
        CounterModel model = new CounterModel();
        CounterConcrete counter = new CounterConcrete();
        counter.view = view;
        counter.model = model;

        view.getUserInput().setText("");

        counter.updateCounts();
        assertEquals("  Number of lines:  0", view.getLineCountLabel().getText());
        assertEquals("  Number of words:  0", view.getWordCountLabel().getText());
        assertEquals("  Number of chars:  0", view.getCharCountLabel().getText());
        assertEquals("  Number of digits:  0", view.getDigitCountLabel().getText());
    }

    @Test
    @DisplayName("Test updateCounts method with four enter input")
    void testWithFourEntersInput() {
        CounterView view = new CounterView();
        CounterModel model = new CounterModel();
        CounterConcrete counter = new CounterConcrete();
        counter.view = view;
        counter.model = model;

        view.getUserInput().setText("\n\n\n\n");

        counter.updateCounts();
        assertEquals("  Number of lines:  5", view.getLineCountLabel().getText());
        assertEquals("  Number of words:  0", view.getWordCountLabel().getText());
        assertEquals("  Number of chars:  4", view.getCharCountLabel().getText());
        assertEquals("  Number of digits:  0", view.getDigitCountLabel().getText());
    }
}
