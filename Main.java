import java.util.ArrayList;
import java.util.Arrays;
import java. util. Scanner;

public class Main {

        public static void main(String[] args) {
            // Create a language categorization
            LanguageCategorization categorization = new LanguageCategorization();

            // Create a learner
            Learner learner = new Learner("Ella", "E45@gmail.com");

            // Create an administrator
            Administrator administrator = new Administrator("John", "JohnDoe@gmail.com");

            // Add languages
            Language newLanguage = administrator.AddLanguage(categorization, "Japanese");
            Language newLanguage1 = administrator.AddLanguage(categorization, "Chinese");
            Language newLanguage2 = administrator.AddLanguage(categorization, "English");
            Language newLanguage3 = administrator.AddLanguage(categorization, "Arabic");

            newLanguage.addProficiencyLevel("N2");

            // Add a course
            administrator.AddCourse(categorization);

            // Add a course to favorites
            Course favoriteCourse = new Course(newLanguage.getName(), "N1");
            learner.addToFavorites(favoriteCourse);

            // Earn a certificate
            Course completedCourse = new Course("Completed Course", "N2");
            learner.completeCourse(completedCourse);
            learner.earnCertificate(completedCourse);

            // Search for languages by popularity
            Language[] popularLanguages = learner.searchByPopularity(5, 9, categorization);

            popularLanguages.toString();
            // Display learner's full report
            learner.displayFullReport(newLanguage);

            // View learner's data
            administrator.viewLearnerData(learner, newLanguage);
        }

}