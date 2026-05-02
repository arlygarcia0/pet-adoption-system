// Import necessary packages.
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;

public class Database {
	
	// DATABASE ATTRIBUTES
	private Connection connect = null; // will connect to our db file using our SQLite Driver.
	private Statement statement = null; // will run our queries/commands.

	// DATABASE METHODS
	public Database() { //Constructor to connect to our database
		connectDatabase();
	}

	// Connect to my Database
	private void connectDatabase() {
		try {
			String url = "jdbc:sqlite:database.db";
			// Connect to the database using our URL
			connect = DriverManager.getConnection(url);
			// Initialize our statement attribute to be able to execute SQL code into our db 
			statement = connect.createStatement();
		}
		catch(SQLException e) {
			//Print out the error we are having
			System.err.println("Failed to connect to Database.");
			System.err.println(e.toString());
		}
	}

	// create, insert, or update into our Database
	public void updateDatabase(String query) {
		try {
			// If our connection has been lost, run connectDatabase() function
			if (connect == null) {
				connectDatabase();
			}
			//This will run the SQL string command passe to updateDatabase
			statement.executeUpdate(query);
		}
		catch (SQLException e) {
			//Print out error message along with exception
			System.err.println("Failed to update Database.");
			System.err.println(e.toString());
		}
	}

	// Read from our Database Table
	public void readDatabase(String query) {
		try {
			// if connection is not there, connect to our database
			if (connect == null) {
				connectDatabase();
			}
			//Instead of suing executeUpdate(), we use executeQuery() this will return a ResultSet
			ResultSet result = statement.executeQuery(query);
			//We will keeep calling the next() method from result until it is empty
			//We will read row by row
			while(result.next()) {
				System.out.println(result.getString(1) +", " + result.getString(2) + ", " + result.getString(3) + ", " + result.getString(4) + ", " + result.getString(5) + ", " + result.getString(6));
			}
		}
		catch (SQLException e) {
			System.err.println("Failed to read from Database");
			System.err.println(e.toString());
		}
	}

	//Read from our database and return -> Using object to return any data type
	public Object returnDatabase (String query, String columnName) {
		try {
			if (connect == null) {
				connectDatabase();
			}
			ResultSet result = statement.executeQuery(query);
			if(result.next()) {
				return result.getObject(columnName);
			}
			
		}
		catch (SQLException e) {
			System.err.println("Failed to return from Database");
			System.err.println(e.toString());
		}
		return null;
	}
}