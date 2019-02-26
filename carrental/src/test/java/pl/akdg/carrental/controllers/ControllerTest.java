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
	public void homeTest() throws Exception {
		mockMvc.perform(get("/")).andExpect(status().isOk());
	}
	@Test
	public void aboutTest() throws Exception {
		mockMvc.perform(get("/about")).andExpect(status().isOk());
	}	
	@Test
	public void registerTest() throws Exception {
		mockMvc.perform(get("/register")).andExpect(status().isOk());
	}
	@Test
	public void loginTest() throws Exception {
		mockMvc.perform(get("/login")).andExpect(status().isOk());
	}
	@Test
	public void carsTest() throws Exception {
		mockMvc.perform(get("/cars")).andExpect(status().isOk());
	}
	@Test
	public void maluchTest() throws Exception {
		mockMvc.perform(get("/cars/maluch")).andExpect(status().isOk());
	}
	@Test
	public void poldekTest() throws Exception {
		mockMvc.perform(get("/cars/poldek")).andExpect(status().isOk());
	}
	@Test
	public void ferrariTest() throws Exception {
		mockMvc.perform(get("/cars/ferrari")).andExpect(status().isOk());
	}
	@Test
	public void rentTest() throws Exception {
		mockMvc.perform(get("/rentCar")).andExpect(status().isOk());
	}
}
