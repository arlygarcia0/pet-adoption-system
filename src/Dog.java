package Pets;
public class Dog extends Pet {
    // Constructor 
    public Dog(String name, String  breed, int age) {
        super(name, breed, age);
    }

    // method overriding
    @Override 
    public void makeSound() {
        System.out.print("Bark!");
    }
}