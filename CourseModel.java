public class CourseModel {
    private String name;
    private String proficiencyLevel;

    public CourseModel(String name, String proficiencyLevel) {
        this.name = name;
        this.proficiencyLevel = proficiencyLevel;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
