package pl.akdg.carrental.controllers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import pl.akdg.carrental.data.SelectRentals;
import pl.akdg.carrental.dto.MyRentals;
import pl.akdg.carrental.services.MyRentalServices;

@Controller
@RequestMapping("/")
public class MyRentalsController {
	private MyRentalServices myRentalServices;
	
	@Autowired
	public MyRentalsController(MyRentalServices myRentalServices) {
		super();
		this.myRentalServices=myRentalServices;
	}
  /*  @RequestMapping(path="/my", method=RequestMethod.GET)
   	public String my() {
   		return "my";
       }
    @RequestMapping(path="/my",  method=RequestMethod.POST)
    @ResponseBody
  	public List my(HttpServletRequest request, HttpServletResponse response, SelectRentals selectRentals) throws ServletException, IOException, IndexOutOfBoundsException {
		String nick=request.getParameter("nick");
    	return  selectRentals.selectRentals(nick);
    }*/
    @RequestMapping("/myrentals")
   	public String myrentals(Model model) {
    	model.addAttribute("myRentals", myRentalServices.listRentals()); 
   		return "myrentals";
       }
}
