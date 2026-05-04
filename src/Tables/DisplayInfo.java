package Tables;

public class DisplayInfo {
    private PetsTable petsTable;

    public DisplayInfo(PetsTable petsTable) {
        this.petsTable = petsTable;
    }

    public void AllPets() {
        System.out.println("Shelter Records: ");
        petsTable.getAllPets();
    }

    public void AvailablePets() {
        System.out.println("Pets that need a home: ");
        petsTable.getAvailablePets();
    }

    public void AdoptedPets(int userID) {
        System.out.println("Pets adopted by user: ");
        petsTable.getAdoptedPets(userID);
    }
}