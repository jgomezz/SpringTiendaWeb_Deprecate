package pe.edu.tecsup.tienda.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import pe.edu.tecsup.tienda.entities.Usuario;

@Controller
@RequestMapping("/profile")
public class ProfileController {

	private static final Logger logger = LoggerFactory.getLogger(ProfileController.class);
	
	@GetMapping
	public String profile(@AuthenticationPrincipal Usuario usuario, Model model) {
		logger.info("profile("+usuario+")");
		
		return "profile/index";
	}
	
}
