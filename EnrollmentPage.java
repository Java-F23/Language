/*import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class EnrollmentPage extends JFrame {
    public EnrollmentPage(LanguageCategorization categorization) {
        setTitle("Language Enrollment");
        setSize(400, 300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        // Create a panel for the content
        JPanel contentPanel = new JPanel();
        contentPanel.setLayout(new BorderLayout());

        // Create a label for the title
        JLabel titleLabel = new JLabel("Select a Course. Each proficiency level corresponds to a course.");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 20));
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        contentPanel.add(titleLabel, BorderLayout.NORTH);

        // Create a panel for the language selection
        JPanel languagePanel = new JPanel();
        languagePanel.setLayout(new BoxLayout(languagePanel, BoxLayout.Y_AXIS));

        // Get available languages
        Language[] availableLanguages = categorization.getAvailableLanguages();

        // Create radio buttons for each language
        ButtonGroup languageGroup = new ButtonGroup();
        for (Language language : availableLanguages) {
            JRadioButton radioButton = new JRadioButton(language.getName());
            radioButton.setActionCommand(language.getName());
            languageGroup.add(radioButton);
            languagePanel.add(radioButton);
        }

        contentPanel.add(languagePanel, BorderLayout.CENTER);

        // Create an "Enroll" button
        JButton enrollButton = new JButton("Enroll");
        enrollButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selectedLanguage = languageGroup.getSelection().getActionCommand();
                // Implement what to do when the "Enroll" button is pressed with the selected language.
                // You can retrieve the selected language using the `selectedLanguage` variable.
            }
        });

        contentPanel.add(enrollButton, BorderLayout.SOUTH);

        setContentPane(contentPanel);
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            ArrayList<String> pL5 = new ArrayList<>();
            pL5.add("Beginner");
            pL5.add("Intermediate");
            Language engl= new Language("English", pL5, "North America", "Great lang to start with!", 5);
            ArrayList<String> pL8 = new ArrayList<>();
            pL8.add("N1");
            pL8.add("N2");
            Language Chin= new Language("Chinese", pL8, "Asia", "Very complex", 9);

            LanguageCategorization lSample2 = new LanguageCategorization();
            lSample2.addLanguage(engl);
            lSample2.addLanguage(Chin);
            // You can pass your LanguageCategorization object here
            EnrollmentPage enrollmentPage = new EnrollmentPage(lSample2);
        });
    }
}*/
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
public class EnrollmentPage extends JFrame {
    public EnrollmentPage(LanguageCategorization categorization) {
        setTitle("Language Enrollment");
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
        //Saves RadioButtons selected for a specific language
        ArrayList<String> selected = new ArrayList<>();

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

                if(radioButton.isSelected())
                {
                    selected.add(radioButton.getName() + "-" + language.getName());
                }

                // Create a label for proficiency level description
                JLabel descriptionLabel = new JLabel(language.getProficiencyLevelDescription(proficiencyLevel));
                descriptionLabel.setFont(new Font("Arial", Font.PLAIN, 14));
                proficiencyPanel.add(descriptionLabel);
            }

            languagePanel.add(proficiencyPanel);
        }

        // Create an "Enroll" button
        JButton enrollButton = new JButton("Enroll");
        enrollButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Enrollment successful!");

                // Implement what to do when the "Enroll" button is pressed.
            }
        });

        contentPanel.add(enrollButton, BorderLayout.SOUTH);

        setContentPane(contentPanel);
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            ArrayList<String> pL5 = new ArrayList<>();
            pL5.add("Beginner");
            pL5.add("Intermediate");
            Language engl= new Language("English", pL5, "North America", "Great lang to start with!", 5);
            ArrayList<String> pL8 = new ArrayList<>();
            pL8.add("N1");
            pL8.add("N2");
            pL8.add("N3");
            Language Chin= new Language("Chinese", pL8, "Asia", "Very complex", 9);

            LanguageCategorization lSample2 = new LanguageCategorization();
            lSample2.addLanguage(engl);
            lSample2.addLanguage(Chin);
            // You can pass your LanguageCategorization object here
            EnrollmentPage enrollmentPage = new EnrollmentPage(lSample2);
        });
    }
}

