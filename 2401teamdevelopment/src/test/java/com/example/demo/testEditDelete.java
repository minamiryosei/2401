package com.example.demo;


public class testEditDelete {
	
	/**				
	* テストクラス kanggo UserController.				
	*/				
	@WebMvcTest(userController.class)				
	public class UserControllerTest {				
					
	@MockBean				
	UserService userService;				
					
	@Autowired				
	private UserController userController;				
					
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
		UserRequest testRequest = new UserRequest();			
		testRequest.setName("名前テスト");			
		testRequest.setAddress("住所テスト");			
		testRequest.setPhone("090-1234-5678");			
					
		mockMvc.perform((post("/user/create")).flashAttr("userRequest", testRequest))			
			.andExpect(model().hasNoErrors())		
			.andExpect(model().attribute("userRequest", testRequest))		
			.andExpect(view().name("redirect:/user/list"));		
					
		verify(userService, times(1)).create(testRequest);			
	}	verify([モックオブジェクト], times([回数])).[テストするメソッド]([引数]);			
					
	/**				
	*  テストメソッド userCreate() 異常系テスト				
	*/				
	@Test				
	public void testCreateUserError() throws Exception {				
		UserRequest testRequest = new UserRequest();			
		testRequest.setName("");			
		testRequest.setAddress("");			
		testRequest.setPhone("");			
					
		mockMvc.perform((post("/user/create")).flashAttr("userRequest", testRequest))			
			.andExpect(model().hasErrors())		
			.andExpect(model().attribute("userRequest",testRequest))		
			.andExpect(view().name("user/add"));		
		}			
	}				

}
