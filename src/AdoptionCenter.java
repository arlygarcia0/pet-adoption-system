import Pets.*;

public class AdoptionCenter {
    private Pet[] inShelter;
    private int size;

    // Constructor 
    public AdoptionCenter() {
        size = 13;

        inShelter = new Pet[size];

        // Dogs 
        inShelter[0] = new Dog("Soda", "Doberman", 3);
        inShelter[1] = new Dog("Buddy", "Labrador", 2);
        inShelter[2] = new Dog("Rocky", "Golden Retriever", 4);
        inShelter[3] = new Dog("Luna", "Bulldog", 1);
        inShelter[4] = new Dog("Cooper", "German Shepherd", 5);
        inShelter[5] = new Dog("Duke", "Boxer", 6);
        inShelter[6] = new Dog("Oreo", "Huskey", 2);

        // Cats
        inShelter[7] = new Cat("Peanut", "Siamese", 5);
        inShelter[8] = new Cat("Bella", "Persian", 4);
        inShelter[9] = new Cat("Olive", "Maine Coon", 3);
        inShelter[10] = new Cat("Leo", "Bengal", 2);
        inShelter[11] = new Cat("Milo", "Ragdoll", 6);
        inShelter[12] = new Cat("Chloe", "British Shorthair", 1);
    }

    // Display all availble pets
    public void displayPets() {
        System.out.println("\nAvailable Pets for Adoption: ");

        for(int i = 0; i < inShelter.length; i++) {
            if(inShelter[i] != null) {
                System.out.print((i + 1) + ". ");
                inShelter[i].displayInfo();
            }
        }
    }

    // Adopt A pet 
    public Pet adoptPet(int index) {
        if(index >= 0 && index < inShelter.length) {
            if(inShelter[index] != null) {
                Pet adoptedPet = inShelter[index];
                adoptedPet.setAdopted(true);

                inShelter[index] = null;

                System.out.println("Pet adopted successfully!");

                return adoptedPet;
            }
        }

        System.out.println("Invalid selection.");
        return null;
    }




}