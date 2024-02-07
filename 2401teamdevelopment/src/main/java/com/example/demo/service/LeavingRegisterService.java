package com.example.demo.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional(dontRollbackOn =Exception.class )
public class LeavingRegisterService {
	
@Autowired
	private Leav

}
