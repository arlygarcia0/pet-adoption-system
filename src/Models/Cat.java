package Models;
public class Cat extends Pet {
    // Construcotr
    public Cat(String name, String breed, int age) {
        super(name, breed, age);
    }

    @Override
    public String getType() {
        return "Cat";
    }
}