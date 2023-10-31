    import javax.swing.*;
    import java.awt.*;
    import java.awt.event.ActionEvent;
    import java.awt.event.ActionListener;
    import java.util.ArrayList;

    public class HomePage extends JFrame {
        public HomePage() {
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
                    ImageIcon backgroundImage = new ImageIcon("");//C:/Users/abdel/Downloads/fa845d1a-c5a8-46eb-a29b-cffea7bc9b69 (1).jpg");
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
            JButton signInButton = new JButton("Sign In");
            JButton signUpButton = new JButton("Sign Up");
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

            CustomButton AdminB = new CustomButton("Admin Sign in", Color.ORANGE);
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
            CustomButton popularityButton = new CustomButton("Popularity", Color.PINK); //Orange
            CustomButton proficiencyButton = new CustomButton("Proficiency Level", Color.PINK); //or white
            CustomButton languageButton = new CustomButton("Language", Color.PINK);
            CustomButton languageProficiencyButton = new CustomButton("Language and Proficiency", Color.PINK);
            CustomButton regionButton = new CustomButton("Region", Color.PINK);

            //Sample data to test functionality

            ArrayList<String> pL1 = new ArrayList<>();
            pL1.add("Beginner");
            pL1.add("Intermediate");
            Language eng= new Language("English", pL1, "North America", "Great lang to start with!", 5);
            ArrayList<String> pL2 = new ArrayList<>();
            pL2.add("N1");
            pL2.add("N2");
            Language Jap= new Language("Japanese", pL2, "Asia", "Very complex", 9);

            LanguageCategorization lSample = new LanguageCategorization();
            lSample.addLanguage(eng);
            lSample.addLanguage(Jap);
            //End of Sample Data!!
            // Add action listeners to the buttons (implement functionality)
            popularityButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    PopularityOptionsPage optionsPage = new PopularityOptionsPage(lSample);
                    optionsPage.setVisible(true);
                }
            });

            proficiencyButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                 ProficiencyLevelOptionsPage optionsPage = new ProficiencyLevelOptionsPage(lSample);
                 optionsPage.setVisible(true);
                }
            });
//Another test case
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

            languageButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    LanguageOptionsPage optionsPage = new LanguageOptionsPage(lSample2);
                    optionsPage.setVisible(true);
                }
            });

            signInButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    // Open the Sign In window
                    SwingUtilities.invokeLater(() -> {
                        new SignIn();
                    });
                }
            });

            signUpButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    // Open the Sign Up window
                    SwingUtilities.invokeLater(() -> {
                        new SignUp();
                    });
                }
            });

            AdminB.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    // Open the Sign Up window
                    SwingUtilities.invokeLater(() -> {
                        new AdminSignIn();
                    });
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
                HomePage homePage = new HomePage();
                homePage.setVisible(true);
            });
        }
    }

