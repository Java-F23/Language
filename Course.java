import java.util.ArrayList;
public class Course {
    private String name;
    private String proficiencyLevel;
    private ArrayList<String> books;
    private ArrayList<String> videos;
    private ArrayList<String> exercises;

    public Course(String name, String proficiencyLevel) {
        this.name = name;
        this.proficiencyLevel = proficiencyLevel;
        this.books = new ArrayList<>();
        this.videos = new ArrayList<>();
        this.exercises = new ArrayList<>();
    }

    public void addBook(String book) {
        books.add(book);
    }

    public void addVideo(String video) {
        videos.add(video);
    }

    public void addExercise(String exercise) {
        exercises.add(exercise);
    }

    public ArrayList<String> getBooks() {
        return books;
    }

    public ArrayList<String> getVideos() {
        return videos;
    }

    public ArrayList<String> getExercises() {
        return exercises;
    }

    // Getters and setters for name and proficiencyLevel

    public void setProficiencyLevel(String proficiencyLevel) {
        this.proficiencyLevel = proficiencyLevel;
    }
    public void setName(String Name) {
        this.name = Name;
    }

    public String getName() {
        return name;
    }

    public String getProficiencyLevel() {
        return proficiencyLevel;
    }

    public String getProficiencyLevelDesc(String proficiencyLevel, Language lang)
    {
        return lang.getProficiencyLevelDescription(proficiencyLevel);
    }
}
