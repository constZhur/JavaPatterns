package com.example.practice12;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class App {
    private final FileWorker fileWorker;

    @Autowired
    public App (FileWorker fileWorker) {
        this.fileWorker = fileWorker;
    }

    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }

    @Bean
    public CommandLineRunner runner(){
        return (args -> fileWorker.hash());
    }
}
