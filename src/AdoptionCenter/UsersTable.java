import java.sql.ResultSet;

public class UsersTable {
    protected Database db = new Database();

    //Constructor
    public UsersTable() {
        //Create a table for pets in shelter
        db.updateDatabase("CREATE TABLE Users (name VARCHAR(255), id INT)");
        //Add values
        db.updateDatabase("INSERT INTO Users (name, id) VALUES ('Bob Bobbert', 100)");
        db.updateDatabase("INSERT INTO Users (name, id) VALUES ('Carl Carlton', 200)");
        db.updateDatabase("INSERT INTO Users (name, id) VALUES ('Jane Janeston', 300)");
        db.updateDatabase("INSERT INTO Users (name, id) VALUES ('Dan Danbert', 400)");
        db.updateDatabase("INSERT INTO Users (name, id) VALUES ('Susy Susan', 500)");
    }
    
    // Get user ID by name -> existing user enters the system
    public int getUserID(String name) {
        ResultSet result = db.Query("SELECT id FROM Users WHERE name = '" + name + "'");
        try {
            if (result.next()) {
                return result.getInt("id");
            }
        } catch (Exception e) {
            System.out.println("User not found. Please try again.");
        }
        return -1; // Return -1 if user not found
    }

    //Add user
     public void NewUser(User user) {
        db.updateDatabase("INSERT INTO Users (name, id) VALUES ('" + user.getName() + "', " + user.getUserID() + ")");
    }

    
}