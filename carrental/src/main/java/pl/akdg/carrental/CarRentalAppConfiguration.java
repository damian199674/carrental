package pl.akdg.carrental;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import pl.akdg.carrental.services.AppIssuesService;
import pl.akdg.carrental.services.IssuesService;

@Configuration
public class CarRentalAppConfiguration {
	
	@Bean
	public IssuesService issueService() {
		return new AppIssuesService();
	}
}
