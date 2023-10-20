package org.perscholas.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class PreparedStatementExample {
	
	
	// 1) Expand the output inside the while loop to also print out the last name
	// 2) Use the scanner to also ask for the last name and modify the query to searcy for
	// firstname and lastname
	

	public static void main(String[] args) throws SQLException {
		// change this query string to use localhost instead of 192.168.2.100
		String dburl = "jdbc:mysql://192.168.2.100:3306/classic_models";
		String user = "dev";
		String password = "ultra30dev";

		Connection connection = null;

		try {
			Class.forName("com.mysql.cj.jdbc.Driver"); // optional
			connection = DriverManager.getConnection(dburl, user, password);
			
			Scanner scanner = new Scanner(System.in);
			System.out.println("Enter an employee first name :");
			String firstname = scanner.nextLine();

			//String sql = "Select * FROM employees where firstname = '" + firstname + "'";
			String sql = "Select * FROM employees where firstname = ?";
			System.out.println(sql);			
			
			// this is the secure way of creating a query
			PreparedStatement stmt = connection.prepareStatement(sql);
			// the first ? in the query is position 1
			stmt.setString(1, firstname);

			// in this line of code we are not going to pass in the SQL because we have already 
			// passed it into the prepared statement
			ResultSet result = stmt.executeQuery();

			while (result.next()) {
				Integer id = result.getInt("id");
				String name = result.getString("firstname");
				String email = result.getString("email");
				System.out.println(id + " | " + name + " | " + email);
			}

			result.close();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (connection != null) {
				connection.close();
			}
		}
	}

}
