public class UsersTable {
    protected Database db;

    //Constructor
    public UsersTable(Database db) {
        this.db = db;
        //Create a table for pets in shelter
        // db.updateDatabase("CREATE TABLE Users (name VARCHAR(255), id INT AUTO_INCREMENT PRIMARY KEY)");
        //Add values
        db.updateDatabase("INSERT OR IGNORE INTO Users (name, id) VALUES ('Bob Bobbert', 100)");
        db.updateDatabase("INSERT OR IGNORE INTO Users (name, id) VALUES ('Carl Carlton', 200)");
        db.updateDatabase("INSERT OR IGNORE INTO Users (name, id) VALUES ('Jane Janeston', 300)");
        db.updateDatabase("INSERT OR IGNORE INTO Users (name, id) VALUES ('Dan Danbert', 400)");
        db.updateDatabase("INSERT OR IGNORE INTO Users (name, id) VALUES ('Susy Susan', 500)");
    }
    
    // Get user ID by name -> existing user enters the system
    public int getUserID(String name) {
        Object result = db.returnDatabase("SELECT id FROM Users WHERE name = '" + name + "'", "id");
        if (result != null) {
            return ((Number)result).intValue(); //if there is data, then transform it to int
        }
        return -1; // Return -1 if user not found
    }

    //Add user
     public void NewUser(User user) {
        db.updateDatabase("INSERT INTO Users (name) VALUES ('" + user.getName() + "')");
        Object result = db.returnDatabase("SELECT last_insert_rowid() as id", "id");
        if(result != null) {
            user.setUserID(((Number)result).intValue());
        }
        //int newID = getUserID(user.getName());
        //user.setUserID(newID);
    }

    
}