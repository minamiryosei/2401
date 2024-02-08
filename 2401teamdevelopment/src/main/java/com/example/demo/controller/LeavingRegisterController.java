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
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.request.LeavingRegisterrequest;
import com.example.demo.service.LeavingRegisterService;

@Controller
public class LeavingRegisterController {

	@Autowired
	public LeavingRegisterService leavingRegisterService;

	@GetMapping("leavingRegister")
	public String displayAdd(Model model) {
		model.addAttribute("leavingRegisterrequest",new LeavingRegisterrequest(null, null, null));
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
