package logic;

public class Categories {
    
    private int ID;
    private String name;

    public Categories(int ID, String name) {
        this.ID = ID;
        this.name = name;
    }

    public int getID() {
        return ID;
    }


    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return getID() + getName();
    }
    
    
    
    
}
