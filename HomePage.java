    import javax.swing.*;
    import java.awt.*;
    import java.awt.event.ActionEvent;
    import java.awt.event.ActionListener;
    import java.util.ArrayList;

    public class HomePage extends JFrame {
        public HomePage(LanguageCategorization cat) {
            setTitle("Home Page");
            setSize(800, 800);
            setDefaultCloseOperation(EXIT_ON_CLOSE);
            setLocationRelativeTo(null);

            // Create a custom JPanel for the content panel with a background image
            JPanel contentPanel = new JPanel() {
                @Override
                protected void paintComponent(Graphics g) {
                    super.paintComponent(g);
                    // Load and display the background image
                    //C:/Users/abdel/Downloads/fa845d1a-c5a8-46eb-a29b-cffea7bc9b69 (1).jpg

                    ImageIcon backgroundImage = new ImageIcon("C:\\Users\\abdel\\Downloads\\image (17).png");//C:/Users/abdel/Downloads/fa845d1a-c5a8-46eb-a29b-cffea7bc9b69 (1).jpg");
                    g.drawImage(backgroundImage.getImage(), 0, 0, getWidth(), getHeight(), this);
                }
            };

            // Use GridBagLayout for the content panel to arrange components
            GridBagLayout gridBagLayout = new GridBagLayout();
            contentPanel.setLayout(gridBagLayout);
            GridBagConstraints constraints = new GridBagConstraints();

           /* JPanel topPanel = new JPanel();
            topPanel.setLayout(new BorderLayout());
*/
            // Create a title label and set its position (top left)
            JLabel titleLabel = new JLabel("Polyglot");
            titleLabel.setFont(new Font("Arial", Font.BOLD, 35));

            // Sign In and Sign Up buttons
            JPanel buttonsPanel = new JPanel();
            CustomButton  signInButton = new CustomButton("Sign In", Color.WHITE); //Orange
            CustomButton  signUpButton= new CustomButton("Sign Up", Color.WHITE); //Orange

            buttonsPanel.add(signInButton);
            buttonsPanel.add(signUpButton);
           // topPanel.add(buttonsPanel, BorderLayout.EAST);
            //contentPanel.add(topPanel);

            constraints.gridx = 0;
            constraints.gridy = 0;
            constraints.anchor = GridBagConstraints.WEST;

            contentPanel.add(titleLabel, constraints);
            contentPanel.add(signInButton);
            contentPanel.add(signUpButton);

            CustomButton AdminB = new CustomButton("Admin Sign in", Color.WHITE);
            constraints.gridx = 5;
            constraints.gridy = 10;
            constraints.anchor = GridBagConstraints.EAST;
            contentPanel.add(AdminB, constraints);
            // Create subheading label (Search By) and set its position (left and vertical)
            JLabel subheadingLabel = new JLabel("Search By");
            constraints.gridx = 0;
            constraints.gridy = 1;
            contentPanel.add(subheadingLabel, constraints);

            // Create custom buttons for different search options
            CustomButton popularityButton = new CustomButton("Popularity", Color.WHITE); //Orange
            CustomButton proficiencyButton = new CustomButton("Proficiency Level", Color.WHITE); //or white
            CustomButton languageButton = new CustomButton("Language", Color.WHITE);
            CustomButton languageProficiencyButton = new CustomButton("Language and Proficiency", Color.WHITE);
            CustomButton regionButton = new CustomButton("Region", Color.WHITE);

            //Sample data to test functionality

            //End of Sample Data!!
            // Add action listeners to the buttons (implement functionality)
            popularityButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    PopularityOptionsPage optionsPage = new PopularityOptionsPage(cat);
                    optionsPage.setVisible(true);
                }
            });

            proficiencyButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                 ProficiencyLevelOptionsPage optionsPage = new ProficiencyLevelOptionsPage(cat);
                 optionsPage.setVisible(true);
                }
            });
//Another test case

            languageButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    LanguageOptionsPage optionsPage = new LanguageOptionsPage(cat);
                    optionsPage.setVisible(true);
                }
            });

            signInButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    // Open the Sign In window
                    SwingUtilities.invokeLater(() -> {
                        new SignIn(cat);
                    });
                }
            });

            signUpButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    // Open the Sign Up window
                    SwingUtilities.invokeLater(() -> {
                        new SignUp(cat);
                    });
                }
            });

            AdminB.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    // Open the Sign Up window
                    SwingUtilities.invokeLater(() -> {
                        new AdminSignIn(cat);
                    });
                }
            });

            languageProficiencyButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    LanguageProficiencySearchPage LangProf = new LanguageProficiencySearchPage(cat);
                    LangProf.setVisible(true);
                }
            });

            regionButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    SearchByRegion regionPage = new SearchByRegion(cat);
                    regionPage.setVisible(true);
                }
            });


            // Set buttons position (left and vertical)
            constraints.gridx = 0;
            constraints.gridy = 2;
            constraints.insets = new Insets(10, 0, 0, 0); // Add space between buttons and label
            constraints.fill = GridBagConstraints.HORIZONTAL;

            // Add the buttons to the content panel
            contentPanel.add(popularityButton, constraints);

            constraints.gridy = 3; // Adjust gridy for the next button
            contentPanel.add(proficiencyButton, constraints);

            constraints.gridy = 4;
            contentPanel.add(languageButton, constraints);

            constraints.gridy = 5;
            contentPanel.add(languageProficiencyButton, constraints);

            constraints.gridy = 6;
            contentPanel.add(regionButton, constraints);

            setContentPane(contentPanel); // Set the content panel with the background image
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

                HomePage homePage = new HomePage(cat);
                homePage.setVisible(true);
            });
        }
    }

