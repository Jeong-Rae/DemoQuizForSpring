package com.example.quiz;

import com.example.quiz.entity.Quiz;
import com.example.quiz.repository.QuizRepository;

import com.example.quiz.service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.*;

@SpringBootApplication
public class    DemoQuizApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoQuizApplication.class, args);
    }

    @Autowired
    QuizService service;

    private void execute() {

        //setup();
        //showList();
        //showOne();
        //updateQuiz();
        //deleteQuiz();
        //doQuiz();
    }

    private void setup() {
        System.out.println("==== Quiz registration: 5 questions ====");
        Quiz quiz1 = new Quiz(null, "Q1", true, "jr");
        Quiz quiz2 = new Quiz(null, "Q2", true, "jr");
        Quiz quiz3 = new Quiz(null, "Q3", true, "jr");
        Quiz quiz4 = new Quiz(null, "Q4", true, "jr");
        Quiz quiz5 = new Quiz(null, "Q5", true, "jr");
        List<Quiz> quizList = new ArrayList<>();
        Collections.addAll(quizList, quiz1, quiz2, quiz3, quiz4, quiz5);
        for (Quiz quiz : quizList) {
            service.insertQuiz(quiz);
        }
        System.out.println("==== Registration completed ====");
    }

    /* Acquiring All Data */
    private void showList() {
        System.out.println("==== Start Acquiring All Data ====");
        Iterable<Quiz> quizzes = service.selectAll();
        for (Quiz quiz : quizzes) {
            System.out.println(quiz);
        }
        System.out.println("==== Data Acquisition Completed ====");
    }

    /* Acquiring One Data*/
    private void showOne() {
        System.out.println("=== Start Acquiring One Data");
        Optional<Quiz> quizOptional = service.selectOneById(1);
        if (quizOptional.isPresent()) {
            System.out.println(quizOptional.get());
        } else {
            System.out.println("non-existent data");
        }
        System.out.println("=== Data One Acquisition Completed");
    }

    /* Update Data */
    private void updateQuiz() {
        System.out.println("==== Start Updating Data ====");
        Quiz quiz = new Quiz(1, "Q1.1", true, "JR2");
        service.updateQuiz(quiz);
        System.out.println("Change Data : " + quiz);
        System.out.println("==== Data Update Completed ====");
    }

    /* Delete Date */
    private void deleteQuiz() {
        System.out.println("==== Start Data Deleting ====");
        service.deleteQuizById(2);
        System.out.println("==== Complete Data Deleting ====");
    }

    private void doQuiz() {
        System.out.println("========");
        Optional<Quiz> quizOptional = service.selectOneRandomQuiz();
        if (quizOptional.isPresent()) {
            System.out.println(quizOptional);
        } else {
            System.out.println("non-existent data");
        }
        System.out.println("========");

        Boolean myAnswer = false;
        Integer id = quizOptional.get().getId();
        if (service.checkQuiz(id, myAnswer)) {
            System.out.println("Collect Answer");
        } else {
            System.out.println("Wrong Answer");
        }
    }

}
