package pl.akdg.carrental.controllers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttribute;


import pl.akdg.carrental.dto.RegisterForm;

@Controller
@RequestMapping("/")
public class CarRentalController {

	@RequestMapping(path="/about", method=RequestMethod.GET)
	public String about() {
		return "about";
	}
	@RequestMapping(path="/", method=RequestMethod.GET)
	public String home() {
		return "home";
	}
	
	@RequestMapping(path="/rent", method=RequestMethod.GET)
	public String product_rent() {
		return "product_rent";
	}
	@RequestMapping(path="/cars", method=RequestMethod.GET)
	public String product_list() {
		return "product_list";
	}
	@RequestMapping(path="/detail", method=RequestMethod.GET)
	public String product_detail() {
		return "product_detail";
	}
    @RequestMapping(path="/login", method=RequestMethod.GET)
	public String login(@SessionAttribute("login") String login) {
		return "login";
	}
  /*  @RequestMapping(path="/register", method=RequestMethod.GET)
	public String register() {
		return "register";
	}*/
    @RequestMapping(path="/register", method=RequestMethod.GET)
	public String addUser(@ModelAttribute RegisterForm registerForm) {
		return "register";
	}
	@RequestMapping(path="/cars/maluch", method=RequestMethod.GET)
	public String car1() {
		return "car1";
	}
    @RequestMapping(path="/cars/poldek", method=RequestMethod.GET)
	public String car2() {
		return "car2";
	}
    @RequestMapping(path="/cars/ferrari", method=RequestMethod.GET)
	public String car3() {
		return "car3";
	}
	
	@RequestMapping(path="/save",  method=RequestMethod.POST)
	public String saveUser(@Valid @ModelAttribute RegisterForm registerForm, BindingResult bindingResult) {
		if (bindingResult.hasFieldErrors()) {
			return "register";
		}
		try {
			Class.forName("org.hsqldb.jdbcDriver");
			
			Connection connection = DriverManager.getConnection("jdbc:hsqldb:file:data/carrental", "sa", "");
			PreparedStatement preparedStatement=connection.prepareStatement("INSERT INTO Clients VALUES(?,?)");
			preparedStatement.setString(1, registerForm.getNickname());
			preparedStatement.setString(2, registerForm.getPassword());
			
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
		return "home";
	}
}
