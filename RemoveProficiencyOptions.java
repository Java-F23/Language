import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RemoveProficiencyOptions extends JFrame{
    //functions used in each page
    //void removeLanguage(Language language) in LanguageCategorization
    //public void removeProficiencyLevel(String level) in Language
    public RemoveProficiencyOptions(LanguageCategorization cat)
    {
        setTitle("Removal Options");
        setSize(800, 600);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        // Create a panel for the content
        JPanel contentPanel = new JPanel(new BorderLayout());

        // Create a title label
        JLabel titleLabel = new JLabel("Select preferred method:");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 20));
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        contentPanel.add(titleLabel, BorderLayout.NORTH);

        JPanel buttonPanel = new JPanel(new FlowLayout());

        JButton RemoveLanguage = new JButton("Remove Language");
        JButton RemoveLevel = new JButton("Remove Proficiency Level");

        RemoveLanguage.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                RemoveLanguagePage RLangP = new RemoveLanguagePage(cat);
                RLangP.setVisible(true);

            }
        });
        buttonPanel.add(RemoveLanguage);

        RemoveLevel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                RemoveLevelPage RLP = new RemoveLevelPage(cat);
                RLP.setVisible(true);
            }
        });
        buttonPanel.add(RemoveLevel);




    }
}
