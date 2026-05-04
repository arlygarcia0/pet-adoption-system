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
        db.updateDatabase("CREATE TABLE IF NOT EXISTS Users (id INTEGER PRIMARY KEY AUTOINCREMENT, name VARCHAR (255))");
        // Insert shelter records of current users
        db.updateDatabase("INSERT INTO Users (name) VALUES ('Bob Bobbert')");
        db.updateDatabase("INSERT INTO Users (name) VALUES ('Carl Carlton')");
        db.updateDatabase("INSERT INTO Users (name) VALUES ('Jane Janeston')");
        db.updateDatabase("INSERT INTO Users (name) VALUES ('Dan Danbert')");
        db.updateDatabase("INSERT INTO Users (name) VALUES ('Susy Susan')");
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