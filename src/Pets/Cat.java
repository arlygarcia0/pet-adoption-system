package Pets;
public class Cat extends Pet {
    // Construcotr
    public Cat(String name, String breed, int age) {
        super(name, breed, age);
    }
    // Method overriding 
    @Override
    public void displayInfo() {
        System.out.println("Cat: " + getName() + " - " + getBreed() + " - " + getAge() + " years old");
    }
}