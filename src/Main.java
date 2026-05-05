import java.util.Scanner;
import Database.Database;
import Tables.*;
import Models.*;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Database db = new Database(); //One database connection for everything

        // 1. Initialize system: 
        //    Creating pets database tables
        PetsTable petsTable = new PetsTable(db); // Handles logic for the pets database
        UsersTable usersTable = new UsersTable(db); // Handles logic  for the users database
        DisplayInfo display = new DisplayInfo(petsTable); // Handles all printingkaro

        // 2. Create new user:
        //    Ask for adopter name -> Check if its already in the system
        //    if not then add it to the table with currently 0 pets
        //    if yes, then select its tables
        System.out.println("\nWelcome to the Pet Adoption Center!");

        System.out.println("\nPlease enter your name: ");
        String name = input.nextLine();

        System.out.println("\nAre you a returning user? (yes/no): ");
        String response = input.nextLine();

        User user;
        if (response.equals("yes")) {
            int id = usersTable.getUserID(name); // Getting user's id using their name

            if (id == -1) {
                System.out.print("Sorry we couldn't find an account for \"" + name + "\".");
                System.out.println("Creating a new account for you instead ");
                
                user = new User(name);//creating a new user
                usersTable.NewUser(user); //adding user to the table
                user.setUserID(usersTable.getUserID(name)); //setting user id by getting the id from the user's table
                
                System.out.println("Account created. Your ID is: " + user.getUserID());
            } 
            else {
                user = new User(name, id);
                System.out.println("Welcome back, " + user.getName() + "! ");
            }
        }
        else {
            System.out.println("Creating new account: ");

            user = new User(name);
            usersTable.NewUser(user);
            user.setUserID(usersTable.getUserID(name));

            System.out.println("Account created successfully for " + user.getName() + "! Your ID is: " + user.getUserID());
        } 
        System.out.println();
        

        // 5. Show adopted pets by user
        display.AdoptedPets(user.getUserID());
        System.out.println();

        // 4. Display available pets:
        //    Show pets where adopted = false
        display.AvailablePets();
        System.out.println();

        // 5. Adopt a pet
        //    User selects pet -> Choose by breed or they can choose specifically by name/id
        //    Update pet's database and add it to user's table
        System.out.println("Please enter the name of the pet you'd like: ");
        String petName = input.nextLine();
        petsTable.adoptPet(petName, user.getUserID());
        System.out.println();

        // 6. Show adopted pets by user
        display.AdoptedPets(user.getUserID());
        System.out.println();

        // 7. Add a pet to the shelter:
        Dog dog = new Dog("Max",  "Beagle", 3);
        petsTable.addPet(dog);

        // 8. Show shelter status
        display.AllPets();

        response = "keep";
        while (response.equals("keep")) {
            System.out.println("\nDo you wanna keep adopting pets or log out? (keep/log out)");
            response = input.nextLine();
            System.out.println();
            if (response.equals("keep")) {
                // 4. Display available pets:
                display.AvailablePets();
                System.out.println();
                // 5. Adopt a pet
                System.out.println("Please enter the name of the pet you'd like: ");
                petName = input.nextLine();
                petsTable.adoptPet(petName, user.getUserID());
                System.out.println();
                // 6. Show adopted pets by user
                display.AdoptedPets(user.getUserID());
                System.out.println();
            }
        }

        System.out.println("Logging out..");

        // 9. End program
        db.updateDatabase("DROP TABLE Pets");
        db.updateDatabase("DROP TABLE Users");
        input.close();
    }
}