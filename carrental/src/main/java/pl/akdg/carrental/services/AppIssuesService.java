package pl.akdg.carrental.services;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import pl.akdg.carrental.dto.Issue;

public class AppIssuesService implements IssuesService {
	
	private List<Issue> issues;

	public AppIssuesService() {
		super();
		issues=new ArrayList<Issue>();
		issues.add(new Issue("Tytul1", "Tresc1", 1, new Date()));
		issues.add(new Issue("Tytul2", "Tresc2", 2, new Date()));
		issues.add(new Issue("Tytul3", "Tresc3", 3, new Date()));
	}

	public String getIssue() {
		return "Issue from APP";
	}

	public List<Issue> listIssues() {
		return Collections.unmodifiableList(issues);
	}

}
