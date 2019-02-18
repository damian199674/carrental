package pl.akdg.carrental.services;

import java.util.List;

import pl.akdg.carrental.dto.Issue;

public interface IssuesService {
	String getIssue();
	List<Issue> listIssues();
}
