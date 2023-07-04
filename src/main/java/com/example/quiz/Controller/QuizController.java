package com.example.quiz.Controller;

import com.example.quiz.entity.Quiz;
import com.example.quiz.form.QuizForm;
import com.example.quiz.service.QuizService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/quiz")
public class QuizController {
    @Autowired
    QuizService service;

    @ModelAttribute
    public QuizForm setUpForm(){
        QuizForm form = new QuizForm();
        form.setAnswer(true);
        return form;
    }

    @GetMapping
    public String showList(QuizForm quizForm, Model model) {
        quizForm.setNewQuiz(true);

        Iterable<Quiz> List = service.selectAll();

        model.addAttribute("list", List);
        model.addAttribute("title", "form");

        return "crud";
    }
}