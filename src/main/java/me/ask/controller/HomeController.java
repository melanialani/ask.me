package me.ask.controller;

import me.ask.service.*;
import me.ask.model.*;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.redirectedUrl;

import java.awt.List;
import java.io.Console;
import java.io.PrintWriter;
import java.util.Collection;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@Scope("session")
public class HomeController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private FriendService friendService;
	
	@Autowired
	private QuestionAnswerService questionAnswerService;
	
	@GetMapping("")
    public String addForm(Model model) {
        model.addAttribute("user", new User());
        return "home/login";
    }

    @PostMapping("/login")
    public String checkLogin(@ModelAttribute User user,  ModelMap modelMap, HttpServletRequest request, HttpServletResponse resp ) {
    	String rtn = "";
    	Collection<User> coll  = userService.checkLogin(user.getUsername());
    	if(!coll.isEmpty()){
    		for(User u : coll){
        		if(u.getPassword().equals(user.getPassword())){
        			modelMap.put("asks", questionAnswerService.find_home(user.getUsername()));
        			//rtn = "redirect:home/timeline/"+user.getUsername();
        			//rtn = "redirect:home/timeline/"+attributeName;
        			
        			String attributeValue = request.getParameter("username");
        			request.getSession().setAttribute("username",attributeValue);
        			rtn = "redirect:home/timeline/"+request.getSession().getAttribute("username").toString();
            		
        			
            	}else{
            		rtn = "home/login";
            	}
        	}
    	}else{
    		modelMap.put("msg", "Incorrect Username");
    		rtn = "home/login";
    	}
    	
        return rtn;
    }
    
    @RequestMapping(value = "home/timeline/{username}", method = RequestMethod.GET)
	public String timeline(@PathVariable("username") String username, ModelMap modelMap) {
    	Collection<Friend> coll = friendService.friendList(username);
    	//Collection<QuestionAnswer> temp = questionAnswerService.find_home(username);
    	for(Friend f : coll){
    		//temp.addAll();
    		modelMap.put("asks", questionAnswerService.find_home(f.getUsername()));
    	}
    	//modelMap.put("asks", temp);
        return "home/timeline";
	}
}
