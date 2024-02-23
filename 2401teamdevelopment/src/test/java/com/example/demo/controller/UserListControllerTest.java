package com.example.demo.controller;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import com.example.demo.entity.UserListEntity;
import com.example.demo.service.UserListService;

@WebMvcTest(UserListController.class)
class UserListControllerTest{

	@MockBean
	UserListService userListService;

	@Autowired
	private MockMvc mockMvc;

	/**
	 * 【正常系】GETリクエストが正常に処理され、userList画面が表示されることを検証するテストケース
	 * @throws Exception
	 */
	@Test
	public void successfullyDisplayAdd() throws Exception {
		List<UserListEntity> userList = new ArrayList<UserListEntity>();
		when(userListService.searchAll()).thenReturn(userList);
		mockMvc.perform(get("/userList"))
		.andExpect(status().isOk())
		.andExpect(model().attributeExists("userList"))
		.andExpect(view().name("userList"));
	}
}
