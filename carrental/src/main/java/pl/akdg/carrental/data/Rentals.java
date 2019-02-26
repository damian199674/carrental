package pl.akdg.carrental.data;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class Rentals {
	public void insertRental(String login, int plate_number, String rent_start, String rent_return) {
		try {
   			Class.forName("org.hsqldb.jdbcDriver");
   			
   			Connection connection = DriverManager.getConnection("jdbc:hsqldb:file:data/carrental", "sa", "");
   			PreparedStatement preparedStatement=connection.prepareStatement("INSERT INTO Rentals(login,plate_number,rental_date, return_date) VALUES(?,?,?,?)");
   			preparedStatement.setString(1, login);
   			preparedStatement.setInt(2, plate_number);
   			preparedStatement.setString(3, rent_start);
   			preparedStatement.setString(4, rent_return);

   			
   			preparedStatement.executeUpdate();

   			preparedStatement.close();
   			Statement statement = connection.createStatement();
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
