import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class ViewController extends JFrame {
    ViewController()
    {
        ArrayList<LanguageModel> LangMod;
        LanguageController LangCont = new LanguageController();
        LanguageCatModel LangCatMod = new LanguageCatModel();
        LangMod = LangCont.retrieveLanguages();
        LangCatMod.setAvailableLanguages(LangMod);
       // final ArrayList<JButton>[] AdminButtons = new ArrayList[]{new ArrayList<>()};
      //  final ArrayList<JButton>[] LearnerButtons = new ArrayList[]{new ArrayList<>()};

        //Welcome Message
        LearnerController L = new LearnerController();
        AdministratorController A = new AdministratorController();
        View v = new View();

// Declare the ArrayList outside the ActionListener
        ArrayList<JButton> bDisplayUserOptions = new ArrayList<>();
        final String[] usertype = {""}; // Array or mutable container

        JButton ok = v.displayWelcomeMessage();
        System.out.println(ok.getText());
        ok.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                v.dispose();
                v.openHomePage();
                // Print debug information
                System.out.println("Opening home page...");

                // Call the method to populate the ArrayList before accessing elements


                ArrayList<JButton> b = v.openHomePage();

                if (b != null) {
                    bDisplayUserOptions.clear();
                    bDisplayUserOptions.add(v.getSignInButton());
                    bDisplayUserOptions.add(v.getSignUpButton());

                    JButton adminButton = b.get(0);
                    JButton learnerButton = b.get(1);

                    // Add action listeners to adminButton and learnerButton if needed
                    adminButton.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            // Display options for Admin (sign in or sign up)
                            v.displaySignInSignUpOptions();
                            //System.out.println(bDisplayUserOptions.get(0).getText());
                            usertype[0] = "Admin"; // Modify the first element of the array
                        }
                    });

                    learnerButton.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            v.displaySignInSignUpOptions();
                            //System.out.println(bDisplayUserOptions.get(1).getText());
                            // Display options for Learner (sign in or sign up)
                            usertype[0] = "Learner"; // Modify the first element of the array
                        }
                    });

                    // For sign in button in displaySignInSignUpOptions
                    bDisplayUserOptions.get(0).addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            {
                                JButton signIn;
                                signIn = v.openSignInPage();
                                signIn.addActionListener(new ActionListener() {
                                    @Override
                                    public void actionPerformed(ActionEvent e) {
                                        {
                                            boolean success = false;

                                            if(!v.getEmailField().getText().isEmpty() && !String.valueOf(v.getPasswordField().getPassword()).isEmpty()) {
                                                String email = v.getEmailField().getText();
                                                String pass = String.valueOf(v.getPasswordField().getPassword());
                                                if (usertype[0] == "Admin") {
                                                    success = A.checkCredentials(email, pass);
                                                }
                                                else if (usertype[0] == "Learner") {
                                                    success = L.validateLearnerCredentials(email, pass);
                                                }
                                            }
                                            if(success)
                                            {
                                                //call gui for success, and have action listener and rest of functions inside
                                                System.out.println("Sign in successful");
                                                if(usertype[0] == "Admin") {
                                                    v.dispose();
                                                    v.openAdminPage();
                                                   /* AdminButtons[0].add(v.getViewLearnersStatsButton());
                                                    AdminButtons[0].add(v.getAddLanguageButton());
                                                    AdminButtons[0].add(v.getAddCourseButton());
                                                    AdminButtons[0].add(v.getAddMaterialsButton());
                                                    AdminButtons[0].add(v.getModifyMaterialsButton());
                                                    AdminButtons[0].add(v.getRemoveLanguageButton());
                                                    AdminButtons[0].add(v.getRemoveCourseButton());*/
                                                    v.getViewLearnersStatsButton().addActionListener(new ActionListener() {
                                                        @Override
                                                        public void actionPerformed(ActionEvent e) {
                                                            {

                                                            }
                                                        }
                                                    });

                                                    v.getAddLanguageButton().addActionListener(new ActionListener() {
                                                        @Override
                                                        public void actionPerformed(ActionEvent e) {
                                                            {
                                                                v.AdminAddLanguagePage();
                                                                // Add action listener to the search button
                                                                v.getSaveLanguageButton().addActionListener(new ActionListener() {
                                                                    @Override
                                                                    public void actionPerformed(ActionEvent e) {
                                                                        LanguageModel LanguageAdded = new LanguageModel(v.getLangNameField().getText(), v.getRegionField().getText(), v.getDescriptionField().getText(), Integer.parseInt(v.getPopularityField().getText()), v.getNewProficiencyLevelsList().getText());
                                                                        LangCont.saveLanguageToFile(LanguageAdded);
                                                                        v.displaySuccessMessage();
                                                                    }
                                                                });
                                                            }
                                                        }
                                                    });

                                                }
                                                else if(usertype[0] == "Learner"){
                                                v.dispose();
                                                v.openLearnerPage();
                                                v.getPopularityButton().addActionListener(new ActionListener() {
                                                    @Override
                                                    public void actionPerformed(ActionEvent e) {
                                                        {
                                                            v.PopularityOptionsPage();
                                                            System.out.println("Popularity button pressed");
                                                            v.getSearchByRangeButton().addActionListener(new ActionListener() {
                                                                @Override
                                                                public void actionPerformed(ActionEvent e) {
                                                                    {
                                                                        JTextField min = v.getMinPopularityField();
                                                                        JTextField max = v.getMaxPopularityField();
                                                                        List<LanguageModel> filteredLanguages = LangCatMod.filterByPopularityRange(Integer.parseInt(min.getText()), Integer.parseInt(max.getText()));
                                                                        v.setPopTable(filteredLanguages);
                                                                    }
                                                                }
                                                            });

                                                        }
                                                    }
                                                });

                                                v.getViewAllButton().addActionListener(new ActionListener() {
                                                    @Override
                                                    public void actionPerformed(ActionEvent e) {
                                                        {
                                                            v.LearnerViewAllPage(LangCatMod);
                                                        }
                                                    }
                                                });

                                                v.getProficiencyButton().addActionListener(new ActionListener() {
                                                    @Override
                                                    public void actionPerformed(ActionEvent e) {
                                                        {
                                                            v.ProficiencyLevelOptionsPage();
                                                            v.getProficiencyButton();
                                                            v.getSearchByRangeButton().addActionListener(new ActionListener() {
                                                                @Override
                                                                public void actionPerformed (ActionEvent e) {
                                                                    v.showProfResults(LangCatMod,v.getTextField());
                                                                }
                                                            });
                                                        }
                                                    }
                                                });
                                                }
                                            }
                                            else {
                                                //call gui for fail message
                                                System.out.println("Sign in unsuccessful");

                                            }
                                        }
                                    }
                                });

                            }
                        }
                    });


                    // For sign in button in displaySignInSignUpOptions
                    bDisplayUserOptions.get(1).addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            {
                                JButton signUp;
                               signUp = v.openSignUpPage();

                                // For sign in button in displaySignInSignUpOptions
                                signUp.addActionListener(new ActionListener() {
                                    @Override
                                    public void actionPerformed(ActionEvent e) {
                                        {
                                            //String name, String email, String username, String password
                                            if(usertype[0] == "Learner")
                                                L.saveCredentials(v.getNameField().getText(), v.getEmailField().getText(), v.getUsernameField().getText(), String.valueOf(v.getPasswordField().getPassword()));
                                            else if(usertype[0] =="Admin")
                                                A.saveCredentials(v.getNameField().getText(), v.getEmailField().getText(), v.getUsernameField().getText(), String.valueOf(v.getPasswordField().getPassword()));
                                        }
                                    }
                                });
                            }
                        }
                    });

                } else {
                    System.out.println("Error: Home page buttons are null.");
                }
            }
        });
        if(usertype[0] == "Learner")
        {
           /* JButton ViewAll = LearnerButtons[0].get(0);
            JButton Pop = LearnerButtons[0].get(1);
            JButton ProfLevel = LearnerButtons[0].get(2);
            JButton Lang = LearnerButtons[0].get(3);
            JButton LangProf = LearnerButtons[0].get(4);
            JButton Reg = LearnerButtons[0].get(5);*/

           // JButton ViewLearners_Stats = AdminButtons[0].get(0);
            //Method to retrieve Languages and put them all inside the categorization
           /* ArrayList<LanguageModel> LangMod;
            LanguageController LangCont = new LanguageController();
            LanguageCatModel LangCatMod = new LanguageCatModel();
            LangMod = LangCont.retrieveLanguages();
            LangCatMod.setAvailableLanguages(LangMod);*/

            v.getViewAllButton().addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    {
                        System.out.println("View All Pressed");
                        //v.ViewAllPage(LangCatMod);
                    }
                }
            });


            v.getPopularityButton().addActionListener(e -> {
                {
                 // v.PopularityOptionsPage(LangCatMod);
                    v.getSearchByRangeButton().addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            {
                                JTextField min = v.getMinPopularityField();
                                JTextField max = v.getMaxPopularityField();
                                List<LanguageModel> filteredLanguages = LangCatMod.filterByPopularityRange(Integer.parseInt(min.getText()), Integer.parseInt(max.getText()));
                                v.setPopTable(filteredLanguages);
                            }
                        }
                    });

                }
            });
            v.getProficiencyButton().addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    {

                    }
                }
            });
      /*      Lang.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    {

                    }
                }
            });
            LangProf.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    {

                    }
                }
            });
            Reg.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    {

                    }
                }
            });

        }
*/


/*
      if(usertype[0] == "Admin")
        {
            v.getViewLearnersStatsButton().addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    //Open a page with all users. Then, once a user is pressed, show a common panel between
                    //learner and admin to show all the info of that user.
                    //Display the password as a password. Not as a string
                }
            });
            v.getAddLanguageButton().addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {

                }
            });
            v.getAddCourseButton().addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {

                }
            });
            v.getAddMaterialsButton().addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {

                }
            });
            v.getModifyMaterialsButton().addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {

                }
            });
            v.getRemoveLanguageButton().addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {

                }
            });
            v.getRemoveCourseButton().addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {

                }
            });*/
        }

    }
}

