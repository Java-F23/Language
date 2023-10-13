import javax.naming.Name;
import java.util.ArrayList;

public class Learner {
    private String name;
    private String email;
    private ArrayList<Course> favorites;
    private Course current;
    private ArrayList<Course> coursesDone;
    private ArrayList<Course> coursesInProgress;
    private ArrayList<String> certificatesEarned;
    private ArrayList<Course> upcomingCourses;
    private ArrayList<Course> pastCourses;

    public Learner(String name, String email) {
        this.name = name;
        this.email = email;
        this.favorites = new ArrayList<>();
        this.coursesDone = new ArrayList<>();
        this.coursesInProgress = new ArrayList<>();
        this.certificatesEarned = new ArrayList<>();
        //edit those to be whatever the learner has finished, or whatever courses will still be done
        this.upcomingCourses = new ArrayList<>();
        this.pastCourses = new ArrayList<>();
    }

    public String getName()
    {
        return name;
    }

    public String getEmail()
    {
        return email;
    }

    public ArrayList<String> getCertificatesEarned()
    {
        return certificatesEarned;
    }

    public ArrayList<Course> getFavorites()
    {
        return favorites;
    }

    // Add a course to favorites
    public void addToFavorites(Course course) {
        favorites.add(course);
    }

    // Earn a certificate for a completed course
    public void earnCertificate(Course course) {
        if (coursesDone.contains(course)) {
            certificatesEarned.add(course.getName());
        }
    }
    public void completeCourse(Course course) {
        coursesInProgress.remove(course);
    }

   public Course Get_current()
   {
       return current;
   }

    // View upcoming courses
    public ArrayList<Course> getUpcomingCourses(Language L) {
    upcomingCourses = L.upcomingCourses(Get_current());
     return upcomingCourses;
    }

    //View courses history
    public ArrayList<Course> getPastCourses(Language L) {
        pastCourses = L.PastCourses(Get_current());
        return pastCourses;
    }

    // Search for a specific language and proficiency level, return corresponding course if available
    public Course searchLanguageAndProficiency(String languageName, String proficiencyLevel, LanguageCategorization categorization) {
        ArrayList<Language> filteredLanguages = categorization.filterByLanguageAndProficiency(languageName, proficiencyLevel);
        if (!filteredLanguages.isEmpty()) {
            Language language = filteredLanguages.get(0);
            return language.getCourseByProficiency(proficiencyLevel);
        }
        return null;
    }

    // Search for a specific language, return its available courses
    public ArrayList<Course> searchLanguage(String languageName, LanguageCategorization categorization) {
        ArrayList<Language> filteredLanguages = categorization.filterByLanguage(languageName);
        if (!filteredLanguages.isEmpty()) {
            Language language = filteredLanguages.get(0);
            return language.getCourses();
        }
        return new ArrayList<>();
    }

    // Search for languages by popularity
    public Language[] searchByPopularity(int minPopularity, int maxPopularity, LanguageCategorization categorization) {
        Language[] filteredLanguages = categorization.filterByPopularityRange(minPopularity, maxPopularity);
        return filteredLanguages;
    }

        // Method to display a full learner report
        public void displayFullReport(Language lang) {
            System.out.println("Learner Name: " + name);
            System.out.println("Learner Email: " + email);

            // View favorite courses
            System.out.println("Favorite Courses:");
            for (Course course : favorites) {
                System.out.println("- " + course.getName());
            }

            // View certificates earned
            System.out.println("Certificates Earned:");
            for (String certificate : certificatesEarned) {
                System.out.println("- " + certificate);
            }

            // View current course
            if (current != null) {
                System.out.println("Current Course:");
                System.out.println("- " + current.getName());
            }

            // View courses in progress
            System.out.println("Courses In Progress:");
            for (Course course : coursesInProgress) {
                System.out.println("- " + course.getName());
            }

            // View upcoming courses
            ArrayList<Course> upcomingCourses = getUpcomingCourses(lang);
            if (!upcomingCourses.isEmpty()) {
                System.out.println("Upcoming Courses:");
                for (Course course : upcomingCourses) {
                    System.out.println("- " + course.getName());
                }
            }

            // View past courses
            ArrayList<Course> pastCourses = getPastCourses(lang);
            if (!pastCourses.isEmpty()) {
                System.out.println("Past Courses:");
                for (Course course : pastCourses) {
                    System.out.println("- " + course.getName());
                }
            }
        }

}
