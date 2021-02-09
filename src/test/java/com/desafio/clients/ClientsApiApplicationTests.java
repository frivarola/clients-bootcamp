package com.desafio.clients;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class ClientsApiApplicationTests {
	@Autowired
	private MockMvc mockMvc;
	@Test
	void test1() throws Exception {
		this.mockMvc.perform(
				post("/api/v1/clients/add")
						.contentType(MediaType.APPLICATION_JSON)
						.content("{\"firstName\":\"Federico\",\"lastName\":\"Rivarola\",\"email\":\"federico@hotmail.com\",\"province\":\"Ontario\"}"))
				.andDo(print())
				.andExpect(status().isOk());
	}

	@Test
	void test2() throws Exception {
		this.mockMvc.perform(
				post("/api/v1/clients/add")
						.contentType(MediaType.APPLICATION_JSON)
						.content("{\"firstName\":\"Federico\",\"lastName\":\"Rivarola\",\"email\":\"federico@hotmail.com\"}"))
				.andDo(print())
				.andExpect(status().isBadRequest());
	}

	@Test
	void test3() throws Exception {
		this.mockMvc.perform(
				get("/api/v1/clients/get/all"))
				.andDo(print())
				.andExpect(status().isOk());
	}

	@Test
	void test4() throws Exception {
		this.mockMvc.perform(
				get("/api/v1/clients/get/noexiste"))
				.andDo(print())
				.andExpect(status().isNotFound());
	}
	@Test
	void test5() throws Exception {
		this.mockMvc.perform(
				get("/api/v1/clients/get/Ontario"))
				.andDo(print())
				.andExpect(status().isOk());
	}


}
