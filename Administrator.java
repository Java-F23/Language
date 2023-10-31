import java.util.ArrayList;
import java.util.Scanner;

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

        if (language == null) {
            // Language doesn't exist, add a new language
            language = AddLanguage(categorization, LangName);
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
        }

    // Add a new language
    public Language AddLanguage(LanguageCategorization categorization, String langName) {
        System.out.println("Adding a new language: " + langName);
        System.out.println("Enter description for language:");
        Scanner myObj = new Scanner(System.in);
        String description = myObj.nextLine();

        System.out.println("How many proficiency levels would you like to add?");
        myObj = new Scanner(System.in);
        int num_of_levels = myObj.nextInt();

        ArrayList<String> proficiencyLevels = new ArrayList<>();
        ArrayList<String> proficiencyLevelDescriptions = new ArrayList<>();

        System.out.println("Please add a name and description for each proficiency level (Beginner, Intermediate, Advanced):");
        for (int i = 0; i < num_of_levels; i++) {
            myObj = new Scanner(System.in);
            proficiencyLevels.add(myObj.nextLine());

            System.out.println("Description for " + proficiencyLevels.get(i) + ":");
            myObj = new Scanner(System.in);
            proficiencyLevelDescriptions.add(myObj.nextLine());
        }

        System.out.println("Enter the popularity of the Language from a scale of 1-10 (least-most):");
        myObj = new Scanner(System.in);
        int popularity = myObj.nextInt();

        // Get region information
        System.out.println("Enter the region for the language:");
        myObj = new Scanner(System.in);
        String region = myObj.nextLine();
       // Language(String name, ArrayList<String> proficiencyLevels, String region, ArrayList<String> studyResources, String description, int popularity, ArrayList<String> DescriptionLevel) {

        Language newLanguage = new Language(langName, proficiencyLevels, region, description, popularity, proficiencyLevelDescriptions);
        categorization.addLanguage(newLanguage);

        return newLanguage;
    }

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



}
