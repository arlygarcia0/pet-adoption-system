package Models;

// Making Pet abstract because we don't want a pet object to be instantiated, it has to be either dog/cat
public abstract class Pet {
    // Attributes using encapsulation
    private String name;
    private String breed;
    private int age;
    private boolean adopted;
    private int adoptedByID;

    // Constructor
    public Pet(String name, String breed, int age) {
        this.name = name;
        this.breed = breed;
        this.age = age;
        this.adopted = false;
        this.adoptedByID = -1;
    }

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
    public boolean isAdopted() {
        return adopted;
    }
    public int getAdoptedByID() {
        return adoptedByID;
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
    public void setAdopted(boolean adopted) {
        this.adopted = adopted;
    }
    public void setAdoptedByID(int adoptedByID) {
        this.adoptedByID = adoptedByID;
        this.adopted = true; // automatically mark as adopted
    }
}