import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AdminOptions extends JFrame {

    public AdminOptions(Administrator adm, LanguageCategorization cat) {
        setTitle("Administrator Options");
        setSize(800, 600);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        // Create a panel for the content
        JPanel contentPanel = new JPanel(new BorderLayout());

        // Create a title label
        JLabel titleLabel = new JLabel("Administrator Options");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 20));
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        contentPanel.add(titleLabel, BorderLayout.NORTH);

        // Create a panel for buttons
        JPanel buttonPanel = new JPanel(new FlowLayout());

        // Button for "View Learner Data"
        JButton viewLearnerDataButton = new JButton("View Learner Data");
        viewLearnerDataButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Implement the functionality for viewing learner data
                //Can only be done when files are implemented
            }
        });
        buttonPanel.add(viewLearnerDataButton);

        // Button for "Add Language"
        JButton addLanguageButton = new JButton("Add Language");
        addLanguageButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AdminAddLanguage AddLanguagePage = new AdminAddLanguage(cat, adm);
                AddLanguagePage.setVisible(true);
            }
        });
        buttonPanel.add(addLanguageButton);

        // Button for "Add Course"
        JButton addCourseButton = new JButton("Add Course");
        addCourseButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AddCourseMaterialsFrame a = new AddCourseMaterialsFrame(adm, cat);
                a.setVisible(true);
            }
        });
        buttonPanel.add(addCourseButton);

        JButton RemoveProficiency = new JButton("Remove Proficiency Level");
        RemoveProficiency.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               RemoveProficiencyOptions RPO = new RemoveProficiencyOptions(cat);
               RPO.setVisible(true);
            }
        });
        buttonPanel.add(RemoveProficiency);

        contentPanel.add(buttonPanel, BorderLayout.CENTER);

        setContentPane(contentPanel);
        setVisible(true);
    }
}
