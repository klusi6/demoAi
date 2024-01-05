package org.example.demoai;

import org.example.demoai.model.PromptAndResponse;
import org.example.demoai.repository.PromptAndResponseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoAiApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(DemoAiApplication.class, args);
    }
    @Override
    public void run(String... args) throws Exception {
        System.out.println("(-_-) Sleeping (-_-)");
        for (int i = 0; i <= 100; i++) {
            System.out.print("\r");
            System.out.print("Loading: " + i + "%");
            Thread.sleep(20);
        }
        System.err.println(("\n"+"(O_O) Awake (O_O)" + "\nWelcome"));
    }
}
