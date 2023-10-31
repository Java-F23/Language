import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;

public class AddCourseMaterialsFrame extends JFrame {

    public AddCourseMaterialsFrame(Administrator admin, LanguageCategorization categorization) {
        //this.categorization = categorization;

        setTitle("Add Course and Materials");
        setSize(400, 300);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel contentPanel = new JPanel();
        GridBagLayout gridBagLayout = new GridBagLayout();
        contentPanel.setLayout(gridBagLayout);
        // Create and add components (text fields, labels, buttons) here

        // Language Name
        JTextField langNameField = new JTextField(20);
        JLabel langNameLabel = new JLabel("Language Name: ");
        JPanel langNamePanel = new JPanel();
        langNamePanel.add(langNameLabel);
        langNamePanel.add(langNameField);

        // Course Name
        JTextField courseNameField = new JTextField(20);
        JLabel courseNameLabel = new JLabel("Course Name: ");
        JPanel courseNamePanel = new JPanel();
        courseNamePanel.add(courseNameLabel);
        courseNamePanel.add(courseNameField);



        // Level
        JTextField levelField = new JTextField(20);
        JLabel levelLabel = new JLabel("Level: ");
        JPanel levelPanel = new JPanel();
        levelPanel.add(levelLabel);
        levelPanel.add(levelField);

        // Books
        JTextField booksField = new JTextField(20);
        JLabel booksLabel = new JLabel("Books (comma-separated): ");
        JPanel booksPanel = new JPanel();
        booksPanel.add(booksLabel);
        booksPanel.add(booksField);

        // Videos
        JTextField videosField = new JTextField(20);
        JLabel videosLabel = new JLabel("Videos (comma-separated): ");
        JPanel videosPanel = new JPanel();
        videosPanel.add(videosLabel);
        videosPanel.add(videosField);

        // Exercises
        JTextField exercisesField = new JTextField(20);
        JLabel exercisesLabel = new JLabel("Exercises (comma-separated): ");
        JPanel exercisesPanel = new JPanel();
        exercisesPanel.add(exercisesLabel);
        exercisesPanel.add(exercisesField);

        JButton submitButton = new JButton("Submit");
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Retrieve values from text fields
                String langName = langNameField.getText();
                String courseName = courseNameField.getText();
                String level = levelField.getText();
                String books = booksField.getText();
                String videos = videosField.getText();
                String exercises = exercisesField.getText();

                // Check if the language exists
                ArrayList<Language> filteredLanguages = categorization.filterByLanguage(langName);
                if (!filteredLanguages.isEmpty()) {
                    // Language exists, add course and materials
                    Language language = filteredLanguages.get(0);
                    Course newCourse = new Course(courseName, level);

                    // Convert materials to ArrayLists
                    ArrayList<String> booksList = new ArrayList<>(Arrays.asList(books.split(",")));
                    ArrayList<String> videosList = new ArrayList<>(Arrays.asList(videos.split(",")));
                    ArrayList<String> exercisesList = new ArrayList<>(Arrays.asList(exercises.split(",")));

                    // Add course and materials
                    admin.AddCourse(categorization, langName, courseName, level);
                    admin.AddMaterials(language, newCourse, booksList, videosList, exercisesList);

                    // Display success message
                    JOptionPane.showMessageDialog(null, "Course and materials added successfully!");
                } else {
                    // Language doesn't exist, display a message
                    JOptionPane.showMessageDialog(null, "Language does not exist. Please add the language first.");
                }

                // Close the frame
                dispose();
            }
        });
        GridBagConstraints constraints = new GridBagConstraints();

        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.insets = new Insets(10, 0, 0, 0); // Add space between buttons and label
        constraints.fill = GridBagConstraints.HORIZONTAL;

        contentPanel.add(langNamePanel, constraints);
        constraints.gridy = 3;
        contentPanel.add(courseNamePanel, constraints);
        constraints.gridy = 6;
        contentPanel.add(levelPanel, constraints);
        constraints.gridy = 9;
        contentPanel.add(booksPanel, constraints);
        constraints.gridy = 12;
        contentPanel.add(videosPanel, constraints);
        constraints.gridy = 15;
        contentPanel.add(exercisesPanel, constraints);
        constraints.gridy = 18;
        contentPanel.add(submitButton, constraints);
        JScrollPane ALTO = new JScrollPane(contentPanel);

        setContentPane(ALTO);
        setVisible(true);
    }
}
