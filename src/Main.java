import java.util.Scanner;
import Pets.*;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // 1. Initialize system: 
        //    Create pets table and add current pets in the shelter
        AddValues add = new AddValues();
        add.ShelterRecords();
        
        // 2. Create new user:
        //    Ask for adopter name -> Check if its already in the system
        //    if not then add it to the table with currently 0 pets
        //    if yes, then select its tables
        System.out.println("Enter your name: ");
        String name = input.nextLine();

        User user = new User(name);

        // 3. Display available pets:
        //    Show pets where adopted = false

        // 4. Adopt a pet
        //    User selects pet -> Choose by breed or they can choose specifically by name/id
        //    Update pet's database and add it to user's table
        System.out.println("Which pet would you like?d");
        // 5. Show adopted pets by user

        // 6. Add new pet to the shelter
        //    Add a dog then add a cat, check that both work

        // 7. Update pet information
        //    Pet got older -> update age

        // 8. Show shelter status

        // 9. End program
        input.close();
    }
}