/*Separte the classes on different files */

import Pets.*;

public class AdoptionCenter {
    Database db = new Database();

    //Constructor
    public AdoptionCenter() {
        //Create a table for pets in shelter
        db.updateDatabase("CREATE TABLE IF NOT EXISTS Pets (id INT PRIMARY KEY, name VARCHAR(50), type VARCHAR(50), breed VARCHAR(50), age INT, adopted BOOLEAN)");
    }
}

public class addValues {
    public addValues () {
        //Insert pets in the table
        db.updateDatabase("INSERT INTO Pets (id, name, type, breed, age, adopted) VALUES (01, 'Soda', 'Dog', 'Doberman', 3, 0)");
        db.updateDatabase("INSERT INTO Pets (id, name, type, breed, age, adopted) VALUES (02, 'Buddy', 'Dog', 'Labrador', 2, 1)");
        db.updateDatabase("INSERT INTO Pets (id, name, type, breed, age, adopted) VALUES (03, 'Rocky', 'Dog', 'Golden Retriever', 4, 0)");
        db.updateDatabase("INSERT INTO Pets (id, name, type, breed, age, adopted) VALUES (04, 'Luna', 'Dog', 'Bulldog', 1, 1)");
        db.updateDatabase("INSERT INTO Pets (id, name, type, breed, age, adopted) VALUES (05, 'Cooper', 'Dog', 'German Shepherd', 8, 0)");
        db.updateDatabase("INSERT INTO Pets (id, name, type, breed, age, adopted) VALUES (06, 'Duke', 'Dog', 'Boxer', 6, 1)");
        db.updateDatabase("INSERT INTO Pets (id, name, type, breed, age, adopted) VALUES (07, 'Oreo', 'Dog', 'Huskey', 5, 1)");
        db.updateDatabase("INSERT INTO Pets (id, name, type, breed, age, adopted) VALUES (08, 'Peanut', 'Cat', 'Siamese', 2, 1)");
        db.updateDatabase("INSERT INTO Pets (id, name, type, breed, age, adopted) VALUES (09, 'Bella', 'Cat', 'Persian', 1, 0)");
        db.updateDatabase("INSERT INTO Pets (id, name, type, breed, age, adopted) VALUES (10, 'Olive', 'Cat', 'Maine Coon', 4, 0)");
        db.updateDatabase("INSERT INTO Pets (id, name, type, breed, age, adopted) VALUES (11, 'Leo', 'Cat', 'Bengal', 7, 1)");
        db.updateDatabase("INSERT INTO Pets (id, name, type, breed, age, adopted) VALUES (12, 'Milo', 'Cat', 'Ragdoll', 1, 1)");
        db.updateDatabase("INSERT INTO Pets (id, name, type, breed, age, adopted) VALUES (13, 'Chloe', 'Cat', 'British Shorthair', 6, 0)");
    }
}

// Adding a new pet to the shelter using *Polumorphism* -> Overloading
public class newPet {
    // Add Dog
    public void addPet(Dog dog) {
        db.updateDatabase("INSERT INTO Pets (name, type, breed, age, adopted) VALUES ("+ dog.getName() + ", 'Dog',"+ dog.getBreed() + ", "+ dog.getAge() + ", 0)");
    }
    // Add Cat
    public void addPet(Cat cat) {
        db.updateDatabase("INSERT INTO Pets (name, type, breed, age, adopted) VALUES ("+ cat.getName() + ", 'Cat',"+ cat.getBreed() + ", "+ cat.getAge() + ", 0)");
    }
}
    
public class info {
    // Display all availble pets
    public void displayPets() {
        db.readDatabase("SELECT * FROM Pets WHERE adopted = 0");
    }
}

    // Adopt A pet 
    public void adoptPet(int petID) {
        db.updateDatabase("UPDATE Pets SET adopted = 1 WHERE id =" + petID);
    }
}