package com.example.practice12;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.util.DigestUtils;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

@Component
public class FileWorker {

    @Value("input.txt")
    private String inputFileName;
    @Value("output.txt")
    private String outputFileName;
    private File fileInput;
    private File fileOutput;

    @PostConstruct
    private void init(){
        System.out.println("Работа с файлами стартовала...");
        fileInput = new File(inputFileName);
        fileOutput = new File(outputFileName);
        System.out.println("Данные из файлов получены!");
    }

    void hash() {
        System.out.println("Началось хэширование данных...");
        if (fileInput.exists()) {
            try {
                BufferedWriter writer = new BufferedWriter(new FileWriter(fileOutput));
                String content = new String(Files.readAllBytes(Paths.get(inputFileName)));
                writer.write(DigestUtils.md5DigestAsHex(content.getBytes()));
                writer.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            try {
                BufferedWriter writer = new BufferedWriter(new FileWriter(fileOutput));
                writer.write("null");
                writer.close();
            } catch (IOException e) {
                e.printStackTrace();
                }
            }
        System.out.println("Хэширование завершено!");
    }

    @PreDestroy
    private void destroy(){
        System.out.println("Удаление изначального файла...");
        fileInput.delete();
        System.out.println("Жизненный цикл объекта завершен!");
    }
}
