import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class WordCounterApp extends JFrame {

    private JTextArea textArea;
    private JLabel wordCountLabel;

    public WordCounterApp() {
        super("Word Counter");

        textArea = new JTextArea();
        wordCountLabel = new JLabel("Word Count: 0");

        JButton countButton = new JButton("Count Words");
        countButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                countWords();
            }
        });

        JPanel panel = new JPanel();
        panel.add(countButton);

        JScrollPane scrollPane = new JScrollPane(textArea);

        add(scrollPane, "Center");
        add(wordCountLabel, "South");
        add(panel, "North");

        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void countWords() {
        String text = textArea.getText();
        String[] words = text.split("\\s+"); // Split the text by whitespace characters
        int wordCount = words.length;

        wordCountLabel.setText("Word Count: " + wordCount);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new WordCounterApp();
            }
        });
    }
}


