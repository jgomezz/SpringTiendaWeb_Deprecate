package pe.edu.tecsup.tienda.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping
public class LoginController {

	@GetMapping("/login")
	public String login() {
		
		return "login";
	}
	
}
