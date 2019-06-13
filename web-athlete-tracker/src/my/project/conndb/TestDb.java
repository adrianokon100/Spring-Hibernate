package my.project.conndb;


import java.sql.*;

import com.mysql.cj.xdevapi.Statement;

public class TestDb {
	public static void main(String[] args) {
	
	String user = "springstudent2";
	String pass = "springstudent2";

	String url =
			"jdbc:mysql://localhost:3306/web_athlete_tracker?"
			+ "useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";	
	String driver = "com.mysql.cj.jdbc.Driver";
	
	try {
		Connection conn = DriverManager.getConnection(url, user, pass);
		System.out.println("Is working goood");
		
		// Create a statement
		java.sql.Statement myStat = conn.createStatement();
		
		// Execute SQL query
		ResultSet myRs = myStat.executeQuery("select * from athlete");
		
		while(myRs.next()) {
			System.out.println(myRs.getString("first_name"));
		}
		
		conn.close();
		
	} catch (SQLException e) {
		e.printStackTrace();
		System.out.println("Is not working.");
	}


	
	}
}
