package com.example.demo.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import com.example.demo.service.GoingRegisterservice;

@WebMvcTest(GoingRegisterController.class)
class TestGoingRegisterController {

	@MockBean
	GoingRegisterservice goingRegisterservice;

	@Autowired
	private MockMvc mockMvc;

	/**
	 * 【正常系】GETリクエストが正常に処理され、GoingRegister画面が表示されることを検証するテストケース
	 * @throws Exception
	 */
	@Test
	public void successfullyDisplayAdd() throws Exception {
		mockMvc.perform(get("/goingRegister"))
		.andExpect(status().isOk())
		.andExpect(model().attributeExists("goingRegisterrequest"))
		.andExpect(view().name("GoingRegister"));
	}


}
