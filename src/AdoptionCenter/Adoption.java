public class Adoption extends PetsTable {
    // Adopt a pet 
    public void adoptPet(String petName, int userID) {
        db.updateDatabase("UPDATE Pets SET adopted = 1, adoptedBy = " + userID + " WHERE name = '" + petName + "'");
        System.out.println("Pet adopted successfully!");
    }
}