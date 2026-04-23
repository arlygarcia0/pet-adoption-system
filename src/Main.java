import java.util.Scanner;
import Pets.*;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        AdoptionCenter shelter = new AdoptionCenter();

        System.out.println("Enter your name: ");
        String name = input.nextLine();

        User user = new User(name);

        int choice;

        do {
            shelter.displayPets();

            System.out.println("\nEnter the number of the pet to adopt (0 to exit)");
            choice = input.nextInt();

            if (choice == 0) {
                break;
            }
            Pet adoptedPet = shelter.adoptPet(choice - 1);

            if(adoptedPet != null) {
                user.adoptPet(adoptedPet);
            }

        } while (true);

        user.viewAdoptedPets();

        input.close();
    }
}