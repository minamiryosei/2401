package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.entity.LeavingRegisterentity;
import com.example.demo.request.LeavingRegisterrequest;
import com.example.demo.service.LeavingRegisterService;

@Controller
public class LeavingRegisterController {

	@Autowired
	public LeavingRegisterService leavingRegisterService;

	@GetMapping("leavingRegister/{id}")
	public String displayAdd(@PathVariable Integer id,Model model) {
		LeavingRegisterentity leavingRegister = leavingRegisterService.getid(id);
		LeavingRegisterrequest leavingRegisterrequest = new LeavingRegisterrequest();
		
		leavingRegisterrequest.setAttendance_id(leavingRegister.getAttendance_id());
		leavingRegisterrequest.setUser_id(leavingRegister.getUser_id());
		leavingRegisterrequest.setStatus(leavingRegister.getStatus());
		leavingRegisterrequest.setLeaving_date(leavingRegister.getLeaving_date());
		leavingRegisterrequest.setLeaving_time(leavingRegister.getLeaving_time());
		leavingRegisterrequest.setBreak_time(leavingRegister.getBreak_time());
		leavingRegisterrequest.setRemarks(leavingRegister.getRemarks());

		
		model.addAttribute("leavingRegisterrequest", leavingRegisterrequest);

		return "LeavingRegister";
	}
	

	@PostMapping("/leavingRegister/create")
	public String create(@Validated @ModelAttribute LeavingRegisterrequest leavingRegisterRequest,
			BindingResult result, Model model) {

		if (result.hasErrors()) {
			List<String> errorList = new ArrayList<String>();
			for (ObjectError error : result.getAllErrors()) {
				errorList.add(error.getDefaultMessage());
			}
			model.addAttribute("ValidationError",errorList);
			return "LeavingRegister";

		}

		leavingRegisterService.create(leavingRegisterRequest);
		return "LeavingRegister";
	}
}
