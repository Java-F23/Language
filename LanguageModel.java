import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.ArrayList;

public class LanguageModel {
    private String name;
    private String region;
    private String description;
    private int popularity;
    private Map<String, String> proficiencyLevelDescriptions;
    private Map<String, CourseModel> courses;

    public LanguageModel(String name, String region, String description, int popularity) {
        if (name == null || region == null) {
            throw new IllegalArgumentException("Null input values are not allowed.");
        }

        this.name = name;
        this.region = region;
        this.description = description;
        setPopularity(popularity);

        proficiencyLevelDescriptions = new HashMap<>();
        courses = new HashMap<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getPopularity() {
        return popularity;
    }

    public void setPopularity(int popularity) {
        if (popularity >= 1 && popularity <= 10) {
            this.popularity = popularity;
        } else {
            throw new IllegalArgumentException("Popularity must be in the range of 1 to 10.");
        }    }

    public void addProficiencyLevel(String level, String description) {
        proficiencyLevelDescriptions.put(level, description);
    }

    public void updateProficiencyLevelDescription(String level, String newDescription) {
        if (proficiencyLevelDescriptions.containsKey(level)) {
            proficiencyLevelDescriptions.put(level, newDescription);
        } else {
            throw new IllegalArgumentException("Proficiency level not found: " + level);
        }
    }

    public void addCourse(String courseName, CourseModel courseModel) {
        courses.put(courseName, courseModel);
    }

    public CourseModel getCourse(String courseName) {
        return courses.get(courseName);
    }

    public List<String> getProficiencyLevels() {
        return new ArrayList<>(proficiencyLevelDescriptions.keySet());
    }

    public String getProficiencyLevelDescription(String proficiencyLevel) {
        if (proficiencyLevelDescriptions.containsKey(proficiencyLevel)) {
            return proficiencyLevelDescriptions.get(proficiencyLevel);
        } else {
            throw new IllegalArgumentException("Proficiency level not found: " + proficiencyLevel);
        }
    }
}
