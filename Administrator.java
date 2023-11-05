import java.util.ArrayList;

public class Administrator {
    private String Name;
    private String Email;

    public Administrator(String Name, String Email) {
        this.Name = Name;
        this.Email = Email;
    }

    public void AddCourse(LanguageCategorization categorization, String LangName, String CourseName, String level) {

        Language language = null;

        // Check if the language exists in the categorization
        for (Language lang : categorization.getAvailableLanguages()) {
            if (lang.getName().equals(LangName)) {
                language = lang;
                break;
            }
        }

        Course newCourse = new Course(CourseName, level);
        language.addCourse(newCourse);
    }
        public void AddMaterials (Language language, Course newCourse, ArrayList<String> Books, ArrayList<String> Videos, ArrayList<String> Exercises) {
                for (String book : Books)
                    newCourse.addBook(book);
                for(String link : Videos)
                    newCourse.addVideo(link);
               for(String exercise : Exercises)
                    newCourse.addExercise(exercise);
               language.addCourse(newCourse);
        }

    // Add a new language
    public Language AddLanguage(LanguageCategorization categorization, String langName, String region, String description, String popularity, ArrayList<String> ProficiencyLevels, ArrayList<String> proficiencyLevelDescriptions) {

        Language newLanguage = new Language(langName, ProficiencyLevels, region, description, Integer.parseInt(popularity), proficiencyLevelDescriptions);
        categorization.addLanguage(newLanguage);

        return newLanguage;
    }

/*
Will be used as a template for third sprint's functionality
    public void viewLearnerData(Learner learner, Language lang) {
        System.out.println("Learner Name: " + learner.getName());
        System.out.println("Learner Email: " + learner.getEmail());

        // View favorite courses
        System.out.println("Favorite Courses:");
        for (Course course : learner.getFavorites()) {
            System.out.println("- " + course.getName());
        }

        // View certificates earned
        System.out.println("Certificates Earned:");
        for (String certificate : learner.getCertificatesEarned()) {
            System.out.println("- " + certificate);
        }

        // View current course
        Course currentCourse = learner.Get_current();
        if (currentCourse != null) {
            System.out.println("Current Course:");
            System.out.println("- " + currentCourse.getName());
        }

        // View upcoming courses
        ArrayList<Course> upcomingCourses = learner.getUpcomingCourses(lang);
        if (!upcomingCourses.isEmpty()) {
            System.out.println("Upcoming Courses:");
            for (Course course : upcomingCourses) {
                System.out.println("- " + course.getName());
            }
        }

        // View past courses
        ArrayList<Course> pastCourses = learner.getPastCourses(lang);
        if (!pastCourses.isEmpty()) {
            System.out.println("Past Courses:");
            for (Course course : pastCourses) {
                System.out.println("- " + course.getName());
            }
        }
    }

*/

}
