public class User {
    // Attributes
    private String name;
    private int ID;

    // Constructor 
    public User(String name, int ID) {
        this.name = name;
        this.ID = ID;
    }

    // Setter & Getter Methods
    public String getName() {
        return name;
    }
    public int ID() { 
        return ID;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setID(int ID) {
        this.ID = ID;
    }
}