package pl.akdg.carrental.controllers;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttribute;

import pl.akdg.carrental.services.IssuesService;

@Controller
@RequestMapping("/comment")
public class CommentsController {
	
	private IssuesService issueService;
	
	@Autowired
	public CommentsController(IssuesService issueService) {
		super();
		this.issueService = issueService;
	}


	@RequestMapping("/{idComment}")
	public String getComment(@PathVariable("idComment") String idComment, Model model) {
		model.addAttribute("idComment", idComment);
		return "comment";
	}
	
	@RequestMapping("/")
	@ResponseBody
	public String testParam(@RequestParam(name="pageNumber", required=false) String pageNumber, @RequestHeader("User-Agent") String userAgent, @SessionAttribute("login") String login) {
		return "wartosc "+pageNumber+ " UserAgent= "+userAgent+ "    login:"+login;
	}
	
	@RequestMapping(value="/add", method=RequestMethod.POST)
	@ResponseBody
	public String addComent(@RequestBody String body) {
		return body;
	}
}
