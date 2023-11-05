import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LanguageProficiencySearchPage extends JFrame {
    private JLabel titleLabel;
    private JTextField languageNameField;
    private JTextField proficiencyLevelField;
    private JButton searchButton;
    private JTextArea resultTextArea;

    public LanguageProficiencySearchPage(LanguageCategorization categorization) {
        setTitle("Language and Proficiency Level Search");
        setSize(400, 300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        // Create components
        titleLabel = new JLabel("Enter Language and Proficiency Level");
        languageNameField = new JTextField(20);
        proficiencyLevelField = new JTextField(20);
        searchButton = new JButton("Search");
        resultTextArea = new JTextArea(10, 30);
        resultTextArea.setEditable(false); // Make the text area read-only

        // Create a panel for the content
        JPanel contentPanel = new JPanel();
        contentPanel.setLayout(new BorderLayout());

        // Create a panel for input fields
        JPanel inputPanel = new JPanel(new GridLayout(3, 2));
        inputPanel.add(new JLabel("Language Name:"));
        inputPanel.add(languageNameField);
        inputPanel.add(new JLabel("Proficiency Level:"));
        inputPanel.add(proficiencyLevelField);
        inputPanel.add(new JLabel()); // Empty label for spacing
        inputPanel.add(searchButton);

        // Create a scroll pane for the result text area
        JScrollPane scrollPane = new JScrollPane(resultTextArea);

        // Add components to the content panel
        contentPanel.add(titleLabel, BorderLayout.NORTH);
        contentPanel.add(inputPanel, BorderLayout.CENTER);
        contentPanel.add(scrollPane, BorderLayout.SOUTH);

        // Add content panel to the frame
        setContentPane(contentPanel);

        // Add an action listener to the search button
        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String languageName = languageNameField.getText();
                String proficiencyLevel = proficiencyLevelField.getText();

                Language[] result = categorization.filterByLanguageAndProficiency(languageName, proficiencyLevel);

                // Display the result in the text area
                resultTextArea.setText("Search Results:\n");
                if (result.length == 0) {
                    resultTextArea.append("No matching languages found.");
                } else {
                    for (Language language : result) {
                        resultTextArea.append("Language Name: " + language.getName() + "\n");
                        resultTextArea.append("Proficiency Levels: " + String.join(", ", language.getProficiencyLevels()) + "\n");
                        resultTextArea.append("\n");
                    }
                }
            }
        });
    }
}
