import java.util.ArrayList;
import java.util.Scanner;

public class Administrator {
    private String Name;
    private String Email;

    public Administrator(String Name, String Email) {
        this.Name = Name;
        this.Email = Email;
    }

    public void AddCourse(LanguageCategorization categorization) {
        System.out.println("Enter Language you'd like to add the course for:");
        Scanner myObj = new Scanner(System.in);
        String langName = myObj.nextLine();

        Language language = null;

        // Check if the language exists in the categorization
        for (Language lang : categorization.getAvailableLanguages()) {
            if (lang.getName().equals(langName)) {
                language = lang;
                break;
            }
        }

        if (language == null) {
            // Language doesn't exist, add a new language
            language = AddLanguage(categorization, langName);
        }

        // Continue adding details for the new course
        System.out.println("Enter Course Name:");
        myObj = new Scanner(System.in);
        String courseName = myObj.nextLine();

        System.out.println("Enter proficiency level:");
        myObj = new Scanner(System.in);
        String level = myObj.nextLine();

        Course newCourse = new Course(courseName, level);

        System.out.println("Would you like to add materials for the course right now? (Enter y or n)");
        myObj = new Scanner(System.in);
        String addMaterials = myObj.nextLine();

        if (addMaterials.equalsIgnoreCase("y")) {
            System.out.println("Which one would you like to add sources for? (Books, Videos, Exercises)");
            myObj = new Scanner(System.in);
            String category = myObj.nextLine();

            if (category.equalsIgnoreCase("Books")) {
                System.out.println("Please enter book title:");
                myObj = new Scanner(System.in);
                String book = myObj.nextLine();
                newCourse.addBook(book);
            } else if (category.equalsIgnoreCase("Videos")) {
                System.out.println("Please enter link of video:");
                myObj = new Scanner(System.in);
                String link = myObj.nextLine();
                newCourse.addVideo(link);
            } else if (category.equalsIgnoreCase("Exercises")) {
                System.out.println("Please enter exercise title:");
                myObj = new Scanner(System.in);
                String exercise = myObj.nextLine();
                newCourse.addExercise(exercise);
            }
        }

        // Add the new course to the language
        language.addCourse(newCourse);
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
