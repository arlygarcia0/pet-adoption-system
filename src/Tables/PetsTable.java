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
    }
    // Adopt a pet 
    public void adoptPet(String petName, int userID) {
        db.updateDatabase("UPDATE Pets SET adopted = 1, adoptedBy = " + userID + " WHERE LOWER (name) = LOWER('" + petName + "')");
        System.out.println("Pet adopted successfully!");
    }

    // Using polymorphism to add cat/dog to the table -> Overloading
    // Add Dog
    public void addPet(Pet pet) {
        db.updateDatabase("INSERT INTO Pets (name, type, breed, age, adopted, adoptedBy) VALUES ('"+ pet.getName() + "','" + pet.getType() +"','"+ pet.getBreed() + "', "+ pet.getAge() + ", 0, NULL)");
    }
}