package com.example.demo.controller;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import com.example.demo.entity.userEditDelete;
import com.example.demo.service.userEditDeleteService;

@WebMvcTest(userEditDeleteController.class)
class UserEditDeleteControllerTest{

	@MockBean
	userEditDeleteService userEditDeleteService;

	@Autowired
	private MockMvc mockMvc;

	/**
	 * 【正常系】GETリクエストが正常に処理され、userEditDelete画面が表示されることを検証するテストケース
	 * @throws Exception
	 */
	@Test
	public void successfullyDisplayAdd() throws Exception {
		userEditDelete user = new userEditDelete();
		user.setId((long) 1);
		user.setName("name");
		user.setFurigana("フリガナ");
		user.setMail("sample@example.co.jp");
		user.setPassword("Pass");
		when(userEditDeleteService.findById((long) 1)).thenReturn(user);
		mockMvc.perform(get("/userEditDelete/1/edit"))
		.andExpect(status().isOk())
		.andExpect(model().attributeExists("userUpdateRequest"))
		.andExpect(view().name("userEditDelete"));
	}

}
