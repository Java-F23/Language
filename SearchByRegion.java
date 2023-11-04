import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashSet;
import java.util.Set;

public class SearchByRegion extends JFrame {
    private JLabel titleLabel;
    private JComboBox<String> regionComboBox;
    private JButton searchButton;
    private JTextArea resultTextArea;

    public SearchByRegion(LanguageCategorization categorization) {
        setTitle("Search By Region");
        setSize(400, 300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        // Create components
        titleLabel = new JLabel("Select a Region or Enter a Region Name");
        regionComboBox = new JComboBox<>(getAvailableRegions(categorization));
        searchButton = new JButton("Search");
        resultTextArea = new JTextArea(10, 30);
        resultTextArea.setEditable(false); // Make the text area read-only

        // Create a panel for the content
        JPanel contentPanel = new JPanel();
        contentPanel.setLayout(new BorderLayout());

        // Create a panel for input fields
        JPanel inputPanel = new JPanel(new GridLayout(2, 2));
        inputPanel.add(new JLabel("Select a Region:"));
        inputPanel.add(regionComboBox);
        inputPanel.add(new JLabel("Or Enter a Region Name:"));
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
                String selectedRegion = (String) regionComboBox.getSelectedItem();
                String enteredRegion = selectedRegion;
                if (enteredRegion == null) {
                    enteredRegion = "";
                }

                Language[] result = categorization.getLanguagesByRegion(enteredRegion);

                // Display the result in the text area
                resultTextArea.setText("Search Results:\n");
                if (result.length == 0) {
                    resultTextArea.append("No matching languages found.");
                } else {
                    for (Language language : result) {
                        resultTextArea.append("Language Name: " + language.getName() + "\n");
                        resultTextArea.append("Region: " + language.getRegion() + "\n");
                        resultTextArea.append("\n");
                    }
                }
            }
        });
    }

    private String[] getAvailableRegions(LanguageCategorization categorization) {
        // Get all available regions from the list of languages
        Set<String> regions = new HashSet<>();
        for (Language language : categorization.getAvailableLanguages()) {
            regions.add(language.getRegion());
        }

        // Convert the set to an array of unique regions
        return regions.toArray(new String[0]);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            // You can create an instance of LanguageCategorization and pass it to the constructor
            // of SearchByRegion to test the functionality.
            // Example:
            // LanguageCategorization categorization = new LanguageCategorization();
            // SearchByRegion searchPage = new SearchByRegion(categorization);
            // searchPage.setVisible(true);
        });
    }
}
