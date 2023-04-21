package com.example.task;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TaskApplication {

    public static void main(String[] args) {

        ProblemSolving problems = new ProblemSolving();
        System.out.println(problems.reverseInParentheses("dd(df)a(ghhh)"));

        try {
            SpringApplication.run(TaskApplication.class, args);

        }
        catch (Exception ex){
            ex.printStackTrace();
        }
    }

}
