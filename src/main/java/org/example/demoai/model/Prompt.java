package org.example.demoai.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Prompt {
    @Id
    @GeneratedValue
    private long id;
    private String prompt;
    @Lob
    private String response;

    public Prompt(String prompt, String response) {
        this.prompt = prompt;
        this.response = response;
    }
}
