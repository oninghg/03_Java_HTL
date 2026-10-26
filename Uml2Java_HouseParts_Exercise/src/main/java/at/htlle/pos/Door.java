package at.htlle.pos;

public class Door extends BuildingPart{

    public Door(long costsInCent){
        super(costsInCent);
    }

    @Override
    public String toString() {
        return String.format("The door costs: %d.0", getCostsInCent()/100);
    }
}
