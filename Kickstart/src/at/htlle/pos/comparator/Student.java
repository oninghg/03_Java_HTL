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

        if(Objects.requireNonNull(name, "Passed argument: 'name' must not be null").isBlank()) throw new IllegalArgumentException("Passed argument: 'name' must not be empty of blank!"); {
            this.name = name;
        }

        this.classroom = classroom;
    }

}
