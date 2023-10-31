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
                // You can open a new window or dialog for this option
            }
        });
        buttonPanel.add(viewLearnerDataButton);

        // Button for "Add Language"
        JButton addLanguageButton = new JButton("Add Language");
        addLanguageButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Implement the functionality for adding a new language
                // You can open a new window or dialog for this option
            }
        });
        buttonPanel.add(addLanguageButton);

        // Button for "Add Course"
        JButton addCourseButton = new JButton("Add Course");
        addCourseButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AddCourseMaterialsFrame a = new AddCourseMaterialsFrame(adm, cat);
            }
        });
        buttonPanel.add(addCourseButton);

        contentPanel.add(buttonPanel, BorderLayout.CENTER);

        setContentPane(contentPanel);
        setVisible(true);
    }

    /*public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            AdminOptions adminOptions = new AdminOptions();
            adminOptions.setVisible(true);
        });
    }*/
}
