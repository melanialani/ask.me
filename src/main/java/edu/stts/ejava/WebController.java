package edu.stts.ejava;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Controller
public class WebController extends WebMvcConfigurerAdapter {
	
	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		//super.addViewControllers(registry);
		registry.addViewController("/index").setViewName("index");
		registry.addViewController("/dashboard").setViewName("index");
		registry.addViewController("/login").setViewName("login");
		registry.addViewController("/logout").setViewName("index");
	}

	@GetMapping("/")
	public String registerForm(User user) {
		return "login";
	}
	
	@PostMapping("/")
	public String checkInfoUser(@Valid User user, BindingResult br) {
		if (br.hasErrors()){
			return "login";
		}
		
		return "redirect:/index";
	}
}
