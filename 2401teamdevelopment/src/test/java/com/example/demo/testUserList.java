package com.example.demo;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.example.demo.controller.UserListController;
import com.example.demo.service.UserListService;

/**					
* テストクラス kanggo userListController.					
*/
@WebMvcTest(testUserList.class)
public class testUserList {

	@MockBean
	UserListService userListService;

	@Autowired
	private UserListController userListController;

	private MockMvc mockMvc;

	/**					
	* セットアップメソッド kanggo inisialisasi objek sing diperlokaké lan konfigurasi mock.					
	*/
	@BeforeEach
	public void setup() {
		mockMvc = MockMvcBuilders.standaloneSetup(userListController).build();
	}

	/**					
	* テストメソッド kanggo displayAdd() saka userListController.					
	*/
	@Test
	public void testDisplayAdd() throws Exception {
		mockMvc.perform(get("/user/userList"))
				.andExpect(status().isOk())
				.andExpect(model().attributeExists("userListRequest"))
				.andExpect(view().name("user/userList"));
	}

}