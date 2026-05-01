public class DisplayInfo extends PetsTable {
    //Show all pets
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
        db.readDatabase("SELECT name, breed, age FROM Pets WHERE adoptedBy = " + userID);
    }

    ////DELETE
    public void deleteTables() {
        db.updateDatabase("DROP TABLE Pets");
        db.updateDatabase("DROP TABLE Users");
    }
}