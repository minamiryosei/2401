package com.example.demo.controller;

import org.springframework.stereotype.Controller;

@Controller
public class goingRegisterController {

	@Autowired
	private  goingsterServicegoingRegi goingRegisterService;


	＠GetMapping（"goingRegister")
public string displayAdd (Model model) {
	model.addAttribute("goingRegisterRequest",new goingRegisterRequest());
	return"goingRegister";
}

@PostMapping("/goingRegister/create")
public String create(@validated @ModelAttribute goingRegisterRequest goingRegisterRequest
		BindingResult result, Model model) {
	
	if(result .hasErrors()) {
		List<string>errorList=new ArrayList<String>();
		for (ObjectError error:result.getAllErrors()) {
			errorlist.add(error.getDefaultMessage());	
		}
		model.addAttribute("ValidationError",errorList);
		return "goingRegister";
	}
}

}