package de.com.heycar.website;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import de.com.heycar.website.controller.ClientController;

public class ClientControllerTest extends WebsiteApplicationTests {

	private MockMvc mockMvc;
	
	@Autowired
	private ClientController clientController;
	
	@Before
	public void setUp() {
		this.mockMvc = MockMvcBuilders.standaloneSetup(clientController).build();
	}
	
	@Test
	public void testGETCarsWithColorBlack() throws Exception {
		this.mockMvc.perform(MockMvcRequestBuilders.get("/client?make=&model=&color=black&year=")).andExpect(MockMvcResultMatchers.status().isOk());
	}
	
	@Test
	public void testGETAllCarsFromWolkswagen() throws Exception {
		this.mockMvc.perform(MockMvcRequestBuilders.get("/client?make=Volkswagen&model=&color=&year=")).andExpect(MockMvcResultMatchers.status().isOk());
	}
	
	@Test
	public void testGETAllCarsFromWolkswagenColorGreenYear2018() throws Exception {
		this.mockMvc.perform(MockMvcRequestBuilders.get("/client?make=Volkswagen&model=&color=green&year=2018")).andExpect(MockMvcResultMatchers.status().isOk());
	}
}
