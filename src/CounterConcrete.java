import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;

/**
 * this class acts as concrete Controller
 * it communicates to the Model and View
 * it passes user's input text to Model to process and get the result from Model
 * then uses the result to update View
 */
public class CounterConcrete extends Application implements CounterController{
    CounterModel model; // data
    CounterView view;   // GUI

    public static void main(String[] args) {
        //to start a JavaFX application, call Application class static method launch(args) in the main method.
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        createGUI(stage);
        model = new CounterModel();

        Button countButton = view.getCountButton();

        /*when key is pressed, call the processInput function*/
        countButton.setOnKeyPressed( pressed -> {
            updateCounts();
        });

        /*when button is clicked, call the processInput function*/
        countButton.setOnAction( click -> {
            updateCounts();
        });

        /*when escape key is pressed close the application*/
        stage.addEventHandler(KeyEvent.KEY_RELEASED, (KeyEvent event) -> {
            if (!event.isConsumed() && KeyCode.ESCAPE == event.getCode()) {
                stage.hide();
            }
        });
    }

    /**
     * to create the views and provided each view with a reference
     * @param stage
     */
    public void createGUI(Stage stage){
        view = new CounterView();
        Scene scene = new Scene(view);
        stage.setScene(scene);
        stage.setTitle("MicrosoftWord/Word/Char/digit Counter");
        stage.setResizable(false);
        stage.show();
    }

    public void updateCounts(){
        String text = view.getUserInput().getText();
        model.processInput(text);

        view.getLineCountLabel().setText("  Number of lines:  " + model.getLineCount());
        view.getWordCountLabel().setText("  Number of words:  " + model.getWordCount());
        view.getCharCountLabel().setText("  Number of chars:  " + model.getCharCount());
        view.getDigitCountLabel().setText("  Number of digits:  " + model.getDigitCount());
    }
}
