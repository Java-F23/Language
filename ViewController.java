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
        final String[] LearnerEmail = {""};
        LearnerController CLearner = new LearnerController();

        //Welcome Message
        LearnerController L = new LearnerController();
        AdministratorController A = new AdministratorController();
        View v = new View();

// Declare the ArrayList outside the ActionListener
        ArrayList<JButton> bDisplayUserOptions = new ArrayList<>();
        final String[] usertype = {""}; // Array or mutable container

        JButton ok = v.displayWelcomeMessage();
        System.out.println(ok.getText());
        ok.addActionListener(e -> {
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
                adminButton.addActionListener(e119 -> {
                    // Display options for Admin (sign in or sign up)
                    v.displaySignInSignUpOptions();
                    usertype[0] = "Admin"; // Modify the first element of the array
                });

                learnerButton.addActionListener(e118 -> {
                    v.displaySignInSignUpOptions();
                    // Display options for Learner (sign in or sign up)
                    usertype[0] = "Learner"; // Modify the first element of the array
                });

                // For sign in button in displaySignInSignUpOptions
                bDisplayUserOptions.get(0).addActionListener(e117 -> {
                    {
                        JButton signIn;
                        signIn = v.openSignInPage();
                        signIn.addActionListener(e116 -> {
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

                                        v.getViewLearnersStatsButton().addActionListener(e115 -> {
                                            {List<String> learnerEmails = new ArrayList<>();
                                                learnerEmails = CLearner.getAllLearnerEmails();
                                                v.openSelectLearnerMenu(learnerEmails);
                                            }
                                        });

                                        v.getAddLanguageButton().addActionListener(e114 -> {
                                            {
                                                v.AdminAddLanguagePage();
                                                // Add action listener to the search button
                                                v.getSaveLanguageButton().addActionListener(e113 -> {
                                                    LanguageModel LanguageAdded = new LanguageModel(v.getLangNameField().getText(), v.getRegionField().getText(), v.getDescriptionField().getText(), Integer.parseInt(v.getPopularityField().getText()), v.getNewProficiencyLevelsList().getText());
                                                    LangCont.saveLanguageToFile(LanguageAdded);
                                                    v.displaySuccessMessage();
                                                });
                                            }
                                        });

                                        v.getAddCourseButton().addActionListener(e114 -> {
                                            {
                                                v.displayAddCourseMenu();
                                                v.getSaveButtonAddCourse().addActionListener(e122 -> {
                                                   boolean test =  LangCont.updateLanguageCourseDescription(v.getLanguageField_AddCourse().getText(), v.getNameField_AddCourse().getText(),v.getCourseDescriptionField().getText(), "Languages.csv");
                                                   if(test)
                                                   v.displaySuccessMessage();
                                                   else
                                                       v.displayFailMessage();
                                                });
                                            }});

                                        v.getRemoveCourseButton().addActionListener(e123 -> {
                                            v.displayRemoveCourseMenu();
                                            v.getRemoveButtonRemoveCourse().addActionListener((ActionListener) e127 -> {
                                                LangCont.removeLanguageCourse(v.getLanguageField_AddCourse().getText(), v.getNameField_AddCourse().getText(), "Languages.csv");
                                                v.displayRemovedMessage();
                                            });
                                        });

                                        v.getRemoveLanguageButton().addActionListener(e124 -> {
                                            v.displayRemoveLanguageMenu();
                                            v.getRemoveButtonRemoveCourse().addActionListener((ActionListener) e128 -> {
                                                LangCont.removeLanguage(v.getLanguageField_AddCourse().getText(), "Languages.csv");
                                                v.displayRemovedMessage();

                                            });
                                        });

                                        v.getAddMaterialsButton().addActionListener(e125 -> {
                                            v.displayMaterialMenu();
                                            v.getSaveLanguageButton().addActionListener(e129 -> {
                                                if(!v.getBookField().getText().isEmpty())
                                                    LangCont.addBookTitle(v.getLanguageField_AddCourse().getText(), v.getVideoField().getText(), "Books.csv", "Languages.csv");
                                                if(!v.getVideoField().getText().isEmpty())
                                                    LangCont.addVideoLink(v.getLanguageField_AddCourse().getText(), v.getVideoField().getText(), "Videos.csv", "Languages.csv");
                                                v.displaySuccessMessage();
                                            });
                                        });

                                        v.getModifyMaterialsButton().addActionListener(e126 -> {

                                        });
                                    }
                                    else if(usertype[0] == "Learner"){



                                                LearnerEmail[0] = v.getEmailField().getText();
                                        v.dispose();
                                        v.openLearnerPage();
                                        v.getPopularityButton().addActionListener(e112 -> {
                                            {
                                                v.PopularityOptionsPage();
                                                System.out.println("Popularity button pressed");
                                                v.getSearchByRangeButton().addActionListener(e111 -> {
                                                    {
                                                        JTextField min = v.getMinPopularityField();
                                                        JTextField max = v.getMaxPopularityField();
                                                        List<LanguageModel> filteredLanguages = LangCatMod.filterByPopularityRange(Integer.parseInt(min.getText()), Integer.parseInt(max.getText()));
                                                        v.setPopTable(filteredLanguages);
                                                    }
                                                });

                                            }
                                        });

                                        v.getViewLearnerProfile().addActionListener((ActionListener) e130 -> {
                                            //I have LearnerEmail[0]
                                            LearnerController LearnerObj = new LearnerController();
                                            LearnerObj.retrieveCredentials(LearnerEmail[0]);
                                            v.displayLearnerInformation(LearnerObj.getLearnerName(), LearnerObj.getLearnerEmail(), LearnerObj.getLearnerUsername(), LearnerObj.getEnrollmentsByEmail(LearnerEmail[0]) , LearnerObj.getFavoritesByEmail(LearnerEmail[0]));
                                        });

                                                v.getViewAllButton().addActionListener(new ActionListener() {
                                                    @Override
                                                    public void actionPerformed(ActionEvent e116) {
                                                        {
                                                            ArrayList<String> enrollmentCourses = new ArrayList<>();
                                                            v.LearnerViewAllPage(LangCatMod);
                                                            for (JButton EnButton : v.getEnrollButtons()) {
                                                                EnButton.addActionListener(e110 -> {
                                                                    String[] chunks = EnButton.getText().split(" ");
                                                                    enrollmentCourses.add(chunks[2]);
                                                                    System.out.println("We've been here! " + chunks[2]);
                                                                    v.displaySuccessMessage();
                                                                    CLearner.enrollments(LearnerEmail[0], enrollmentCourses);
                                                                    enrollmentCourses.clear();
                                                                });
                                                            }
                                                            ArrayList<String> favoriteCourses = new ArrayList<>();

                                                            for (JButton FavButton : v.getFavButtons()) {
                                                                FavButton.addActionListener(e19 -> {
                                                                    String[] chunks = FavButton.getText().split(" ");
                                                                    if (chunks.length >= 3 /*&& !favoriteCourses.contains(chunks[3])*/) {
                                                                        favoriteCourses.add(chunks[3]);
                                                                        System.out.println("We've been here as well, " + chunks[3]);
                                                                        v.displaySuccessMessage();
                                                                        CLearner.favorites(LearnerEmail[0], favoriteCourses);
                                                                        favoriteCourses.clear();
                                                                    }
                                                                });
                                                            }
                                                        }
                                                    }
                                                });

                                    v.getProficiencyButton().addActionListener(e18 -> {
                                        {
                                            v.ProficiencyLevelOptionsPage();
                                            v.getSearchByValueButton().addActionListener(e17 -> v.showProfResults(LangCatMod,v.getTextField()));
                                        }
                                    });

                                    v.getLanguageButton().addActionListener(e15 -> {
                                        v.LanguageOptionsPage(LangCatMod);
                                        v.getSearchByLanguageButton().addActionListener(e151 -> {
                                            String input = v.getLanguageSearchInput().getText();
                                            List<LanguageModel> filteredLanguages = LangCatMod.filterByLanguage(input);
                                            v.setLanguageTable(filteredLanguages);

                                            ArrayList<String> enrollmentCourses = new ArrayList<>();
                                                    for(JButton EnButton : v.getEnrollButtons()) {
                                                        EnButton.addActionListener(e1 -> {
                                                            String[] chunks = EnButton.getText().split(" ");
                                                            enrollmentCourses.add(chunks[2]);
                                                            System.out.println("We've been here! " + chunks[2]);
                                                            v.displaySuccessMessage();
                                                            CLearner.enrollments(LearnerEmail[0], enrollmentCourses);
                                                            enrollmentCourses.clear();
                                                        });
                                                    }
                                                    ArrayList<String> favoriteCourses = new ArrayList<>();

                                                    for (JButton FavButton : v.getFavButtons()) {
                                                        FavButton.addActionListener(e12 -> {
                                                            String[] chunks = FavButton.getText().split(" ");
                                                            if (chunks.length >= 3 && !favoriteCourses.contains(chunks[3])) {
                                                                favoriteCourses.add(chunks[3]);
                                                                System.out.println("We've been here as well, " + chunks[3]);
                                                                v.displaySuccessMessage();
                                                                CLearner.favorites(LearnerEmail[0], favoriteCourses);
                                                                favoriteCourses.clear();
                                                            }
                                                        });
                                                    }
                                                });
                                    });

                                    v.getLanguageProficiencyButton().addActionListener(e13 -> {
                                        v.ShowLangProfSearchPage();
                                        v.getSearchButton_LangProf().addActionListener(e120 -> {
                                            String languageName = v.getLanguageNameField_LangProf().getText();
                                            String proficiencyLevel = v.getProficiencyLevelField_LangProf().getText();

                                            List<LanguageModel> result = LangCatMod.filterByLanguageAndProficiency(languageName, proficiencyLevel);

                                            // Display the result in the text area
                                            v.getResultTextArea_LangProf().setText("Search Results:\n");
                                            if (result.size() == 0) {
                                                v.getResultTextArea_LangProf().append("No matching languages found.");
                                            } else {
                                                for (LanguageModel language : result) {
                                                    v.getResultTextArea_LangProf().append("Language Name: " + language.getName() + "\n");
                                                    v.getResultTextArea_LangProf().append("Proficiency Levels: " + String.join(", ", language.getProficiencyLevels()) + "\n");
                                                    v.getResultTextArea_LangProf().append("\n");
                                                }
                                            }
                                        });
                                    });

                                    v.getRegionButton().addActionListener(e14 -> {
                                        v.SearchByRegion(LangCatMod);
                                        v.getSearchButton_Region().addActionListener(e121 -> {

                                        });
                                    });
                                    }
                                }
                                else {
                                    //call gui for fail message
                                    v.displayFailSignInMessage();
                                }
                            }
                        });

                    }
                });

            } else {
                System.out.println("Error: Home page buttons are null.");
            }
        });
    }
}

