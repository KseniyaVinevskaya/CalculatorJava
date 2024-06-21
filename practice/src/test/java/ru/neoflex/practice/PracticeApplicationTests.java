package ru.neoflex.practice;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@AutoConfigureMockMvc
public class PracticeApplicationTests {

	@Autowired
	private MockMvc mockMvc;

	@Test
	public void Sum() throws Exception {
		this.mockMvc.perform(get("/calc/plus/3/2"))
				.andDo(print())
				.andExpect(status().isOk())
				.andExpect(content().string("5"));
	}

	@Test
	public void Difference() throws Exception {
		this.mockMvc.perform(get("/calc/minus/5/3"))
				.andDo(print())
				.andExpect(status().isOk())
				.andExpect(content().string("2"));
	}
}