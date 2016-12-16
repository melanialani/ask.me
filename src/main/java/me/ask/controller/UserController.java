package me.ask.controller;

import me.ask.service.*;
import me.ask.model.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("user")
public class UserController {

	@Autowired
	private UserService userService;
	
	@Autowired
	private QuestionAnswerService questionAnswerService;

	@RequestMapping(method = RequestMethod.GET)
	public String index(ModelMap modelMap) {
		modelMap.put("users", userService.findAll());
		return "user/index";
	}
	
	// --- SEE USER'S DETAIL

	@RequestMapping(value = "detail/{username}", method = RequestMethod.GET)
	public String detailGet(@PathVariable("username") String username, ModelMap modelMap) {
		modelMap.put("user", userService.find(username));
		return "user/detail";
	}

	// --- EDIT USER
	
    @RequestMapping(value = "edit/{username}", method = RequestMethod.GET)
	public String editForm(@PathVariable("username") String username, ModelMap modelMap, Model model) {
    	model.addAttribute("user", new User());
		modelMap.put("user", userService.find(username));
		return "user/edit";
	}
	
	@RequestMapping(value = "edit/{username}", method = RequestMethod.POST)
	public String editFormSubmit(@PathVariable("username") String username, ModelMap modelMap, @ModelAttribute User user) {
		userService.update(user);
        return "result/edit_user";
	}
	
	// --- DELETE USER
	
	@RequestMapping(value = "delete/{username}", method = RequestMethod.GET)
	public String deleteUser(@PathVariable("username") String username) {
		userService.delete(username);
		return "result/delete_user";
	}
	
	// --- ADD NEW USER
	
	@GetMapping("/add")
    public String addForm(Model model) {
        model.addAttribute("user", new User());
        return "user/add";
    }

    @PostMapping("/add")
    public String addSubmit(@ModelAttribute User user) {
    	userService.insert(user);
        return "result/edit_user";
    }
    
    // --- SEE USER'S HOME

 	@RequestMapping(value = "home/{username}", method = RequestMethod.GET)
 	public String homeGet(@PathVariable("username") String username, ModelMap modelMap) {
 		modelMap.put("asks", questionAnswerService.find_home(username));
		return "user/home";
 	}
}
