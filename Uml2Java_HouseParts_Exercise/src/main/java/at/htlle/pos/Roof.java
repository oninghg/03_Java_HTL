package at.htlle.pos;

public class Roof extends BuildingPart{

    public Roof(long costsInCent){
        super(costsInCent);
    }



    @Override
    public String toString() {
        return String.format("The roof costs: %d.0", getCostsInCent()/100);
    }
}