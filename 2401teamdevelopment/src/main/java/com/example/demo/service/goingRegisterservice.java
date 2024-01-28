package com.example.demo.service;

<<<<<<< Updated upstream
public class goingRegisterservice {

=======
import antlr.collections.List;

＠Service
＠Transactional（dontRollbackOn=Exception.class)
public class goingRegisterservice {

	@Autowired
	private goingRegisterRepository goingRegisterRepository;

	public List<goingRegisterEntity>searchAll(){
		return  goingRegisterRepository.findAll();
	}

	public void create(goingRegisterRequest goingRegisterRequest) {
		goingRegisterEntity goingRegister=new goingRegisterEntity();
		goingRegister.set user_id(goingRegisterRequest.getuser_id());
		goingRegister.set status(goingRegisterRequest.getstatus());
		goingRegister.set goingday(goingRegisterRequest.getgoingday());
		goingRegister.set goingtime(goingRegisterRequest.getgoingtime());
		goingRegisterRepository.save(userRegistration);
	}
>>>>>>> Stashed changes
}
