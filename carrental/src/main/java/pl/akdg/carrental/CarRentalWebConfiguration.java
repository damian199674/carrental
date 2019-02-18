package pl.akdg.carrental;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;
import org.springframework.web.servlet.view.freemarker.FreeMarkerViewResolver;

import pl.akdg.carrental.converters.RecordRangeConverter;
import pl.akdg.carrental.dto.RecordRange;
import pl.akdg.carrental.services.IssuesService;
@Configuration
@ComponentScan("pl.akdg.carrental.controllers")
@EnableWebMvc
public class CarRentalWebConfiguration extends WebMvcConfigurerAdapter{
	
	@Bean
	public ViewResolver freeMarkerViewResolver() {
		FreeMarkerViewResolver freeMarkerViewResolver=new FreeMarkerViewResolver();
		freeMarkerViewResolver.setPrefix("");
		freeMarkerViewResolver.setSuffix(".html");
		freeMarkerViewResolver.setContentType("text/html; charset-UTF-8");
		return freeMarkerViewResolver;
	}
	@Bean
	public FreeMarkerConfigurer freeMarkerConfigurer() {
		FreeMarkerConfigurer freeMarkerConfigurer=new FreeMarkerConfigurer();
		freeMarkerConfigurer.setTemplateLoaderPath("classpath:/WEB-INF/templates/");
		return freeMarkerConfigurer;
	}
	@Override
	public void addFormatters(FormatterRegistry registry) {
		registry.addConverter(new RecordRangeConverter());
	}
	
	
}
