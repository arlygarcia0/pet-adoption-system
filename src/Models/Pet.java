package Models;

// Making Pet abstract because we don't want a pet object to be instantiated, it has to be either dog/cat
public abstract class Pet {
    // Attributes using encapsulation
    private String name;
    private String breed;
    private int age;

    // Constructor
    public Pet(String name, String breed, int age) {
        this.name = name;
        this.breed = breed;
        this.age = age;
    }

    // Abstract method -> Polymorphims using Override
    public abstract String getType();

    // Getters  
    public String getName() {
        return name;
    }
    public String getBreed() {
        return breed;
    }
    public int getAge() {
        return age;
    }
    
    // Setters
     public void setName(String name) {
        this.name = name;
    }
    public void setBreed(String breed) {
        this.breed = breed;
    }
    public void setAge(int age) {
        this.age = age;
    }
}