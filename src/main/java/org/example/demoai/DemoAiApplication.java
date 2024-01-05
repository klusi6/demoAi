package org.example.demoai;

import org.example.demoai.service.PromptAndResponseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Scanner;

@SpringBootApplication
public class DemoAiApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(DemoAiApplication.class, args);
    }

    @Autowired
    PromptAndResponseService promptAndResponseService;

    @Override
    public void run(String... args) throws Exception {

        for (int i = 0; i <= 100; i++) {
            System.out.print("\r");
            System.out.print("---Loading: " + i + "%---");
            if (i == 100) {
                System.out.println();
                System.out.println("-------Done!-------");
                break;
            }
            Thread.sleep(20);
        }
        do {
            System.out.println("Enter your prompt:");
            Scanner scanner = new Scanner(System.in);
            String prompt = scanner.nextLine();
            System.out.println(promptAndResponseService.chat(prompt));
            System.out.println("Do you want to continue? (y/any key to exit)");
            String answer = scanner.nextLine();
            if (!answer.equals("y")) {
                scanner.close();
                return;
            }
        } while (true);

        }
}
