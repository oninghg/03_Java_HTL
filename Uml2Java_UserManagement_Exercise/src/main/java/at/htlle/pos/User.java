package at.htlle.pos;

import java.util.Objects;

public class User extends Entity {
    private String username;
    private String password;
    private Group group;

    public User(int id, String username, String password){
        super.setId(id);
        this.username = username;
        if(Objects.requireNonNull(username, "username cannot be null").isBlank()){
           throw new IllegalArgumentException("username cannot be blank");
        }
        if(Objects.requireNonNull(password, "password cannot be null").isBlank()){
            throw new IllegalArgumentException("username cannot be blank");
        }
        this.password = password;
        this.group = group;
    }

    @Override
    public int getId() {
        return super.getId();
    }

    public Group getGroup(){
        return group;
    }

    public void setGroup(Group group){
        this.group = group;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return String.format(
                "%d," + "%s," + "%s", getId(), username, password
        );
    }
}
