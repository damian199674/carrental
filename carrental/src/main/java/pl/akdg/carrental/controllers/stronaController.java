package pl.akdg.carrental.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import pl.akdg.carrental.dto.IssueForm;

@Controller
@RequestMapping("/")
public class stronaController {

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
}
