package com.example.demo.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.LeavingRegisterentity;
import com.example.demo.repository.LeavingRegisterrepository;
import com.example.demo.request.LeavingRegisterrequest;

@Service
@Transactional(dontRollbackOn = Exception.class)
public class LeavingRegisterService {

	@Autowired
	private LeavingRegisterrepository leavingRegisterRepository;

	public List<LeavingRegisterentity> searchAll() {
		return leavingRegisterRepository.findAll();
	}


	public LeavingRegisterentity getid (Integer id){
		return leavingRegisterRepository.getOne(id);
	}

	public void create(LeavingRegisterrequest leavingRegisterRequest) {
		LeavingRegisterentity leavingRegister = new LeavingRegisterentity();
		leavingRegister.setAttendance_id(leavingRegisterRequest.getAttendance_id());
		leavingRegister.setUser_id(leavingRegisterRequest.getUser_id());
		leavingRegister.setStatus(leavingRegisterRequest.getStatus());
		leavingRegister.setLeaving_date(leavingRegisterRequest.getLeaving_date());
		leavingRegister.setLeaving_time(leavingRegisterRequest.getLeaving_time());
		leavingRegister.setBreak_time(leavingRegisterRequest.getBreak_time());
		leavingRegister.setRemarks(leavingRegisterRequest.getRemarks());
		leavingRegisterRepository.save(leavingRegister);
	}
}