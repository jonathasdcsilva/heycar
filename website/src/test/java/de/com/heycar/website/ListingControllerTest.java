package de.com.heycar.website;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import de.com.heycar.website.controller.ListingController;

public class ListingControllerTest extends WebsiteApplicationTests {

	private MockMvc mockMvc;
	
	String json = new String("[{\"code\": 3,\"make\": \"Nissan\",\"model\": \"XX 780\",	\"power\": 123,\"year\": 2014,\"color\": \"black\",\"price\": 15950,\"idDealer\": 1	},\r\n" + 
			"{\"code\": 4,\"make\": \"Mitsubishi\",\"model\": \"Eclipse\",\"power\": 123,\"year\": 2014,\"color\": \"black\",\"price\": 15950,\"idDealer\": 1}]");
	
	@Autowired
	ListingController listingController;
	
	@Autowired
	private WebApplicationContext webApplicationContext;
	
	@Before
	public void setUp() {
		this.mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
	}
	
	@Test
	public void testGETListingsFromDealer() throws Exception {
		this.mockMvc.perform(MockMvcRequestBuilders.get("/listing/1"))
				.andExpect(MockMvcResultMatchers.status().isOk());
	}
	
	@Test
	public void testPOSTSaveListing() throws Exception {
		this.mockMvc.perform(MockMvcRequestBuilders.post("/listing")).andExpect(MockMvcResultMatchers.redirectedUrl("/listing/3"));
	}
	
	@Test
	public void testPUTListing() throws Exception {
		this.mockMvc.perform(MockMvcRequestBuilders.put("/listing/3")
				.content(json)).andExpect(MockMvcResultMatchers.redirectedUrl("/listing/3"));
	}

}
