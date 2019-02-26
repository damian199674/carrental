package pl.akdg.carrental;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import pl.akdg.carrental.services.AppMyRentalsService;
import pl.akdg.carrental.services.MyRentalServices;


@Configuration
public class CarRentalAppConfiguration {
	@Bean
	public MyRentalServices myRentalServices() {
		return new AppMyRentalsService();
	}
	
}
