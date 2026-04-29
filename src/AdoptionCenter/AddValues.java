//Using *Inheritance*: when we call this one, it automatically creates the table in AdoptionCenter
public class AddValues extends AdoptionCenter {
    public void ShelterRecords () {
        //Insert pets in the table
        db.updateDatabase("INSERT INTO Pets (id, name, type, breed, age, adopted, adoptedBy) VALUES (01, 'Soda', 'Dog', 'Doberman', 3, 0)");
        db.updateDatabase("INSERT INTO Pets (id, name, type, breed, age, adopted, adoptedBy) VALUES (02, 'Buddy', 'Dog', 'Labrador', 2, 1)");
        db.updateDatabase("INSERT INTO Pets (id, name, type, breed, age, adopted, adoptedBy) VALUES (03, 'Rocky', 'Dog', 'Golden Retriever', 4, 0)");
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