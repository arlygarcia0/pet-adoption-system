package Tables;
import Models.Pet;
import Database.Database;

public class PetsTable {
    protected Database db;

    //Constructor
    public PetsTable(Database db) {
        this.db = db;
        //Create a table for pets in shelter
        db.updateDatabase("CREATE TABLE IF NOT EXISTS Pets (name VARCHAR(50), type VARCHAR(50), breed VARCHAR(50), age INT, adopted BOOLEAN, adoptedBy INT)"); 
        //Insert Shelter record of current pets 
        db.updateDatabase("INSERT INTO Pets (name, type, breed, age, adopted, adoptedBy) VALUES ('Soda', 'Dog', 'Doberman', 3, 0, null)");
        db.updateDatabase("INSERT INTO Pets (name, type, breed, age, adopted, adoptedBy) VALUES ('Rocky', 'Dog', 'Golden Retriever', 4, 0, null)");
        db.updateDatabase("INSERT INTO Pets (name, type, breed, age, adopted, adoptedBy) VALUES ('Cooper', 'Dog', 'German Shepherd', 8, 0, null)");
        db.updateDatabase("INSERT INTO Pets (name, type, breed, age, adopted, adoptedBy) VALUES ('Bella', 'Cat', 'Persian', 1, 0, null)");
        db.updateDatabase("INSERT INTO Pets (name, type, breed, age, adopted, adoptedBy) VALUES ('Olive', 'Cat', 'Maine Coon', 4, 0, null)");
        db.updateDatabase("INSERT INTO Pets (name, type, breed, age, adopted, adoptedBy) VALUES ('Leo', 'Cat', 'Bengal', 7, 0, null)");
        db.updateDatabase("INSERT INTO Pets (name, type, breed, age, adopted, adoptedBy) VALUES ('Chloe', 'Cat', 'British Shorthair', 6, 0, null)");
    }
    
    // Adopt a pet 
    public void adoptPet(String petName, int userID) {
        db.updateDatabase("UPDATE Pets SET adopted = 1, adoptedBy = " + userID + " WHERE LOWER (name) = LOWER('" + petName + "')");
        System.out.println("Pet adopted successfully!");
    }

    // Add Pet 
    public void addPet(Pet pet) {
        db.updateDatabase("INSERT INTO Pets (name, type, breed, age, adopted, adoptedBy) VALUES ('"+ pet.getName() + "','" + pet.getType() +"','"+ pet.getBreed() + "', "+ pet.getAge() + ", 0, NULL)");
    }

    // All shelter records
    public void getAllPets() {
        db.readDatabase("SELECT * FROM Pets");
    }
    // Get all availble pets
    public void getAvailablePets() {
        db.readDatabase("SELECT name, type, breed, age FROM Pets WHERE adopted = 0");
    }
    //Show adopted pets by user
    public void getAdoptedPets(int userID) {
        Object result = db.returnDatabase("SELECT COUNT(*) AS total FROM pets WHERE adoptedBy =" + userID, "total");
        if (result == null || (int)result ==  0)
            System.out.println("You have not adopted any pets");
        else 
            db.readDatabase("SELECT name, type, breed, age FROM Pets WHERE adoptedBy = " + userID);
    }
}