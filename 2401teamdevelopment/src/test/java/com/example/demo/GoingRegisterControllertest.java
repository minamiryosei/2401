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

import com.example.demo.controller.GoingRegisterController;
import com.example.demo.request.GoingRegisterrequest;
import com.example.demo.service.GoingRegisterservice;

/**						
 * テストクラス kanggo UserController.						
 */
@WebMvcTest(GoingRegisterController.class)
public class GoingRegisterControllertest {

	@MockBean
	GoingRegisterservice GoingRegisterservice;

	@Autowired
	private GoingRegisterController GoingRegisterController;

	private MockMvc mockMvc;

	/**						
	 * セットアップメソッド kanggo inisialisasi objek sing diperlokaké lan konfigurasi mock.						
	 */
	@BeforeEach
	public void setup() {
		mockMvc = MockMvcBuilders.standaloneSetup(GoingRegisterController).build();
	}

	/**						
	 * テストメソッド kanggo displayAdd() saka GoingRegisterController.						
	 */
	@Test
	public void testDisplayAdd() throws Exception {
		mockMvc.perform(get("GoingRegister"))
				.andExpect(status().isOk())
				.andExpect(model().attributeExists("GoingRegisterRequest"))
				.andExpect(view().name("GoingRegister"));
	}

	/**								
	 * テストメソッド  GoingRegisterUpdate() 正常系テスト								
	 */
	@Test
	public void testUpdateGoingRegisterSucess() throws Exception {
		GoingRegisterrequest testRequest = new GoingRegisterrequest();
		testRequest.setUser_id("1");
		testRequest.setStatus("出勤");
		testRequest.setGoing_date("2024/02/19");
		testRequest.setGoing_time("09:00");
		testRequest.setRemarks("4");

		mockMvc.perform((post("/user/create")).flashAttr("GoingRegisterRequest", testRequest))
				.andExpect(model().hasNoErrors())
				.andExpect(model().attribute("GoingRegisterrRequest", testRequest))
				.andExpect(view().name("redirect:/GoingRegister/%d/create"));

		verify(GoingRegisterservice, times(1)).create(testRequest);
		//verify([モックオブジェクト], times([回数])).[テストするメソッド]([引数]);							
	}

	/**								
	 *  テストメソッド GoingRegisterUpdate() 異常系テスト								
	 */
	@Test
	public void testCreateGoingRegisterError() throws Exception {
		GoingRegisterrequest testRequest = new GoingRegisterrequest();
		testRequest.setUser_id("");
		testRequest.setStatus("");
		testRequest.setGoing_date("");
		testRequest.setGoing_time("");
		testRequest.setRemarks("");

		mockMvc.perform((post("/user/create")).flashAttr("GoingRegisterRequest", testRequest))
				.andExpect(model().hasErrors())
				.andExpect(model().attribute("GoingRegisterRequest", testRequest))
				.andExpect(view().name("GoingRegister"));
	}
}