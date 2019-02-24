package com.example.demo.test;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Collections;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.example.demo.McDoApplication;
import com.example.demo.controller.McDoController;
import com.example.demo.dao.McDoDao;
import com.example.demo.entities.McDo;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = McDoApplication.class)
@SpringBootTest
public class McDosTest {

	private MockMvc mockMvc;
	@InjectMocks
	private McDoController mcDoController;
	
	@Mock
	McDoDao mcDoDao;
	

	
	@Before
	public void setUp() throws Exception{
		MockitoAnnotations.initMocks(this);
		MockitoAnnotations.initMocks(this);
		McDo mcDo = new McDo();
		when(mcDoDao.findAll()).thenReturn(Collections.singletonList(mcDo));
		Page<McDo> test = mcDoController.search("McDonalds-Albertville", 0, 5);
		when(mcDoController.search("McDonalds-Albertville", 0, 5)).thenReturn(test);
		System.out.println("++++++++++TEST"+test);
		mockMvc = MockMvcBuilders.standaloneSetup(mcDoController)
				.build();
	}
	
	@Test
	public void testMcDo() throws Exception {
		 String mc = "McDonalds-Albertville";
		 
		 MvcResult result2 =	 mockMvc.perform(MockMvcRequestBuilders.get("/searchMcDo")
					.accept(MediaType.APPLICATION_JSON)
				
					
					).andReturn();
		 MvcResult result =	 mockMvc.perform(MockMvcRequestBuilders.get("/McDos")
					
					.accept(MediaType.APPLICATION_JSON)
				
					
					).andReturn();
	String content = result
		.getResponse().getContentAsString();
	int content2 = result2
			.getResponse().getContentLength();
	System.out.println("+++Content++++++++++++++++++++++++++++++++"+content);
	System.out.println("+++Content2++++++++++++++++++++++++++++++++"+content2);
	
	
			mockMvc = MockMvcBuilders.standaloneSetup(mcDoController)
					.build();
			 mockMvc.perform(MockMvcRequestBuilders.get("/McDos")
				
				.accept(MediaType.APPLICATION_JSON)
				).andDo(print())
		
	     .andExpect(status().isOk())
	     .andExpect(jsonPath("$[0].id").exists())
	  
					.andDo(print());
			 
	
					
	}

}
