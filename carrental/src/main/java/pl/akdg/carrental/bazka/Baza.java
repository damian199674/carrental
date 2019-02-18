package pl.akdg.carrental.bazka;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Baza {
	public static void main(String[] args) {
		
		try {
			Class.forName("org.hsqldb.jdbcDriver");
			
			Connection connection = DriverManager.getConnection("jdbc:hsqldb:file:data/carrental", "sa", "");
			
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery("SELECT * FROM Clients");
			while(resultSet.next()) {
				System.out.println(resultSet.getString("login"));
			}
			statement.execute("SHUTDOWN");
			statement.close();
			connection.close();
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
