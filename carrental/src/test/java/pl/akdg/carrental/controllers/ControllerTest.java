package pl.akdg.carrental.controllers;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import pl.akdg.carrental.CarRentalAppConfiguration;
import pl.akdg.carrental.CarRentalWebConfiguration;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes= {CarRentalAppConfiguration.class, CarRentalWebConfiguration.class})
@WebAppConfiguration
public class ControllerTest {
	
	@Autowired
	private WebApplicationContext wac;
	
	private MockMvc mockMvc;
	
	@Before
	public void setup() {
		this.mockMvc=MockMvcBuilders.webAppContextSetup(wac).build();
	}
	
	@Test
	public void stronaTest() throws Exception {
		mockMvc.perform(get("/")).andExpect(status().isOk());
	}
}
