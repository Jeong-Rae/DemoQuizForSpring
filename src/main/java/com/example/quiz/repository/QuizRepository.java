package com.example.quiz.repository;

import com.example.quiz.entity.Quiz;
import org.springframework.data.repository.CrudRepository;

/* Quiz Table : RepositoryImpl */
public interface QuizRepository extends CrudRepository<Quiz,Integer> {
}
