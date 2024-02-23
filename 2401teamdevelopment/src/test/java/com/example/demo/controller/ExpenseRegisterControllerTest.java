package com.example.demo.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import com.example.demo.service.expenseRegisterService;

@WebMvcTest(expenseRegisterController.class)
class ExpenseRegisterControllerTest {

	@MockBean
	expenseRegisterService expenseRegisterService;

	@Autowired
	private MockMvc mockMvc;

	/**
	 * 【正常系】GETリクエストが正常に処理され、expenseRegister画面が表示されることを検証するテストケース
	 * @throws Exception
	 */
	@Test
	public void successfullyDisplayAdd() throws Exception {
		mockMvc.perform(get("/expenseRegister"))
		.andExpect(status().isOk())
		.andExpect(model().attributeExists("expenseRegisterRequest"))
		.andExpect(view().name("expenseRegister"));
	}
}
