public class AdoptionCenter {
    protected Database db = new Database();
    //Constructor
    public AdoptionCenter() {
        //Create a table for pets in shelter
        db.updateDatabase("CREATE TABLE Pets (id INT PRIMARY KEY, name VARCHAR(50), type VARCHAR(50), breed VARCHAR(50), age INT, adopted BOOLEAN)");
    }
}