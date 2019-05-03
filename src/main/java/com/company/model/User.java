package main.java.com.company.model;

public class User {
    private int id;
    private String username;
    private String password;
    private Role role;

    public User(int id, String username, String password, Role role) {

        this.id = id;
        this.username = username;
        this.password = password;
        this.role = role;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Role getRole() {
        return this.role;
    }
}
