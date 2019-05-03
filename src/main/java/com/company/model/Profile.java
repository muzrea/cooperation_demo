package main.java.com.company.model;

public class Profile {
    private String id;
    private String name;

    public Profile(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

}
