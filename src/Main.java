import java.util.Scanner;
import Pets.*;

public class Main {
    public static void main(String[] args) {
        // 1. Initialize system: 
        //    Create pets table and add current pets in the shelter
        
        // 2. Create new user:
        //    Ask for adopter name -> Check if its already in the system
        //    if not then add it to the table with currently 0 pets
        //    if yes, then select its tables

        // 3. Display available pets:
        //    Show pets where adopted = false

        // 4. Adopt a pet
        //    User selects pet -> Choose by breed or they can choose specifically by name/id
        //    Update pet's database and add it to user's table
        
        // 5. Show adopted pets by user

        // 6. Add new pet to the shelter
        //    Add a dog then add a cat, check that both work

        // 7. Update pet information
        //    Pet got older -> update age

        // 8. Show shelter status

        // 9. End program

        Scanner input = new Scanner(System.in);

        AdoptionCenter shelter = new AdoptionCenter();


        //Create a user
        System.out.println("Enter your name: ");
        String name = input.nextLine();

        User user = new User(name);


        //Show them pets available and adopt a pet
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

        //New user,  check ho wmany pets they have adopted

        //New pet in shelter, add it to table

        //Pet turn one year older, update its age

        //End code
        input.close();
    }
}