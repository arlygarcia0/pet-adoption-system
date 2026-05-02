import java.util.Scanner;
import Pets.*;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // one shared database connctionn for everything 
        Database db = new Database();
        // 1. Initialize system: 
        //    Creating pets table and parameters; Adding values to the tables
        PetsTable pets = new PetsTable(db);
        UsersTable users = new UsersTable(db);
        Adoption adoption = new Adoption(db);
        DisplayInfo display = new DisplayInfo(db);

        // 1.1 Show currents pets:
     //   System.out.println("Current pets in the shelter: ");
   //     display.AllPets();

        //1.2 Add a pet
       // Dog dog = new Dog("Max",  "Beagle", 3);
      //  pets.addPet(dog);

        // 2. Create new user:
        //    Ask for adopter name -> Check if its already in the system
        //    if not then add it to the table with currently 0 pets
        //    if yes, then select its tables
        System.out.println("\nWelcome to the Pet Adoption Center!");

        System.out.println("Please enter your name: ");
        String name = input.nextLine();

        System.out.println("Are you a returning user? (yes/no): ");
        String response = input.nextLine();

        User user;
        if (response.equalsIgnoreCase("yes")) {
            int id = users.getUserID(name);
            if (id == -1) {
                System.out.print("Sorry we couldn't find an account for \"" + name + "\".");
                System.out.println("Creating a new account for you instead ");
                user = new User(name);
                users.NewUser(user);
                System.out.println("Account created. Your ID is: " + user.getUserID());
            }
            else {
                user = new User(name, id);
        
                System.out.println("Welcome back, " + user.getName() + "! ");

            }
            
        } 
        else {
            System.out.println("Creating new account:: ");
            user = new User(name); //Creating an user parameter
            users.NewUser(user); //Adding the user to the table
            System.out.println("Account created successfully for " + user.getName() + "! Your ID is: " + user.getUserID());
        }

        // 5. Show adopted pets by user
        System.out.println("\nYour previously adopted pets: ");
        display.AdoptedPets(user.getUserID());

        // 4. Display available pets:
        //    Show pets where adopted = false
        System.out.println();
        display.AvailablePets();

        // 5. Adopt a pet
        //    User selects pet -> Choose by breed or they can choose specifically by name/id
        //    Update pet's database and add it to user's table
        System.out.println("Please enter the name of the pet you'd like: ");
        String petName = input.nextLine();
        adoption.adoptPet(petName, user.getUserID());
        
        // 6. Show adopted pets by user
        System.out.println("\nYour adopted pets now: ");
        display.AdoptedPets(user.getUserID());

        // 7. Show shelter status
        System.out.println("\nFull shelter status: ");
        display.AllPets();

        // 8. End program
        input.close();
        
    }
}