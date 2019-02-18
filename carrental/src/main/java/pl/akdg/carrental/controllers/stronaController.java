package pl.akdg.carrental.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import pl.akdg.carrental.dto.IssueForm;

@Controller
@RequestMapping("/strona/")
public class stronaController {

	@RequestMapping(path="/about", method=RequestMethod.GET)
	public String about() {
		return "about";
	}
	@RequestMapping(path="/home", method=RequestMethod.GET)
	public String home() {
		return "home";
	}
	
	@RequestMapping(path="/product_rent", method=RequestMethod.GET)
	public String product_rent() {
		return "product_rent";
	}
	@RequestMapping(path="/product_list", method=RequestMethod.GET)
	public String product_list() {
		return "product_list";
	}
	@RequestMapping(path="/product_detail", method=RequestMethod.GET)
	public String product_detail() {
		return "product_detail";
	}
}
