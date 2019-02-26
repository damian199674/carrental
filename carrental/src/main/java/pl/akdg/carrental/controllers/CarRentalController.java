package pl.akdg.carrental.controllers;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.servlet.ModelAndView;

import pl.akdg.carrental.data.Clients;
import pl.akdg.carrental.data.Rentals;
import pl.akdg.carrental.dto.MyRentals;
import pl.akdg.carrental.dto.RegisterForm;
import pl.akdg.carrental.services.MyRentalServices;

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
	public String login() {
		return "login";
	}
    @RequestMapping(path="/login",  method=RequestMethod.POST)
  	public String login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nick=request.getParameter("nick");
    	request.getSession().setAttribute("login", nick);
    	return "home";
    }
    @RequestMapping(path="/logout", method=RequestMethod.GET)
	public String logout(HttpServletRequest request) {
    	request.removeAttribute("login");
		return "home";
    }
   /* @RequestMapping(path="/register", method=RequestMethod.GET)
	public String addUser(@ModelAttribute RegisterForm registerForm) {
		return "register";
	}*/
    @RequestMapping(path="/register", method=RequestMethod.GET)
	public String register() {
		return "register";
    }
    /*@RequestMapping(path="/register",  method=RequestMethod.POST)
	public String register(@RequestParam("nick") String nick, @RequestParam("password") String password) {
    	
    	 HttpClient httpClient = HttpClientBuilder.create().build(); //Use this instead 
			
			try {
			
			    HttpPost request = new HttpPost("http://yoururl");
			    StringEntity params =new StringEntity("details={\"name\":\"myname\",\"age\":\"20\"} ");
			    request.addHeader("content-type", "application/x-www-form-urlencoded");
			    request.setEntity(params);
			    HttpResponse response = httpClient.execute(request);
			
			    //handle response here...
			
			}catch (Exception ex) {
			
			    //handle exception here
			
			} finally {
			    //Deprecated
			    //httpClient.getConnectionManager().shutdown(); 
			}
    	 
		try {
			Class.forName("org.hsqldb.jdbcDriver");
			
			Connection connection = DriverManager.getConnection("jdbc:hsqldb:file:data/carrental", "sa", "");
			PreparedStatement preparedStatement=connection.prepareStatement("INSERT INTO Clients VALUES(?,?)");
			preparedStatement.setString(1, nick);
			preparedStatement.setString(2, password);
			
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
	}*/
    @RequestMapping(path="/register",  method=RequestMethod.POST)
   	public String register(HttpServletRequest request, HttpServletResponse response, Clients clients) throws ServletException, IOException {
    		String nick=request.getParameter("nick");
    		String password=request.getParameter("password");
    	/*try {
   			Class.forName("org.hsqldb.jdbcDriver");
   			
   			Connection connection = DriverManager.getConnection("jdbc:hsqldb:file:data/carrental", "sa", "");
   			PreparedStatement preparedStatement=connection.prepareStatement("INSERT INTO Clients VALUES(?,?)");
   			preparedStatement.setString(1, nick);
   			preparedStatement.setString(2, password);
   			
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
   		}*/
    	clients.insertClient(nick, password);
   		return "home";
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
    @RequestMapping(path="/rentCar", method=RequestMethod.GET)
	public String rentCar() {
		return "rent";
	}
//    @RequestMapping(path="/rentCar", method=RequestMethod.POST)
//	public String rentCar(@RequestParam("rent_start") String rent_start,@RequestParam("rent_return") String rent_return, @RequestParam("payment") String payment) {
//		if(payment=="przelewy24")
//			return "about";
//		else
//			return "home";
//	}
   /* 
    @RequestMapping(path="/rentCar", method=RequestMethod.POST)
	public String rentCar(@RequestBody String values) {
		String[] parts=values.split("&");
		String payment=parts[1];
		payment=payment.substring(8);
		if(payment.equals("przelewy24")) {
			return "przelewy24";
		}
		else {
			return "home";
		}
	}*/
    @RequestMapping(path="/rentCar", method=RequestMethod.POST)
	public String rentCar(HttpServletRequest request, HttpServletResponse response, Rentals rentals) throws ServletException, IOException, NumberFormatException, ParseException {
		String login=request.getParameter("login");
    	String payment=request.getParameter("payment");
		String rent_start=request.getParameter("rent_start");
		String rent_return=request.getParameter("rent_return");
		String car=request.getParameter("car");
		if(payment.equals("przelewy24")) {
			return "przelewy24";
		}
		else {
			rentals.insertRental(login, Integer.parseInt(car), rent_start, rent_return);
			return "cash";
		}
	}
	/*
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
	}*/
}
