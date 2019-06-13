package testDb;
import java.sql.*;

public class Driver {

	public static void main(String[] args) {
		
		
		
		String user = "springstudent3";
		String pass = "springstudent3";
		
		String query = "jdbc:mysql://localhost:3306/tournament_poker?"
				+ "useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
				
		try {
			
			//Class.forName("com.mysql.cj.jdbc.Driver");

			// Get a connection to database
			Connection myConn = DriverManager.getConnection(query, user, pass);
			
			// Create a statement
			Statement myStat = myConn.createStatement();
			
			// Execute SQL query
			ResultSet myRs = myStat.executeQuery("select * from place");
			
			
			// Process the result set
			while(myRs.next()) {
				System.out.println(myRs.getString("name"));
			}
					
			System.out.println("Is good :)");
			
		} catch (Exception exc) {
			// TODO Auto-generated catch block
			exc.printStackTrace();
			System.out.println("Sorry - not good");
		}
		
	
		
		
	}

}
