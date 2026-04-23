import Pets.*;

public class User {
    private String name;
    private Pet[] petsAdopted;
    private int count;

    // Constructor 

    public User(String name) {
        this.name = name;
        petsAdopted = new Pet[10];
        count = 0;
    }

    // Getter 
    public String getName() {
        return name;
    }

    // Method to adopt a pet
    public void adoptPet( Pet pet) {
        if (count < petsAdopted.length) {
            petsAdopted[count] = pet;
            count++;

            System.out.println(name + " adopted " + pet.getName());
        }
        else {
            System.out.println("Adoption list is full");
        }
    }

    // View adopted pets 

    public void viewAdoptedPets() {
        System.out.println("Pets adopted by " + name + ":");
        for (int i = 0; i < count; i++) {
            petsAdopted[i].displayInfo();
        }
    }




}