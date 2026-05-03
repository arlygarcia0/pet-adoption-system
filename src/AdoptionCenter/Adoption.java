public class Adoption extends PetsTable {
    public Adoption(Database db) {
        super(db);
    }
    // Adopt a pet 
    public void adoptPet(String petName, int userID) {
        db.updateDatabase("UPDATE Pets SET adopted = 1, adoptedBy = " + userID + " WHERE LOWER(name) = LOWER('" + petName.trim() + "')");
        System.out.println("Pet adopted successfully!");
    }
}