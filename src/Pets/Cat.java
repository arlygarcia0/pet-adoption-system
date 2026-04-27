package Pets;
public class Cat extends Pet {
    // Construcotr
    public Cat(String name, String breed, int age) {
        super(name, breed, age);
    }
    // Method overriding 
    @Override
    public void displayInfo() {
        System.out.println("Dog: " + getName() + " - " + getBreed() + " - " + getAge() + " years old");
    }
}