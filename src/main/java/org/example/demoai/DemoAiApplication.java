package org.example.demoai;

import org.example.demoai.model.Prompt;
import org.example.demoai.repository.PromptRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoAiApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(DemoAiApplication.class, args);
    }
    @Autowired
    PromptRepository promptRepository;

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Hello World!");
        promptRepository.save(new Prompt(1, "Whom do you serve","SARUMAN"));
    }
}
