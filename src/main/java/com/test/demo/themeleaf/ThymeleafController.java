package com.test.demo.themeleaf;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class ThymeleafController {
	
	@GetMapping("/welcome")
	@ResponseBody
	public String getDate(Model model) {
		System.out.println("In side handler........... "); 
		model.addAttribute("name","Hello Thymeleaf");
		return "welcome1";
		
	}

}
