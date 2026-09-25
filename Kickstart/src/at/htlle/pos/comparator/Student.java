package at.htlle.pos.comparator;

import java.util.Objects;

public class Student {
    private String classroom;
    private String name;
    private int id;

    public Student(String name, int id, String classroom){
        if(id < 0) throw new IllegalArgumentException("Passed argument: 'id' must not be negative");{
            this.id = id;
        }

        //NOT null, empty, only whitespace
        if(Objects.requireNonNull(name, "Passed argument: 'name' must not be null").isBlank()) {
            throw new IllegalArgumentException("Passed argument: 'name' must not be empty of blank!");
        }
        this.name = name;

        //NOT null, empty, only whitespace
        if(Objects.requireNonNull(name, "Passed argument: 'classroom' must not be null").isBlank()) {
            throw new IllegalArgumentException("Passed argument: 'claasroom' must not be empty of blank!");
        }
        this.classroom = classroom;
    }

    public String toString(){
        return String.format("Name: %s\n" +
                "Klasse: %s\n" +
                "ID. %d", name, classroom, id);
    }

    public int getId() {
        return id;
    }


    public String getName() {
        return name;
    }

    public String getClassroom(){
        return classroom;
    }
}
