import javafx.stage.Stage;

/**
 * this is the Controller interface
 * it defines a method updateCounts to update the text processing result of the View
 * it defines a method to create a view and provide reference
 */
public interface CounterController {
    void updateCounts();    // to update the line,word,char and digit counts
    void createGUI(Stage stage);    // to create a view and provide reference
}
