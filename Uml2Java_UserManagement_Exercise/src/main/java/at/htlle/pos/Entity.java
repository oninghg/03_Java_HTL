package at.htlle.pos;

public abstract class Entity {
    private int id;

    public Entity(){
        if(id < 0) throw new IllegalArgumentException("ID cannot be negative!");
        else this.id = id;
    }

    public int getId(){
        return id;
    }

    public void setId(int id) {
        if(id < 0) throw new IllegalArgumentException("ID cannot be negative!");
        else this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Entity entity)) return false;
        return id == entity.id;
    }

    @Override
    public int hashCode(){
        return Integer.hashCode(id);
    }

    @Override
    public String toString() {
        return String.format(
                "%d", id
        );
    }
}
