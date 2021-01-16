package com.minigames.fizzbuzz;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class ApplicationTests {

	@Autowired
	private MockMvc mockMvc;

	@Test
	public void test_GetGame_NoStartingNumberParam() throws Exception {
		this.mockMvc.perform(get("/game")).andDo(print()).andExpect(status().isBadRequest());
	}

	@Test
	public void test_GetGame_GivenStartingNumber() throws Exception {
		this.mockMvc.perform(get("/game").param("starting_number", "5")).andDo(print()).andExpect(status().isOk())
		.andExpect(jsonPath("$.resultingGame").value(new String[]{}));
	}

}
