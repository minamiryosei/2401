package com.example.demo.service;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.GoingRegisterEntity;
import com.example.demo.repository.GoingRegisterrepository;
import com.example.demo.request.GoingRegisterrequest;


@Service
@Transactional(dontRollbackOn=Exception.class)
public class GoingRegisterservice {

@Autowired
	private GoingRegisterrepository goingRegisterRepository;

	public List<GoingRegisterEntity> earchAll(){
		return  goingRegisterRepository.findAll();
	}

	public void create(GoingRegisterrequest goingRegisterRequest) {
		GoingRegisterEntity goingRegister = new GoingRegisterEntity();
		goingRegister.setUser_id(goingRegisterRequest.getUser_id());
		goingRegister.setStatus(goingRegisterRequest.getStatus());
		goingRegister.setGoing_date(goingRegisterRequest.getGoing_date());
		goingRegister.setGoing_time(goingRegisterRequest.getGoing_time());
		goingRegister.setRemarks(goingRegisterRequest.getRemarks());
		goingRegisterRepository.save(goingRegister);
	}
}
