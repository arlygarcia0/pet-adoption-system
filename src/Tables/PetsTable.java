package Tables;
import Models.*;
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
        db.updateDatabase("UPDATE Pets SET adopted = 1, adoptedBy = " + userID + " WHERE LOWER (name) = LOWER('" + petName.trim() + "'");
        System.out.println("Pet adopted successfully!");
    }

    // Using polymorphism to add cat/dog to the table -> Overloading
    // Add Dog
    public void addPet(Dog dog) {
        db.updateDatabase("INSERT INTO Pets (name, type, breed, age, adopted, adoptedBy) VALUES ('"+ dog.getName() + "', 'Dog','"+ dog.getBreed() + "', "+ dog.getAge() + ", 0, 'null')");
    }
    // Add Cat
    public void addPet(Cat cat) {
        db.updateDatabase("INSERT INTO Pets (name, type, breed, age, adopted, adoptedBy) VALUES ('"+ cat.getName() + "', 'Cat','"+ cat.getBreed() + "', "+ cat.getAge() + ", 0, 'null')");
    }
}