import Pets.*;
public class PetsTable {
    protected Database db;

    //Constructor
    public PetsTable(Database db) {
        this.db = db;
        //Create a table for pets in shelter
        db.updateDatabase("CREATE TABLE IF NOT EXISTS Pets (id INT PRIMARY KEY, name VARCHAR(50), type VARCHAR(50), breed VARCHAR(50), age INT, adopted BOOLEAN, adoptedBy INT)");
        db.updateDatabase("CREATE TABLE IF NOT EXISTS Users (name VARCHAR(255), id INT)");
        //Insert pets in the table, starting the database with 13 pets, some adopted and some not
        db.updateDatabase("INSERT OR IGNORE INTO Pets (id, name, type, breed, age, adopted, adoptedBy) VALUES (01, 'Soda', 'Dog', 'Doberman', 3, 0, null)");
        db.updateDatabase("INSERT OR IGNORE INTO Pets (id, name, type, breed, age, adopted, adoptedBy) VALUES (02, 'Buddy', 'Dog', 'Labrador', 2, 1, 100)");
        db.updateDatabase("INSERT OR IGNORE INTO Pets (id, name, type, breed, age, adopted, adoptedBy) VALUES (03, 'Rocky', 'Dog', 'Golden Retriever', 4, 0, null)");
        db.updateDatabase("INSERT OR IGNORE INTO Pets (id, name, type, breed, age, adopted, adoptedBy) VALUES (04, 'Luna', 'Dog', 'Bulldog', 1, 1, 200)");
        db.updateDatabase("INSERT OR IGNORE INTO Pets (id, name, type, breed, age, adopted, adoptedBy) VALUES (05, 'Cooper', 'Dog', 'German Shepherd', 8, 0, null)");
        db.updateDatabase("INSERT OR IGNORE INTO Pets (id, name, type, breed, age, adopted, adoptedBy) VALUES (06, 'Duke', 'Dog', 'Boxer', 6, 1, 300)");
        db.updateDatabase("INSERT OR IGNORE INTO Pets (id, name, type, breed, age, adopted, adoptedBy) VALUES (07, 'Oreo', 'Dog', 'Huskey', 5, 1, 400)");
        db.updateDatabase("INSERT OR IGNORE INTO Pets (id, name, type, breed, age, adopted, adoptedBy) VALUES (08, 'Peanut', 'Cat', 'Siamese', 2, 1, 500)");
        db.updateDatabase("INSERT OR IGNORE INTO Pets (id, name, type, breed, age, adopted, adoptedBy) VALUES (09, 'Bella', 'Cat', 'Persian', 1, 0, null)");
        db.updateDatabase("INSERT OR IGNORE INTO Pets (id, name, type, breed, age, adopted, adoptedBy) VALUES (10, 'Olive', 'Cat', 'Maine Coon', 4, 0, null)");
        db.updateDatabase("INSERT OR IGNORE INTO Pets (id, name, type, breed, age, adopted, adoptedBy) VALUES (11, 'Leo', 'Cat', 'Bengal', 7, 0, null)");
        db.updateDatabase("INSERT OR IGNORE INTO Pets (id, name, type, breed, age, adopted, adoptedBy) VALUES (12, 'Milo', 'Cat', 'Ragdoll', 1, 1, 200)");
        db.updateDatabase("INSERT OR IGNORE INTO Pets (id, name, type, breed, age, adopted, adoptedBy) VALUES (13, 'Chloe', 'Cat', 'British Shorthair', 6, 0, null)");
    }

    // Using polymorphism to add cat/dog to the table -> Overloading
    // Add Dog
    public void addPet(Dog dog) {
        db.updateDatabase("INSERT INTO Pets (name, type, breed, age, adopted, adoptedBy) VALUES ('"+ dog.getName() + "', 'Dog','"+ dog.getBreed() + "', "+ dog.getAge() + ", 0, null)");
    }
    // Add Cat
    public void addPet(Cat cat) {
        db.updateDatabase("INSERT INTO Pets (name, type, breed, age, adopted, adoptedBy) VALUES ('"+ cat.getName() + "', 'Cat','"+ cat.getBreed() + "', "+ cat.getAge() + ", 0, null)");
    }
}