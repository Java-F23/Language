import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class RemoveLanguagePage extends JFrame {
    private ArrayList<Course> selectedCourses = new ArrayList<>();
    private ArrayList<Language> selectedLanguages = new ArrayList<>();

    public RemoveLanguagePage(LanguageCategorization categorization) {
        setTitle("Remove Language");
        setSize(800, 600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        // Create a panel for the content
        JPanel contentPanel = new JPanel();
        contentPanel.setLayout(new BorderLayout());

        // Create a label for the title
        JLabel titleLabel = new JLabel("Select a Language to Enroll");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 20));
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        contentPanel.add(titleLabel, BorderLayout.NORTH);

        // Create a scroll pane for language selection
        JScrollPane scrollPane = new JScrollPane();
        contentPanel.add(scrollPane, BorderLayout.CENTER);

        // Create a panel for the language selection
        JPanel languagePanel = new JPanel();
        languagePanel.setLayout(new BoxLayout(languagePanel, BoxLayout.Y_AXIS));
        scrollPane.setViewportView(languagePanel);

        // Get available languages
        Language[] availableLanguages = categorization.getAvailableLanguages();

        for (Language language : availableLanguages) {
            // Create a label for the language
            JLabel languageLabel = new JLabel(language.getName());
            languageLabel.setFont(new Font("Arial", Font.BOLD, 16));
            languagePanel.add(languageLabel);

                JRadioButton radioButton = new JRadioButton();
                radioButton.setActionCommand(language.getName());
                languagePanel.add(radioButton);

                radioButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if (radioButton.isSelected()) {
                            // Check if the user is allowed to enroll
                            selectedLanguages.add(language);
                        }
                        else {
                            // If the radio button is deselected, remove the course from the selection
                            selectedLanguages.remove(language);
                        }
                    }
                });

        }

        // Create an "Enroll" button
        JButton enrollButton = new JButton("Confirm");
        enrollButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Handle the deletion here
                for (Language language_l : selectedLanguages) {
                    categorization.removeLanguage(language_l);
                }
                // You can update the UI or show a confirmation message
                JOptionPane.showMessageDialog(null, "Removal completed.");
            }
        });

        contentPanel.add(enrollButton, BorderLayout.SOUTH);

        setContentPane(contentPanel);
        setVisible(true);
    }
}



