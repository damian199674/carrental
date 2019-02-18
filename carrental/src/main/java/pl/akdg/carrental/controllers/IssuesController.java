package pl.akdg.carrental.controllers;

import java.util.Locale;
import java.util.Map;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import pl.akdg.carrental.dto.IssueForm;
import pl.akdg.carrental.dto.RecordRange;
import pl.akdg.carrental.services.IssuesService;

@Controller
@RequestMapping("/issue/")
public class IssuesController {
	
	private IssuesService issueService;
	
	@Autowired
	public IssuesController(IssuesService issueService) {
		super();
		this.issueService = issueService;
	}


	@RequestMapping("/")
	public String test(@RequestParam("range") RecordRange range, Model model) {
		model.addAttribute("issues", issueService.listIssues().subList(range.getFrom(), range.getTo()));
		return "issuesList";
	}
	
	@RequestMapping(path= {"/issue/{idIssue}/{test}", "/issue/{idIssue}"}, method=RequestMethod.GET)
	@ResponseBody
	public String testIssue(@PathVariable("idIssue") String idIssue, @PathVariable("test") Optional<String> test){
		return "Wartoœæ zmiennej"+idIssue+ test.orElse("puste");
	}
	
	@RequestMapping(path="/add", method=RequestMethod.GET)
	public String addIssue(@ModelAttribute IssueForm issueForm) {
		return "addIssue";
	}
	
	@RequestMapping(path="save",  method=RequestMethod.POST)
	public String saveIssue(@Valid @ModelAttribute IssueForm issueForm, BindingResult bindingResult) {
		if (bindingResult.hasFieldErrors()) {
			return "addIssue";
		}
		//zapis danych
		return "redirect:/issue/?range=0-3";
	}
}
