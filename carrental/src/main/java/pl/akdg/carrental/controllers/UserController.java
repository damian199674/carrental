package pl.akdg.carrental.controllers;

import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/user/")
public class UserController {

	@RequestMapping(path="login", method=RequestMethod.GET)
	@ResponseBody
	public String test(@RequestParam("login") String login, HttpServletRequest request) {
		request.getSession().setAttribute("login", login);
		return "Ustawi³em w sesji login: "+login;
	}
}
