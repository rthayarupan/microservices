package com.apress.demo;

import static org.springframework.test.web.client.match.MockRestRequestMatchers.content;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.asyncDispatch;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.request;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;

@RunWith(SpringRunner.class)
@WebMvcTest(HelloWorldController.class)
public class HelloWorldControllerAsyncTest {
	
	@Autowired
	private MockMvc mockMvc;
	
	@Test
	public void testHelloWorldController() throws Exception {
		MvcResult mvcResult = mockMvc.perform(get("/asyncsample2"))
				.andExpect(request().asyncStarted())
				.andDo(MockMvcResultHandlers.log())
				.andReturn();

		mockMvc.perform(asyncDispatch(mvcResult))
		.andExpect(status().isOk());
	//	.andExpect(content().contentTypeCompatibleWith(org.springframework.http.MediaType.TEXT_PLAIN))
	//	.andExpect(content().string("Hello World, from Spring Boot 2!"));
	}

}
