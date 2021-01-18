package com.minigames.fizzbuzz;

import com.minigames.fizzbuzz.controller.FizzbuzzController;
import org.assertj.core.util.Lists;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.util.ReflectionTestUtils;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class ApplicationTests {

	@Autowired
	private MockMvc mockMvc;

	@Autowired
	FizzbuzzController fizzbuzzController;

	private final List<String> CORRECT_SAMPLE_RESPONSE = Lists.list("1", "2", "fizz", "4", "buzz", "fizz", "7", "8", "fizz", "buzz", "11", "fizz", "13", "14", "fizzbuzz");

	@Test
	public void test_GetGame_WrongEndpoint() throws Exception {
		this.mockMvc.perform(get("/game")).andDo(print()).andExpect(status().isNotFound());
	}

	@Test
	public void test_GetGame_NoStartingNumberParam() throws Exception {
		this.mockMvc.perform(get("/fizzbuzz")).andDo(print()).andExpect(status().isBadRequest());
	}

	@Test
	public void test_GetGame_InvalidStartingNumber_TooSmall() throws Exception {
		this.mockMvc.perform(get("/fizzbuzz").param("starting_number", "-10")).andDo(print()).andExpect(status().isBadRequest()).andExpect(status().reason("Invalid starting_number parameter value"));
	}

	@Test
	public void test_GetGame_InvalidStartingNumber_ExceedsTarget() throws Exception {
		this.mockMvc.perform(get("/fizzbuzz").param("starting_number", "10000")).andDo(print()).andExpect(status().isBadRequest()).andExpect(status().reason("Invalid starting_number parameter value"));
	}

	@Test
	public void test_GetGame_GivenCorrectStartingNumber() throws Exception {
		ReflectionTestUtils.setField(fizzbuzzController, "targetNumber", 15);
		this.mockMvc.perform(get("/fizzbuzz").param("starting_number", "1")).andDo(print()).andExpect(status().isOk())
		.andExpect(jsonPath("$.resultingGame").value(CORRECT_SAMPLE_RESPONSE));
	}

}
