import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class ProficiencyLevelOptionsPage extends JFrame {
    public ProficiencyLevelOptionsPage(LanguageCategorization categorization) {
        setTitle("Proficiency Level Options");
        setSize(600, 500);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.insets = new Insets(5, 5, 5, 5);
        panel.setBackground(Color.WHITE);

        JLabel label = new JLabel("Enter Proficiency Levels:"); //(comma-separated)
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.gridwidth = 2;
        panel.add(label, constraints);

        JTextField textField = new JTextField(20);
        constraints.gridx = 0;
        constraints.gridy = 1;
        constraints.gridwidth = 2;
        panel.add(textField, constraints);

        JButton searchByValueButton = new JButton("Search By Value");
        constraints.gridx = 0;
        constraints.gridy = 2;
        constraints.gridwidth = 1;
        panel.add(searchByValueButton, constraints);

        JTextArea resultTextArea = new JTextArea(10, 40);
        JScrollPane scrollPane = new JScrollPane(resultTextArea);
        constraints.gridx = 0;
        constraints.gridy = 3;
        constraints.gridwidth = 5; //2
        panel.add(scrollPane, constraints);

        searchByValueButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String input = textField.getText();
                ArrayList<String> proficiencyLevels = new ArrayList<String>();
                proficiencyLevels.add(input);

                Language[] filteredLanguages = categorization.filterByProficiencyLevels(proficiencyLevels);

                if (filteredLanguages.length == 0) {
                    resultTextArea.setText("No languages found for the specified proficiency level.");
                } else {
                    StringBuilder resultText = new StringBuilder("Filtered Languages:\n");
                    for (Language language : filteredLanguages) {
                        resultText.append(language.getName()).append(" - ").append(language.getDescription()).append("\n");
                    }
                    resultTextArea.setText(resultText.toString());
                }
            }
        });

        setContentPane(panel);
    }
}
