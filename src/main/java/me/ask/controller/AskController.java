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
@RequestMapping("ask")
public class AskController {

	@Autowired
	private QuestionService questionService;
	
	@Autowired
	private AnswerService answerService;
	
	@Autowired
	private QuestionAnswerService questionAnswerService;
	
	@RequestMapping(method = RequestMethod.GET)
	public String index(ModelMap modelMap) {
		modelMap.put("asks", questionAnswerService.findAll());
		return "ask/index";
	}
	
	// --- ADD QUESTION
	
	@GetMapping("/question")
    public String questionForm(Model model) {
        model.addAttribute("question", new Question());
        return "ask/add_question";
    }

    @PostMapping("/question")
    public String questionSubmit(@ModelAttribute Question question) {
    	questionService.insert(question);
        return "result/edit_question";
    }
    
    // --- ADD ANSWER
	
 	@GetMapping("/answer")
     public String answerForm(Model model) {
         model.addAttribute("answer", new Answer());
         return "ask/add_answer";
     }

     @PostMapping("/answer")
     public String answerSubmit(@ModelAttribute Answer answer) {
     	answerService.insert(answer);
         return "result/edit_answer";
     }
     
     // --- ADD RANDOM QUESTION
 	
     @GetMapping("/random_question")
     public String randomQuestionForm(Model model) {
    	 RandomQuestion randomQuestion = new RandomQuestion();
    	 int id = 1 + (int)(Math.random() * ((793 - 1) + 1));
    	 Question question = new Question();
    	 question.setQuestioner("system");
    	 question.setQuestion(randomQuestion.getQuestion(id));
         model.addAttribute("question", question);
         return "ask/add_random_question";
     }

     @PostMapping("/random_question")
     public String randomQuestionSubmit(@ModelAttribute Question question) {
    	 questionService.insert(question);
         return "result/edit_question";
     }
}
