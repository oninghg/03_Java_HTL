package at.htlle.pos;

public class Window extends BuildingPart{

    public Window(long costsInCent){
        super(costsInCent);
    }



    @Override
    public String toString() {
        return String.format("The window costs: %d.0", getCostsInCent()/100);
    }
}