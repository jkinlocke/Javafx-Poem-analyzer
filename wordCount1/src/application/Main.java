package application;
	
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.*;

public class Main extends Application {
    private TextArea outputTextArea;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Text Analyzer");

        // Create the TextArea to display the output
        outputTextArea = new TextArea();
        outputTextArea.setPrefSize(400, 350);
        outputTextArea.setEditable(false);

        // Create the Button to trigger the text analysis
        Button analyzeButton = new Button("Analyze");
        analyzeButton.setOnAction(event -> analyzeText());

        // Create the root layout
        VBox root = new VBox(10);
        root.setPadding(new Insets(10));
        root.getChildren().addAll(outputTextArea, analyzeButton);

        primaryStage.setScene(new Scene(root, 400, 500));
        primaryStage.show();
    }

    private void analyzeText() {
        try {
            // Get the URL of the web page containing the file to be read
            String urlStr = "https://www.gutenberg.org/files/1065/1065-h/1065-h.htm";
            URL url = new URL(urlStr);

            // Create a BufferedReader to read the web page line by line
            BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream()));

            // Ignore all text before the start of the poem
            String line;
            boolean inPoem = false;
            while ((line = reader.readLine()) != null) {
                if (line.contains("*** START OF THE PROJECT GUTENBERG EBOOK THE RAVEN ***")) {
                    inPoem = true;
                    break;
                }
            }

            // Read the poem's content and ignore all text after the end of the poem
            StringBuilder poemBuilder = new StringBuilder();
            while ((line = reader.readLine()) != null) {
                if (line.contains("Shall be lifted—nevermore!")) {
                    break;
                }
                poemBuilder.append(line).append("\n");
            }
            String poem = poemBuilder.toString();

            // Remove all HTML tags
            poem = poem.replaceAll("<.*?>", "");

            // Tokenize the poem's content into words
            StringTokenizer tokenizer = new StringTokenizer(poem, " \t\n\r\f.,;:!?\"'-()[]{}");

            // Count the frequency of each word
            Map<String, Integer> wordFreqs = new HashMap<>();
            while (tokenizer.hasMoreTokens()) {
                String word = tokenizer.nextToken().toLowerCase();
                Integer freq = wordFreqs.get(word);
                wordFreqs.put(word, freq == null ? 1 : freq + 1);
            }

            // Sort the words by frequency
            List<Map.Entry<String, Integer>> wordList = new ArrayList<>(wordFreqs.entrySet());
            Collections.sort(wordList, (a, b) -> b.getValue().compareTo(a.getValue()));

            // Update the TextArea with the word frequency statistics
            StringBuilder outputBuilder = new StringBuilder();
            for (Map.Entry<String, Integer> entry : wordList) {
                outputBuilder.append(entry.getKey()).append(": ").append(entry.getValue()).append("\n");
            }
            outputTextArea.setText(outputBuilder.toString());

            // Close the reader
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

