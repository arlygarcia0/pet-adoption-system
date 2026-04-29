public class DisplayInfo extends AdoptionCenter {
    // Display all availble pets
    public void AvailablePets() {
        db.readDatabase("SELECT * FROM Pets WHERE adopted = 0");
    }
}