package main.java.com.company.model;

import java.util.List;

public class Role {
    private int id;
    private String name;
    private List<Profile> profiles;

    public Role(int id, String name, List<Profile> profiles) {
        this.id = id;
        this.name = name;
        this.profiles = profiles;
    }

    public String getName() {
        return this.name;
    }

    public List<Profile> getProfiles() {
        return this.profiles;
    }
}
