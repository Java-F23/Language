// use in Controller

class LearnerModel {
    String name;
    String email;
    private String username;
    private String password;

    LearnerModel(String username, String email, String name, String password)
    {
        this.name = name;
        this.username = username;
        this.password = password;
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public String getName()
    {
        return name;
    }

    public String getEmail()
    {
        return email;
    }

    public String getPassword() {
        return password;
    }
}