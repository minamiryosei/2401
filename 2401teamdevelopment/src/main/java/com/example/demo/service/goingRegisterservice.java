package com.example.demo.service;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.goingRegisterEntity;
import com.example.demo.repository.goingRegisterrepository;
import com.example.demo.request.goingRegisterrequest;


@Service
@Transactional(dontRollbackOn=Exception.class)
public class goingRegisterservice {

@Autowired
	private goingRegisterrepository goingRegisterRepository;

	public List<goingRegisterEntity> earchAll(){
		return  goingRegisterRepository.findAll();
	}

	public void create(goingRegisterrequest goingRegisterRequest) {
		goingRegisterEntity goingRegister = new goingRegisterEntity();
		goingRegister.setUser_id(goingRegisterRequest.getUser_id());
		goingRegister.setStatus(goingRegisterRequest.getStatus());
		goingRegister.setGoing_date(goingRegisterRequest.getGoing_date());
		goingRegister.setGoing_time(goingRegisterRequest.getGoing_time());
		goingRegisterRepository.save(goingRegister);
	}
}
