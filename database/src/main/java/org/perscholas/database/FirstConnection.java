package org.perscholas.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class FirstConnection {

	public static void main(String[] args) throws SQLException {
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

			String sql = "Select * FROM employees where firstname = '" + firstname + "'";
			System.out.println(sql);			
			
			Statement stmt = connection.createStatement();

			ResultSet result = stmt.executeQuery(sql);

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
