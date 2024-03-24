/**
 * this class acts as Model.
 * it maintains data for the application: lineCount, wordCount, charCount, digitCount
 * it also contains the method to calculate such data
 * it provides get methods for Controller to retrieve data and update the View
 */
public class CounterModel {
    private int lineCt;
    private int wordCt;
    private int charCt;
    private int digitCt;

    public int getLineCount() {
        return lineCt;
    }

    public int getWordCount() {
        return wordCt;
    }

    public int getCharCount() {
        return charCt;
    }

    public int getDigitCount() {
        return digitCt;
    }

    /**
     * to count the line, word, char, digit within one string
     * @param text the user's input in the text area, text to be processed
     */
    public void processInput(String text) {
        charCt = text.length();

        wordCt = 0;
        for (int i = 0; i < charCt; i++) {
            boolean startOfWord;
            if (Character.isLetter(text.charAt(i)) == false)
                startOfWord = false;
            else if (i == 0)
                startOfWord = true;
            else if (Character.isLetter(text.charAt(i - 1)))
                startOfWord = false;
            else if (text.charAt(i - 1) == '\'' && i > 1
                    && Character.isLetter(text.charAt(i - 2)))
                startOfWord = false;
            else
                startOfWord = true;
            if (startOfWord)
                wordCt++;
        }


        if(charCt == 0){lineCt = 0;}
        else{
            lineCt = 1;
            for (int i = 0; i < charCt; i++) {
                if (text.charAt(i) == '\n')
                    lineCt++;
            }
        }


        digitCt = 0;
        for (int i = 0; i < charCt; i++){
            if (Character.isDigit(text.charAt(i))) {
                digitCt++;
            }
        }
    }
}
