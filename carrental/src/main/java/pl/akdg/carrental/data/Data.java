package pl.akdg.carrental.data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Data {

	public static void main(String[] args) {
		try {
			Class.forName("org.hsqldb.jdbcDriver");
			
			Connection connection = DriverManager.getConnection("jdbc:hsqldb:file:data/carrental", "sa", "");
			
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery("SELECT mark, model, rental_date, return_date, (price_hour*24*(DATEDIFF(rental_date, return_date))) AS price FROM Cars INNER JOIN Rentals ON(Cars.id_car=Rentals.plate_number) WHERE login='damian'");
			while(resultSet.next()) {
				System.out.println(resultSet.getString("mark")+resultSet.getDate("rental_date")+resultSet.getInt("price"));
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
		
		/*
		
		try {
			Class.forName("org.hsqldb.jdbcDriver");
			
			Connection connection = DriverManager.getConnection("jdbc:hsqldb:file:data/carrental", "sa", "");
			
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery("SELECT * FROM Rentals");
			while(resultSet.next()) {
				System.out.println(resultSet.getDate("rental_date"));
			}
			statement.execute("SHUTDOWN");
			statement.close();
			connection.close();
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
		//	e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
*/
