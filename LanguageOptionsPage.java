import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class LanguageOptionsPage extends JFrame {
    public LanguageOptionsPage(LanguageCategorization categorization) {
        setTitle("Language Options");
        setSize(500, 500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.insets = new Insets(5, 5, 5, 5);
        panel.setBackground(Color.WHITE);

        JLabel label = new JLabel("Enter Language Name:");
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.gridwidth = 2;
        panel.add(label, constraints);

        JTextField textField = new JTextField(20);
        constraints.gridx = 0;
        constraints.gridy = 1;
        constraints.gridwidth = 2;
        panel.add(textField, constraints);

        JButton searchByLanguageButton = new JButton("Search");  //By Language
        constraints.gridx = 0;
        constraints.gridy = 2;
        constraints.gridwidth = 2;
        panel.add(searchByLanguageButton, constraints);

        JTextArea resultTextArea = new JTextArea(10, 40);
        JScrollPane scrollPane = new JScrollPane(resultTextArea);
        constraints.gridx = 0;
        constraints.gridy = 3;
        constraints.gridwidth = 2;
        panel.add(scrollPane, constraints);

        searchByLanguageButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String input = textField.getText();

                Language [] filteredLanguages = categorization.filterByLanguage(input);

                if (filteredLanguages.length == 0) {
                    resultTextArea.setText("No languages found for the specified name.");
                } else {
                    StringBuilder resultText = new StringBuilder("Filtered Languages:\n");
                    for (Language language : filteredLanguages) {
                        resultText.append(language.getName()).append("\n");
                        resultText.append("Proficiency Levels and Descriptions:\n");
                        for (String level : language.getProficiencyLevels()) {
                            resultText.append(level).append("- \n").append(language.getProficiencyLevelDescription(level)).append("\n");
                        }
                    }
                    resultTextArea.setText(resultText.toString());
                }
            }
        });

        setContentPane(panel);
    }
}
