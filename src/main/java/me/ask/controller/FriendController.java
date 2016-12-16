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
@RequestMapping("friend")
public class FriendController {

	@Autowired
	private FriendService friendService;

	@RequestMapping(method = RequestMethod.GET)
	public String index(ModelMap modelMap) {
		modelMap.put("friends", friendService.findAll());
		return "friend/index";
	}
	
	// --- DELETE FRIEND
	
	@RequestMapping(value = "delete/{id}", method = RequestMethod.GET)
	public String deleteFriend(@PathVariable("id") int id) {
		friendService.delete(id);
		return "result/delete_friend";
	}
	
	// --- FOLLOW FRIEND
	
	@GetMapping("/add")
    public String addForm(Model model) {
        model.addAttribute("friend", new Friend());
        return "friend/add";
    }

    @PostMapping("/add")
    public String addSubmit(@ModelAttribute Friend friend) {
    	friendService.insert(friend);
        return "result/edit_friend";
    }
}
