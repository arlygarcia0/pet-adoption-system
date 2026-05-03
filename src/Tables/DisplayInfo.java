package Tables;
import Database.Database;
public class DisplayInfo extends PetsTable {
<<<<<<< HEAD:src/Tables/DisplayInfo.java
    // Constructor
    public DisplayInfo (Database db) {
        super(db);
    }
    // Show all pets
=======
    //Show all pets

    public DisplayInfo(Database db) {
        super(db);
    }
>>>>>>> 646977ef33c270241169ed7005a885db600218bb:src/AdoptionCenter/DisplayInfo.java
    public void AllPets() {
        System.out.println("All pets in the shelter: ");
        db.readDatabase("SELECT * FROM Pets");
    }
    // Display all availble pets
    public void AvailablePets() {
        System.out.println("Pets that need a home: ");
        db.readDatabase("SELECT * FROM Pets WHERE adopted = 0");
    }
    //Show adopted pets by user
    public void AdoptedPets(int userID) {
        System.out.println("Pets adopted by user: ");
        db.readDatabase("SELECT * FROM Pets WHERE adoptedBy = " + userID);
    }

    ////DELETE
    public void deleteTables() {
        db.updateDatabase("DROP TABLE Pets");
        db.updateDatabase("DROP TABLE Users");
    }
}