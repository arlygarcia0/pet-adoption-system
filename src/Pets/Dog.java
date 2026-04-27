package Pets;
public class Dog extends Pet {
    // Constructor 
    public Dog(String name, String  breed, int age) {
        super(name, breed, age);
    }
    // Method overriding 
    @Override
    public void displayInfo() {
        System.out.println("Dog: " + getName() + " - " + getBreed() + " - " + getAge() + " years old");
    }
}