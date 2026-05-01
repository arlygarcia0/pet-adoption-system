public class User {
    // Attributes
    private String name;
    private int userID;

    // Constructor 
    public User(String name) { //if new user
        this.name = name;
        userID = (int) (Math.random() * 1000); // Generate a random user ID
    }
    public User(String name, int userID) { //if returning user
        this.name = name;
        this.userID = userID;
    }

    // Setter & Getter Methods
    public String getName() {
        return name;
    }
    public int getUserID() {
        return userID;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setUserID(int userID) {
        this.userID = userID;
    }
}