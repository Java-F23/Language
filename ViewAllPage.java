import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class ViewAllPage extends JFrame {
    public ViewAllPage(LanguageCategorization cat) {
        setTitle("View All Page");
        setSize(800, 600);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        Language[] available = cat.getAvailableLanguages();

        // Create a panel for the content
        JPanel contentPanel = new JPanel();
        contentPanel.setLayout(new BoxLayout(contentPanel, BoxLayout.Y_AXIS));

        // Create a title label
        JLabel titleLabel = new JLabel("Languages and courses available:");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 20));
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        contentPanel.add(titleLabel);

        // Create a scroll pane for the content
        JScrollPane scrollPane = new JScrollPane(contentPanel);
        contentPanel.setAutoscrolls(true);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

        // Add the scroll pane to the frame
        setContentPane(scrollPane);

        for (Language language : available) {
            TextObject languageLabel = new TextObject(language.getName(), Font.getFont("Arial"), Color.BLACK, 25);
            JLabel descriptionLabel = new JLabel(language.getDescription());
            JLabel proficiencyLabel = new JLabel("Proficiency levels:");
            contentPanel.add(languageLabel.createLabel());
            contentPanel.add(descriptionLabel);
            contentPanel.add(proficiencyLabel);

            for (String proficiencyLevel : language.getProficiencyLevels()) {
                JLabel proficiencyLevelLabel = new JLabel("-" + proficiencyLevel);
                contentPanel.add(proficiencyLevelLabel);
            }
        }

        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            ArrayList<String> plE = new ArrayList<>();
            plE.add("Beginner");
            plE.add("Intermediate");
            plE.add("Advanced");

            ArrayList<String> DescELevels = new ArrayList<>();
            DescELevels.add("An introduction to basic grammatical techniques.");
            DescELevels.add("Learning basic conversational techniques, and learning reading through small books.");
            DescELevels.add("The most advanced level, involving listening, reading, writing and speaking.");

            ArrayList<String> plJ = new ArrayList<>();
            plJ.add("N1");
            plJ.add("N2");
            plJ.add("N3");
            plJ.add("N4");
            plJ.add("N5");
            Language eng = new Language("English", plE, "America", "This is English's description.",
                    10, DescELevels);
            Language Jap = new Language("Japanese", plJ, "Asia", "Very popular language due to a worldwide increase in media consumption.", 8);
            LanguageCategorization cat = new LanguageCategorization();
            cat.addLanguage(eng);
            cat.addLanguage(Jap);
            ViewAllPage v = new ViewAllPage(cat);
            v.setVisible(true);
        });
    }
}
