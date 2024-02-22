package LeavingRegisterControllerTest;

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

import com.example.demo.controller.LeavingRegisterController;
import com.example.demo.request.LeavingRegisterrequest;
import com.example.demo.service.LeavingRegisterService;

/**						
	* テストクラス kanggo LeavingRegisterController.						
	*/
@WebMvcTest(LeavingRegisterController.class)
public class LeavingRegisterControllerTest {

	@MockBean
	LeavingRegisterService LeavingRegisterService;

	@Autowired
	private LeavingRegisterController LeavingRegisterController;

	private MockMvc mockMvc;

	/**						
	* セットアップメソッド kanggo inisialisasi objek sing diperlokaké lan konfigurasi mock.						
	*/
	@BeforeEach
	public void setup() {
		mockMvc = MockMvcBuilders.standaloneSetup(LeavingRegisterController).build();
	}

	/**						
	* テストメソッド kanggo displayLeavingRegister) saka LeavingRegisterontroller.						
	*/
	@Test
	public void testDisplayLeavingRegister() throws Exception {
		mockMvc.perform(get("LeavingRegister"))
				.andExpect(status().isOk())
				.andExpect(model().attributeExists("LeavingRegisterRequest"))
				.andExpect(view().name("LeavingRegister"));
	}

	/**						
	* テストメソッド  LeavingRegisterUpdate() 正常系テスト						
	*/
	@Test
	public void testUpdateLeavingRegisterSucess() throws Exception {
		LeavingRegisterrequest testRequest = new LeavingRegisterrequest();
		testRequest.setAttendance_id("1");
		testRequest.setStatus("退勤");
		testRequest.setLeaving_date("2024/02/19");
		testRequest.setLeaving_time("18:00");
		testRequest.setBreak_time("01:00");

		mockMvc.perform((post("/user/create")).flashAttr("LeavingRegisterRequest", testRequest))
				.andExpect(model().hasNoErrors())
				.andExpect(model().attribute("LeavingRegisterRequest", testRequest))
				.andExpect(view().name("LeavingRegister"));

		verify(LeavingRegisterService, times(1)).create(testRequest);
		//verify([モックオブジェクト], times([回数])).[テストするメソッド]([引数]);					
	}

	/**						
	*  テストメソッド LeavingRegisterUpdate() 異常系テスト						
	*/
	@Test
	public void testCreateLeavingRegisterError() throws Exception {
		LeavingRegisterrequest testRequest = new LeavingRegisterrequest();
		testRequest.setAttendance_id("");
		testRequest.setStatus("");
		testRequest.setLeaving_date("");
		testRequest.setLeaving_time("");
		testRequest.setBreak_time("");

		mockMvc.perform((post("/user/create")).flashAttr("LeavingRegisterRequest", testRequest))

				.andExpect(model().hasErrors())
				.andExpect(model().attribute("LeavingRegisterRequest", testRequest))
				.andExpect(view().name("LeavingRegister"));
	}
}
