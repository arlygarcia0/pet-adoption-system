package Pets;
public class Cat extends Pet {
    // Construcotr

    public Cat(String name, String breed, int age) {
        super(name, breed, age);
    }
    // method overriding 
    @Override
    public void makeSound() {
        System.out.prinln("Meow!");
    }
}