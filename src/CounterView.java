import javafx.scene.control.Button;
import javafx.scene.layout.*;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.ToolBar;

/**
 * this class acts as View
 * it provides the appearance of the application
 * the GUI contains an upper statusBar, a textarea to receive user's input, and some labels to display text processing results
 * it provides getter methods of the GUI component for the Controller to manipulate
 */
public class CounterView extends VBox{
    private TextArea textInput;     // For the user's input text.
    private Label lineCountLabel;	// label displaying the line counts
    private Label wordCountLabel;	// label displaying the word counts
    private Label charCountLabel;	// label displaying the char counts
    private Label digitCountLabel;	// label displaying the digit counts
    private ToolBar statusBar;		// including some prompting messages to the user
    private Button countButton;		// the button triggers the counting process

    public CounterView(){

        // to initialize the user input textarea
        textInput = new TextArea();
        textInput.setPrefRowCount(20);
        textInput.setPrefColumnCount(50);

        // to initialize the line count label
        lineCountLabel = new Label("  Number of lines:");
        lineCountLabel.setStyle("-fx-text-fill: green; -fx-font: italic bold 16pt serif;-fx-padding: 4px;-fx-background-color: white");
        lineCountLabel.setMaxWidth(1000);

        // to initialize the word count label
        wordCountLabel = new Label("  Number of words:");
        wordCountLabel.setStyle("-fx-text-fill: red; -fx-font: italic bold 16pt serif;-fx-padding: 4px;-fx-background-color: white");
        wordCountLabel.setMaxWidth(1000);

        // to initialize the char count label
        charCountLabel = new Label("  Number of chars:");
        charCountLabel.setStyle("-fx-text-fill: blue; -fx-font: italic bold 16pt serif;-fx-padding: 4px;-fx-background-color: white");
        charCountLabel.setMaxWidth(1000);

        // to initialize the digit count label
        digitCountLabel = new Label("  Number of digits:");
        digitCountLabel.setStyle("-fx-text-fill: black; -fx-font: italic bold 16pt serif;-fx-padding: 4px;-fx-background-color: white");
        digitCountLabel.setMaxWidth(1000);

        // to initialize the status bar
        statusBar = createStatusBar();

        // to initialize the button
        countButton = new Button("process the text");
        countButton.setStyle("-fx-background-color: darkslateblue; -fx-text-fill: white;");

        // to set up a layout holding all the elements above
        this.setSpacing(6);
        this.setStyle("-fx-background-color: lightgrey; -fx-border-color: grey; -fx-border-width:5px");
        this.getChildren().addAll(new BorderPane(statusBar), textInput, new BorderPane(countButton),
                lineCountLabel, wordCountLabel, charCountLabel, digitCountLabel);
    }

    /**
     * @return user input node
     */
    public TextArea getUserInput(){
        return textInput;
    }

    /**
     * @return count button
     */
    public Button getCountButton(){
        return countButton;
    }

    /**
     * @return line counter label
     */
    public Label getLineCountLabel(){
        return lineCountLabel;
    }

    /**
     * @return word count label
     */
    public Label getWordCountLabel(){
        return wordCountLabel;
    }

    /**
     * @return char count label
     */
    public Label getCharCountLabel(){
        return charCountLabel;
    }

    /**
     * @return char digit label
     */
    public Label getDigitCountLabel(){
        return digitCountLabel;
    }


    /**
     * to create a status bar prompting user's input and quitting the app
     * @return a ToolBar object containing prompt info
     */
    private ToolBar createStatusBar() {
        statusBar = new ToolBar();

        // statusBar has three parts: an inputPromptLabel, a pane (to fill the room) and an exitPromptLabel
        Label inputPromptLabel = new Label("Type your Text here");
        inputPromptLabel.setStyle("-fx-text-fill: black; -fx-font: bold 12pt serif;-fx-padding: 4px;");

        // the pane is empty only use to occupy the place.
        // to set it to grow horizontally to fill all available room.
        Pane pane = new Pane();
        HBox.setHgrow(pane, Priority.ALWAYS);

        Label exitPromptLabel = new Label("Press Esc to Exit");

        // using the pane to make the statusBar have proper alignment
        statusBar.getItems().addAll(inputPromptLabel, pane, exitPromptLabel);

        return statusBar;
    }
}
