package at.htlle.pos;

public class Wall extends BuildingPart{

    public Wall(long costsInCent){
        super(costsInCent);
    }


    @Override
    public String toString() {
        return String.format("The wall costs: %d.0", getCostsInCent()/100);
    }
}