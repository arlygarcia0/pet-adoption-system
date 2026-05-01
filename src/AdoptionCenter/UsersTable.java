public class UsersTable {
    protected Database db = new Database();

    //Constructor
    public UsersTable() {
        //Create a table for pets in shelter
        db.updateDatabase("CREATE TABLE Users (name VARCHAR(255), id INT AUTO_INCREMENT PRIMARY KEY)");
        //Add values
        db.updateDatabase("INSERT INTO Users (name, id) VALUES ('Bob Bobbert')");
        db.updateDatabase("INSERT INTO Users (name, id) VALUES ('Carl Carlton')");
        db.updateDatabase("INSERT INTO Users (name, id) VALUES ('Jane Janeston')");
        db.updateDatabase("INSERT INTO Users (name, id) VALUES ('Dan Danbert')");
        db.updateDatabase("INSERT INTO Users (name, id) VALUES ('Susy Susan')");
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
     public void NewUser(String name) {
        User newUser = new User(name);

        db.updateDatabase("INSERT INTO Users (name, id) VALUES ('" + user.getName() + "', " + user.getUserID() + ")");
    }

    
}