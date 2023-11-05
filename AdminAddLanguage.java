import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class AdminAddLanguage extends JFrame {
    public AdminAddLanguage(LanguageCategorization categorization, Administrator adm) {
        setTitle("Add Language");
        setSize(500, 500);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());

        // Create input fields
        JTextField langNameField = new JTextField();
        JTextField regionField = new JTextField();
        JTextField descriptionField = new JTextField();
        JTextField popularityField = new JTextField();
        JTextField proficiencyLevelsField = new JTextField();
        JTextField proficiencyLevelDescriptionsField = new JTextField();

        JButton addButton = new JButton("Add Language");
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String langName = langNameField.getText();
                String region = regionField.getText();
                String description = descriptionField.getText();
                String popularity = popularityField.getText();

                // Split the proficiency levels and descriptions
                String[] proficiencyLevelsArray = proficiencyLevelsField.getText().split(",");
                String[] proficiencyLevelDescriptionsArray = proficiencyLevelDescriptionsField.getText().split(",");

                // Convert arrays to ArrayLists
                ArrayList<String> proficiencyLevels = new ArrayList<>();
                ArrayList<String> proficiencyLevelDescriptions = new ArrayList<>();
                for (String level : proficiencyLevelsArray) {
                    proficiencyLevels.add(level.trim());
                }
                for (String description_l : proficiencyLevelDescriptionsArray) {
                    proficiencyLevelDescriptions.add(description_l.trim());
                }

                // Call the AddLanguage function
                adm.AddLanguage(categorization, langName, region, description, popularity, proficiencyLevels, proficiencyLevelDescriptions);

                // Show a success message
                JOptionPane.showMessageDialog(null, "Language added successfully.");

                // Close the AdminAddLanguage window
                dispose();
            }
        });

        // Add components to the panel
        panel.add(new JLabel("Language Name:"), BorderLayout.NORTH);
        panel.add(langNameField, BorderLayout.NORTH);
        panel.add(new JLabel("Region:"), BorderLayout.CENTER);
        panel.add(regionField, BorderLayout.CENTER);
        panel.add(new JLabel("Description:"), BorderLayout.CENTER);
        panel.add(descriptionField, BorderLayout.CENTER);
        panel.add(new JLabel("Popularity:"), BorderLayout.CENTER);
        panel.add(popularityField, BorderLayout.CENTER);
        panel.add(new JLabel("Proficiency Levels (comma-separated):"), BorderLayout.CENTER);
        panel.add(proficiencyLevelsField, BorderLayout.CENTER);
        panel.add(new JLabel("Proficiency Level Descriptions (comma-separated):"), BorderLayout.CENTER);
        panel.add(proficiencyLevelDescriptionsField, BorderLayout.CENTER);
        panel.add(addButton, BorderLayout.SOUTH);

        add(panel);

        setVisible(true);
    }
}
