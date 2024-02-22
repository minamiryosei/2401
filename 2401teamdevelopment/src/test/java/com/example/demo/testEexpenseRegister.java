package com.example.demo;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.example.demo.controller.expenseRegisterController;
import com.example.demo.dto.expenseRegisterRequest;
import com.example.demo.service.expenseRegisterService;

/**					
* テストクラス kanggo ExpenseRegisterController.					
*/					
@WebMvcTest(testEexpenseRegister.class)					
public class testEexpenseRegister {					
					
@MockBean					
expenseRegisterService expenseRegisterService;					
					
@Autowired					
private expenseRegisterController expenseRegisterController;					
					
private MockMvc mockMvc;					
					
/**					
* セットアップメソッド kanggo inisialisasi objek sing diperlokaké lan konfigurasi mock.					
*/					
@BeforeEach					
public void setup() {					
mockMvc = MockMvcBuilders.standaloneSetup(expenseRegisterController).build();					
}					
					
					
/**					
* テストメソッド kanggo displayAdd() saka expenseRegisterController.					
*/					
@Test					
public void testDisplayAdd() throws Exception {					
mockMvc.perform(get("expenseRegister"))					
.andExpect(status().isOk())					
.andExpect(model().attributeExists("expenseRegisterRequest"))					
.andExpect(view().name("expenseRegister"));					
}					
					
/**					
* テストメソッド  userCreate() 正常系テスト					
*/					
//@Test					
//public void testCreateUserSucess() throws Exception {					
//	expenseRegisterRequest testRequest = new expenseRegisterRequest();				
//	testRequest.setUser_id(1);
//	testRequest.setApplication_date(LocalDate.of(2024, 02, 22));
//	testRequest.setCategory("経費項目テスト");
//	testRequest.setAmount(1);	
//	testRequest.setRemarks("備考テスト");		
//					
//	mockMvc.perform((post("/expenseRegister/create")).flashAttr("expenseRegisterRequest", testRequest))				
//		.andExpect(model().hasNoErrors())			
//		.andExpect(model().attribute("expenseRegisterRequest", testRequest))			
//		.andExpect(view().name("redirect:/expenseRegister"));			
//					
//	verify(expenseRegisterService, times(1)).create(testRequest);				
//}			
					
///**					
//*  テストメソッド expenseRegisterCreate() 異常系テスト					
//*/					
//@Test					
//public void testCreateUserError() throws Exception {					
//	UserRequest testRequest = new UserRequest();				
//	testRequest.setUser_id(“");				
//	testRequest.setApplication_date(“");				
//	testRequest.setCategory(“20”);
//	testRequest.setAmount(“");	
//	testRequest.setRemarks(“100”);				
//				
//					
//	mockMvc.perform((post("/expenseRegister/create")).flashAttr("expenseRegisterRequest", testRequest))				
//		.andExpect(model().hasErrors())			
//		.andExpect(model().attribute("expenseRegisterRequest",testRequest))			
//		.andExpect(view().name("expenseRegister"));			
//	}				
}					