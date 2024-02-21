package com.example.demo;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.example.demo.controller.userRegisterController;
import com.example.demo.dto.userRegisterRequest;
import com.example.demo.service.userRegisterService;

class testUserRegisterTest {

	
	/**				
	* テストクラス kanggo UserController.				
	*/				
	@WebMvcTest(userRegisterController.class)				
	public class UserControllerTest {				
					
	@MockBean				
	userRegisterService userService;				
					
	@Autowired				
	private userRegisterController userController;				
					
	private MockMvc mockMvc;				
					
	/**				
	* セットアップメソッド kanggo inisialisasi objek sing diperlokaké lan konfigurasi mock.				
	*/				
	@BeforeEach				
	public void setup() {				
	mockMvc = MockMvcBuilders.standaloneSetup(userController).build();				
	}				
					
					
	/**				
	* テストメソッド kanggo displayAdd() saka UserController.				
	*/				
	@Test				
	public void testDisplayAdd() throws Exception {				
	mockMvc.perform(get("/user/add"))				
	.andExpect(status().isOk())				
	.andExpect(model().attributeExists("userRequest"))				
	.andExpect(view().name("user/add"));				
	}				
					
	/**				
	* テストメソッド  userCreate() 正常系テスト				
	*/				
	@Test				
	public void testCreateUserSucess() throws Exception {				
		userRegisterRequest testRequest = new userRegisterRequest();			
		testRequest.setName("名前テスト");			
		testRequest.setFurigana("住所テスト");			
		testRequest.setMail("メールアドレス形式テスト");	
		testRequest.setPassword("8文字以上テスト");
					
		mockMvc.perform((post("/user/create")).flashAttr("userRequest", testRequest))			
			.andExpect(model().hasNoErrors())		
			.andExpect(model().attribute("userRequest", testRequest))		
			.andExpect(view().name("redirect:/user/list"));		
					
		verify(userService, times(1)).create(testRequest);			
	}			
					
	/**				
	*  テストメソッド userCreate() 異常系テスト				
	*/				
	@Test				
	public void testCreateUserError() throws Exception {				
		userRegisterRequest testRequest = new userRegisterRequest();			
		testRequest.setName("");			
		testRequest.setFurigana("");			
		testRequest.setMail("");
		testRequest.setPassword("");
					
		mockMvc.perform((post("/user/create")).flashAttr("userRequest", testRequest))			
			.andExpect(model().hasErrors())		
			.andExpect(model().attribute("userRequest",testRequest))		
			.andExpect(view().name("user/add"));		
		}			
	}				

}

