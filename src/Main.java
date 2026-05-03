import java.util.Scanner;
import Database.Database;
import Tables.*;
import Tables.UsersTable;
import Models.*;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Database db = new Database(); //One database connection for everything

        // one shared database connctionn for everything 
        Database db = new Database();
        // 1. Initialize system: 
        //    Creating pets table and parameters; Adding values to the tables
        PetsTable pets = new PetsTable(db); // Handles logic for the pets database
        UsersTable users = new UsersTable(db); // Handles logic  for the users database
        DisplayInfo display = new DisplayInfo(db); // Handles all printing

        //1.1 Insert Shelter record of current pets 
        db.updateDatabase("INSERT INTO Pets (name, type, breed, age, adopted, adoptedBy) VALUES ('Soda', 'Dog', 'Doberman', 3, 0, null)");
        db.updateDatabase("INSERT INTO Pets (name, type, breed, age, adopted, adoptedBy) VALUES ('Rocky', 'Dog', 'Golden Retriever', 4, 0, null)");
        db.updateDatabase("INSERT INTO Pets (name, type, breed, age, adopted, adoptedBy) VALUES ('Cooper', 'Dog', 'German Shepherd', 8, 0, null)");
        db.updateDatabase("INSERT INTO Pets (name, type, breed, age, adopted, adoptedBy) VALUES ('Bella', 'Cat', 'Persian', 1, 0, null)");
        db.updateDatabase("INSERT INTO Pets (name, type, breed, age, adopted, adoptedBy) VALUES ('Olive', 'Cat', 'Maine Coon', 4, 0, null)");
        db.updateDatabase("INSERT INTO Pets (name, type, breed, age, adopted, adoptedBy) VALUES ('Leo', 'Cat', 'Bengal', 7, 0, null)");
        db.updateDatabase("INSERT INTO Pets (name, type, breed, age, adopted, adoptedBy) VALUES ('Chloe', 'Cat', 'British Shorthair', 6, 0, null)");
        // 1.1 insert shelter records of current users
        db.updateDatabase("INSERT INTO Users (name) VALUES ('Bob Bobbert')");
        db.updateDatabase("INSERT INTO Users (name) VALUES ('Carl Carlton')");
        db.updateDatabase("INSERT INTO Users (name) VALUES ('Jane Janeston')");
        db.updateDatabase("INSERT INTO Users (name) VALUES ('Dan Danbert')");
        db.updateDatabase("INSERT INTO Users (name) VALUES ('Susy Susan')");

        //1.2 Add a pet
        Dog dog = new Dog("Max",  "Beagle", 3);
        pets.addPet(dog);

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
        if (response.equals("yes")) {
            int id = users.getUserID(name); // Getting user's id using their name

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
            System.out.println("Creating new account: ");

            user = new User(name);
            users.NewUser(user);

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
        pets.adoptPet(petName, user.getUserID());
        
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