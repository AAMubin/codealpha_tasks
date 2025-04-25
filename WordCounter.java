import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class WordCounter {

    public static void main(String[] args) {
        // Create the main application window
        JFrame window = new JFrame("Simple Word Counter");
        window.setSize(500, 400);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setLayout(new BorderLayout(8, 8));

        // Text input area
        JTextArea inputArea = new JTextArea();
        inputArea.setLineWrap(true);
        inputArea.setWrapStyleWord(true);
        JScrollPane scroll = new JScrollPane(inputArea);

        // Result display
        JLabel outputLabel = new JLabel("Words: 0");

        // Count button
        JButton calculateBtn = new JButton("Calculate");

        // Button event
        calculateBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String text = inputArea.getText();
                int count = countWords(text);
                outputLabel.setText("Words: " + count);
            }
        }
        );

        // Panel for button and result
        JPanel controlPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        controlPanel.add(calculateBtn);
        controlPanel.add(outputLabel);

        // Adding everything to the window
        window.add(new JLabel("Type or paste your text below:"), BorderLayout.NORTH);
        window.add(scroll, BorderLayout.CENTER);
        window.add(controlPanel, BorderLayout.SOUTH);

        // Show the window
        window.setVisible(true);
    }

    // Method to count words in a given string
    private static int countWords(String text) {
        if (text == null || text.trim().isEmpty()) {
            return 0;
        }
        String[] wordArray = text.trim().split("\\s+");
        return wordArray.length;
    }
}
