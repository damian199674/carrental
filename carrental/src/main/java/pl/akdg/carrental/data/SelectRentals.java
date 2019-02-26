package pl.akdg.carrental.data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import pl.akdg.carrental.dto.MyRentals;

public class SelectRentals {
	List<MyRentals> myRentals;
	public List selectRentals(String nick) {
		myRentals=new ArrayList<MyRentals>();
		try {
			Class.forName("org.hsqldb.jdbcDriver");
			
			Connection connection = DriverManager.getConnection("jdbc:hsqldb:file:data/carrental", "sa", "");
   			PreparedStatement preparedStatement=connection.prepareStatement("SELECT mark, model, rental_date, return_date, (price_hour*24*(DATEDIFF(rental_date, return_date))) AS price FROM Cars INNER JOIN Rentals ON(Cars.id_car=Rentals.plate_number) WHERE login='?'");
   			preparedStatement.setString(1, nick);
   			
			ResultSet resultSet = preparedStatement.executeQuery();
			while(resultSet.next()) {
				myRentals.add(new MyRentals(resultSet.getString("mark"), resultSet.getString("model"), resultSet.getDate("rental_date"), resultSet.getDate("return_date"), resultSet.getInt("price")));
			}
			preparedStatement.close();
			Statement statement=connection.createStatement();
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
		return myRentals;
	}
}

