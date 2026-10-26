package at.htlle.pos;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Group extends Entity{
    private String name;
    private List<User> users;

    public Group(int id, String name){
        super.setId(id);
        if(Objects.requireNonNull(name, "name cannot be null").isBlank()){
            throw new IllegalArgumentException("name cannot be blank");
        }
        this.name = name;
        this.users = new ArrayList<User>();
    }

    @Override
    public int getId() {
        return super.getId();
    }

    public List<User> getUsers(){
        return users;
    }

    public void addUser(User user){
        users.add(user);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return String.format(
                "%d," + "%s," + "%s", getId(), name, users
        );
    }
}
