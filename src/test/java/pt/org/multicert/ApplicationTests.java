package pt.org.multicert;

import org.hamcrest.CoreMatchers;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@SpringBootTest
@AutoConfigureMockMvc
class ApplicationTests {

	@Autowired
	private MockMvc mockMvc;

	@Test
	void contextLoads() {
	}

	@Test
	public void givenCountryCodePT() throws Exception {

		ResultActions response = mockMvc.perform(MockMvcRequestBuilders.get("/countries/code/pt"));

		response.andExpect(MockMvcResultMatchers.status().isOk());
		response.andExpect(MockMvcResultMatchers.jsonPath("$.name", CoreMatchers.is("Portugal")));

	}

	@Test
	public void givenNoCountryCode() throws Exception {

		String iso = "qm";
		ResultActions response = mockMvc.perform(MockMvcRequestBuilders.get("/countries/code/"+iso));

		response.andExpect(MockMvcResultMatchers.status().isNotFound());
		response.andExpect(MockMvcResultMatchers.jsonPath("$.message", CoreMatchers.is("Country with code "+iso+" was not found")));

	}

}
