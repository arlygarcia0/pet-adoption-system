package tables;
import Pets.*;
public class PetsTable {
    protected Database db;

    //Constructor
    public PetsTable(Database db) {
        this.db = db;
        //Create a table for pets in shelter
        db.updateDatabase("CREATE TABLE Pets (name VARCHAR(50), type VARCHAR(50), breed VARCHAR(50), age INT, adopted BOOLEAN, adoptedBy INT)");
        //Insert pets in the table, starting the database with 7 unadopted pets
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