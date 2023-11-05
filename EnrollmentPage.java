import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class EnrollmentPage extends JFrame {
    private ArrayList<Course> selectedCourses = new ArrayList<>();
    private ArrayList<Language> selectedLanguages = new ArrayList<>();

    private LanguageCategorization categorization;

    public EnrollmentPage(LanguageCategorization categorization, Learner learner) {
        this.categorization = categorization;
        setTitle("Enrollment Page");
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

            // Create a panel for proficiency levels
            JPanel proficiencyPanel = new JPanel();
            proficiencyPanel.setLayout(new BoxLayout(proficiencyPanel, BoxLayout.Y_AXIS));

            // Get proficiency levels for the language
            ArrayList<String> proficiencyLevels = language.getProficiencyLevels();

            for (String proficiencyLevel : proficiencyLevels) {
                // Create a radio button for the proficiency level
                JRadioButton radioButton = new JRadioButton(proficiencyLevel);
                radioButton.setActionCommand(proficiencyLevel);
                proficiencyPanel.add(radioButton);

                radioButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if (radioButton.isSelected()) {
                            // Check if the user is allowed to enroll
                            if (selectedCourses.size() < 3 && !selectedLanguages.contains(language.getName())) {
                                selectedCourses.add(language.getCourseByProficiency(radioButton.getText()));
                                selectedLanguages.add(language);
                            } else {
                                // Display an error message if the user is not allowed to enroll
                                radioButton.setSelected(false); // Deselect the radio button
                                JOptionPane.showMessageDialog(null, "You have reached the enrollment limit or already enrolled in a course for this language.");
                            }
                        } else {
                            // If the radio button is deselected, remove the course from the selection
                            selectedCourses.remove(language.getCourseByProficiency(radioButton.getText()));
                            selectedLanguages.remove(language.getName());
                        }
                    }
                });

                // Create a label for proficiency level description
                JLabel descriptionLabel = new JLabel(language.getProficiencyLevelDescription(proficiencyLevel));
                descriptionLabel.setFont(new Font("Arial", Font.PLAIN, 14));
                proficiencyPanel.add(descriptionLabel);
            }

            languagePanel.add(proficiencyPanel);
        }

        //An "Enroll" button
        JButton enrollButton = new JButton("Enroll");
        enrollButton.setToolTipText("Make sure you have: only selected one course in a Language, selected a maximum of 3 courses!");

        enrollButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Handle the enrollment here
                int index;
                for (Language language_l : selectedLanguages) {
                    index = selectedLanguages.indexOf(language_l);
                    learner.Enroll(categorization, language_l.getName(), language_l.getCourseByProficiency(selectedCourses.get(index).getName()).getName());
                }
                // You can update the UI or show a confirmation message
                JOptionPane.showMessageDialog(null, "Enrollment completed.");
            }
        });

        contentPanel.add(enrollButton, BorderLayout.SOUTH);

        setContentPane(contentPanel);
        setVisible(true);
    }
}

