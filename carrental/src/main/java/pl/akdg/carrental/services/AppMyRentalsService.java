package pl.akdg.carrental.services;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import pl.akdg.carrental.dto.MyRentals;

public class AppMyRentalsService implements MyRentalServices{
	private List<MyRentals> myRentals;
	
	public AppMyRentalsService() {
		super();
		myRentals=new ArrayList<MyRentals>();
		try {
			Class.forName("org.hsqldb.jdbcDriver");
			
			Connection connection = DriverManager.getConnection("jdbc:hsqldb:file:data/carrental", "sa", "");
			
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery("SELECT mark, model, rental_date, return_date, (price_hour*24*(DATEDIFF(rental_date, return_date))) AS price FROM Cars INNER JOIN Rentals ON(Cars.id_car=Rentals.plate_number) WHERE login='damian'");
			while(resultSet.next()) {
				myRentals.add(new MyRentals(resultSet.getString("mark"), resultSet.getString("model"), resultSet.getDate("rental_date"), resultSet.getDate("return_date"), resultSet.getInt("price")));			
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

	public String getMyRentals() {
		// TODO Auto-generated method stub
		return null;
	}

	public List<MyRentals> listRentals() {
		return Collections.unmodifiableList(myRentals);
	}

}
