import java.util.ArrayList;
import java. util. Scanner;

public class Language {
    private ArrayList<String> proficiencyLevelDescriptions;
    private String name;
    private ArrayList<String> proficiencyLevels;
    private String region;
    private String description;
    private int popularity; //like a rating from 1-10, rare - very popular
    private ArrayList<Course> courses;

    // Constructor to initialize a Language object with a defined ArrayList(description for each proficiency level)
    Language(String name, ArrayList<String> proficiencyLevels, String region,  String description, int popularity, ArrayList<String> DescriptionLevel) {
        if (name == null || proficiencyLevels == null || region == null || DescriptionLevel == null) {
            throw new IllegalArgumentException("Null input values are not allowed.");
        }  //Null values will throw an exception
        this.courses = new ArrayList<Course>();
        this.name = name;
        this.region = region;
        this.description = description;
        if (popularity >= 1 && popularity <= 10)
            this.popularity = popularity;
        else {
            throw new IllegalArgumentException("Popularity must be in the range of 1 to 10.");
        }

        // Validate number of proficiency levels
        if (proficiencyLevels == null || proficiencyLevels.isEmpty()){
            throw new IllegalArgumentException("There must be at least 1 proficiency level.");
        }

        this.proficiencyLevels = new ArrayList<>(proficiencyLevels);

        proficiencyLevelDescriptions = new ArrayList<>(proficiencyLevels.size());
        for (int i = 0; i < proficiencyLevels.size(); i++) {
            proficiencyLevelDescriptions.add(DescriptionLevel.get(i));
        }
    }

    //In case proficiency level descriptions have not yet been written. They are initialized to a default value
    Language(String name, ArrayList<String> proficiencyLevels, String region,  String description, int popularity) {
        if (name == null || proficiencyLevels == null || region == null) {
            throw new IllegalArgumentException("Null input values are not allowed.");
        }  //Null values will throw an exception
        this.courses = new ArrayList<Course>();
        this.name = name;
        this.region = region;
        this.description = description;
        if (popularity >= 1 && popularity <= 10)
            this.popularity = popularity;
        else {
            throw new IllegalArgumentException("Popularity must be in the range of 1 to 10.");
        }

        // Validate number of proficiency levels
        if (proficiencyLevels == null || proficiencyLevels.isEmpty()){ //|| proficiencyLevels.size() > 3) {
            throw new IllegalArgumentException("There must be at least 1 proficiency level.");
        }

        this.proficiencyLevels = new ArrayList<>(proficiencyLevels);

        proficiencyLevelDescriptions = new ArrayList<>(proficiencyLevels.size());
        for (int i = 0; i < proficiencyLevels.size(); i++) {
            proficiencyLevelDescriptions.add("Description required");
        }
    }


    // Getters and setters for the attributes
    public String getName() {
        return name;
    }

    public boolean VerifyLevel(String course)
    {
        for(int i=0; i< courses.size(); i++)
        {
            if(course == courses.get(i).getName())
            {
                return true;
            }
        }
        return false;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setProficiencyLevels(ArrayList<String> proficiencyLevels) {
        this.proficiencyLevels = proficiencyLevels;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    // Getter and setter for the Language 'description' attribute
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    // Getter and setter for the 'popularity' attribute
    public int getPopularity() {
        return popularity;
    }

    public void setPopularity(int popularity) {
        // You can add validation here to ensure popularity is within the desired range (1-10)
        if(popularity >= 1 && popularity <= 10)  //to Ensure that it's in range
        this.popularity = popularity;
        else
            while(popularity < 1 || popularity > 10)
            {
                System.out.println("Please enter valid popularity rating");
                Scanner myObj = new Scanner(System.in);  // Create a Scanner object
                popularity = myObj.nextInt();
            }  //Ensures the popularity cannot be set/changed unless it's valid.
               // Keeps asking until valid input is provided.
    }

    @Override
    public String toString() {
        return "Language{" +
                "Name = " + name +
                ", Proficiency Levels = " + proficiencyLevels +
                ", Region = " + region +
                ", Description = " + description + // Include description in the toString representation
                ", Popularity Rating = " + popularity +
                '}';
    }

    public ArrayList<String> getProficiencyLevels() {
        return proficiencyLevels;
    }

    // Getter for proficiency level descriptions
    public String getProficiencyLevelDescription(String proficiencyLevel) {
        int index = proficiencyLevels.indexOf(proficiencyLevel);
        if (index != -1) {
            return proficiencyLevelDescriptions.get(index);
        }
        throw new IllegalArgumentException("Proficiency level not found: " + proficiencyLevel);
    }

    //Description update only
    public void updateProficiencyLevelDescription(String proficiencyLevel, String newDescription) {
        int index = proficiencyLevels.indexOf(proficiencyLevel);
        if (index != -1) {
            proficiencyLevelDescriptions.set(index, newDescription);
        } else {
            throw new IllegalArgumentException("Proficiency level not found: " + proficiencyLevel);
        }
    }

    //Addition of new level and description- can also be used to update existing Level's description.
    public void addProficiencyLevel(String level) {
        if (!proficiencyLevels.contains(level)) {
            proficiencyLevels.add(level);
            proficiencyLevelDescriptions.add("No Description set yet");
        }
        int index = proficiencyLevels.indexOf(level);
        if (index != -1) {
            System.out.println("Please enter the description for the " + level + " level:");
            Scanner myObj = new Scanner(System.in);
            String desc = myObj.nextLine();
            proficiencyLevelDescriptions.set(index, desc);
        }
    }

    // Method to remove a proficiency level- Administrator
    public void removeProficiencyLevel(String level) {
        if(proficiencyLevels.size() > 1)
        proficiencyLevels.remove(level);
        else throw new IllegalArgumentException("There is only one proficiency level. Cannot delete the " + level + " level for the " + this.name + " language.");
    }

    public void addCourse(Course c)
    {
        courses.add(c);
    }

    public ArrayList<Course> getCourses()
    {
        return courses;
    }

    public ArrayList<Course> upcomingCourses(Course name)
    {
        ArrayList<Course> Upcoming = new ArrayList<Course>();
        int index = courses.indexOf(name);
        for(int i = index+1; i<courses.size(); i++)
        {
            Upcoming.add(courses.get(i));
        }
        return Upcoming;
    }

    public ArrayList<Course> PastCourses(Course name)
    {
        ArrayList<Course> Past = new ArrayList<Course>();

        int index = courses.indexOf(name);
        for(int i = 0; i< index; i++)
        {
            Past.add(courses.get(i));
        }
        return Past;
    }

    public Course getCourseByProficiency(String proficiencyLevel) {
        for (Course course : courses) {
            if (course.getProficiencyLevel().equalsIgnoreCase(proficiencyLevel)) {
                return course;
            }
        }
        return null; // Return null if no course is found for the given proficiency level
    }

    public void DisplayLevelsAndDescriptions()
    {
            System.out.println(this.name + ":");
            for(int i=0; i<courses.size(); i++)
            {
                System.out.println(courses.get(i).getName());
                System.out.println(courses.get(i).getProficiencyLevel());
                System.out.println(courses.get(i).getProficiencyLevelDesc(courses.get(i).getProficiencyLevel(), this));
            }
    }

}
