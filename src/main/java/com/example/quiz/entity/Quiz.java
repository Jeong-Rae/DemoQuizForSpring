package com.example.quiz.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

/* quiz table : Entity */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Quiz {
    /*ID*/
    @Id
    private Integer id;

    /*Question*/
    private String question;

    /*Answer*/
    private Boolean answer;

    /*Author*/
    private String author;
}
