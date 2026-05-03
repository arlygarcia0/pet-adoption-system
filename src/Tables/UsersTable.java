package Tables;
import Database.Database;
import Models.User;

public class UsersTable {
    //Attribute
    protected Database db;

    //Constructor
    public UsersTable(Database db) {
        this.db = db;
        //Create a table for pets in shelter
        db.updateDatabase("CREATE TABLE IF NOT EXISTS Users (name VARCHAR(255), id INT AUTO_INCREMENT PRIMARY KEY)");
    }
    
    // Get user ID by name -> existing user enters the system
    public int getUserID(String name) {
        Object result = db.returnDatabase("SELECT id FROM Users WHERE name = '" + name + "'", "id");
        if (result != null) {
            return (int) result; //if there is data, then transform it to int
        }
        return -1; // Return -1 if user not found
    }

    //Add user
     public void NewUser(User user) {
        db.updateDatabase("INSERT INTO Users (name) VALUES ('" + user.getName() + "')");
    }

    
}