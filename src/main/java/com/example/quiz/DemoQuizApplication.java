package com.example.quiz;

import com.example.quiz.entity.Quiz;
import com.example.quiz.repository.QuizRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Optional;

@SpringBootApplication
public class DemoQuizApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoQuizApplication.class, args).getBean(DemoQuizApplication.class).execute();
    }

    @Autowired
    QuizRepository repository;

    private void execute(){
        //setup();
        //showList();
        //showOne();
        updateQuiz();
        //deleteQuiz();
    }

    private void setup(){
        Quiz quiz = new Quiz(null,"Q", true,"JR");
        quiz = repository.save(quiz);
        System.out.println("Setup quiz : "+quiz);
    }

    /* Acquire All Data */
    private void showList(){
        System.out.println("==== Start Acquire All Date ====");
        Iterable<Quiz> quizzes = repository.findAll();
        for (Quiz quiz : quizzes){
            System.out.println(quiz);
        }
        System.out.println("==== Complete Acquire All Date ====");
    }

    /* Acquire One Data*/
    private void showOne(){
        System.out.println("=== Start Acquire 1 Data");
        Optional<Quiz> quizOptional = repository.findById(1);

        /* Check return value*/
        if (quizOptional.isPresent()){
            System.out.println(quizOptional.get());
        }else {
            System.out.println("This data doesn't exist");
        }
        System.out.println("=== Complete Acquire 1 Data");
    }

    /* Update Data */
    private void updateQuiz(){
        System.out.println("==== Data Update ====");
        Quiz quiz = new Quiz(1,"Question",false,"JR");
        quiz = repository.save(quiz);
        System.out.println("Changed data : "+quiz);
        System.out.println("==== Data Update ====");

    }

    /* Delete Date */
    private void deleteQuiz(){
        System.out.println("==== Start Data Deleting ====");
        repository.deleteById(2);
        System.out.println("==== Complete Data Deleting ====");
    }

}
