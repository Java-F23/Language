import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EnrollmentDialog extends JDialog {
    private JCheckBox enrollCheckbox;
    private JCheckBox addToFavoritesCheckbox;
    private JButton okayButton;

    public EnrollmentDialog(JFrame parent, String languageName) {
        super(parent, "Enrollment Options for " + languageName, true);
        initializeComponents();
        createLayout();
        setSize(300, 150);
        setLocationRelativeTo(parent);
    }

    private void initializeComponents() {
        enrollCheckbox = new JCheckBox("Enroll");
        addToFavoritesCheckbox = new JCheckBox("Add to Favorites");
        okayButton = new JButton("Okay");

        okayButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Perform actions based on checkbox selections
                boolean enrollSelected = enrollCheckbox.isSelected();
                boolean addToFavoritesSelected = addToFavoritesCheckbox.isSelected();

                System.out.println("Enroll selected: " + enrollSelected);
                System.out.println("Add to Favorites selected: " + addToFavoritesSelected);

                // Close the dialog
                dispose();
            }
        });
    }

    private void createLayout() {
        setLayout(new GridLayout(3, 1));
        add(enrollCheckbox);
        add(addToFavoritesCheckbox);
        add(okayButton);
    }

    public static void main(String[] args) {
        // Test the dialog
        JFrame frame = new JFrame();
        JButton openDialogButton = new JButton("Open Dialog");
        openDialogButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                EnrollmentDialog dialog = new EnrollmentDialog(frame, "English");
                dialog.setVisible(true);
            }
        });

        frame.setLayout(new FlowLayout());
        frame.add(openDialogButton);
        frame.setSize(300, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
