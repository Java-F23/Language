import java.util.ArrayList;
import java.util.Arrays;
import java. util. Scanner;

public class Main {

        public static void main(String[] args) {
            // Create a language categorization
            LanguageCategorization categorization = new LanguageCategorization();

            // Create a learner
            Learner learner = new Learner("LearnerName", "learner@example.com");

            // Create an administrator
            Administrator administrator = new Administrator("AdminName", "admin@example.com");

            // Add a language
            Language newLanguage = administrator.AddLanguage(categorization, "Test Language");

            // Add a course
            administrator.AddCourse(categorization);

            // Add a course to favorites
            Course favoriteCourse = new Course("Favorite Course", "Intermediate");
            learner.addToFavorites(favoriteCourse);

            // Earn a certificate
            Course completedCourse = new Course("Completed Course", "Advanced");
            learner.completeCourse(completedCourse);
            learner.earnCertificate(completedCourse);

            // Search for languages by popularity
            Language[] popularLanguages = learner.searchByPopularity(1, 5, categorization);

            // Display learner's full report
            learner.displayFullReport(newLanguage);

            // View learner's data
            administrator.viewLearnerData(learner, newLanguage);
        }

}