import Pets.*;

// Adding a new pet to the shelter using *Polymorphism* -> Overloading
public class NewPet extends AdoptionCenter{
    // Add Dog
    public void addPet(Dog dog) {
        db.updateDatabase("INSERT INTO Pets (name, type, breed, age, adopted) VALUES ("+ dog.getName() + ", 'Dog',"+ dog.getBreed() + ", "+ dog.getAge() + ", 0)");
    }
    // Add Cat
    public void addPet(Cat cat) {
        db.updateDatabase("INSERT INTO Pets (name, type, breed, age, adopted) VALUES ("+ cat.getName() + ", 'Cat',"+ cat.getBreed() + ", "+ cat.getAge() + ", 0)");
    }
}