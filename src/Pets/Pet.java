package Pets;

public abstract class Pet {
    
    // Encapsulation
    private String name;
    private String breed;
    private int age;
    private boolean adopted;

    // Constructor

    public Pet(String name, String breed, int age) {
        this.name = name;
        this.breed = breed;
        this.age = age;
        this.adopted = false;
    }

    // Getter and setters

    public String getName() {
        return name;
    }

    public String getBreed() {
        return breed;
    }

    public int getAge() {
        return age;
    }

    public boolean isAdopted() {
        return adopted;
    }

    public void setAdopted(boolean adopted) {
        this.adopted = adopted;
    }

    //Absraction 
    public abstract void makeSound();

    // method 

    public void displayInfo() {
        System.out.println(name + " - " + breed + " - " + age + " years old");
    }




}