public class Adoption extends AdoptionCenter {
    // Adopt a pet 
    public void adoptPet(int petID) {
        db.updateDatabase("UPDATE Pets SET adopted = 1 WHERE id =" + petID);
    }
}