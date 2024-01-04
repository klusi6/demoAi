package org.example.demoai.service;

import org.example.demoai.model.Prompt;
import org.example.demoai.repository.PromptRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PromptService {

    PromptRepository promptRepository;

    public PromptService(PromptRepository promptRepository) {
        this.promptRepository = promptRepository;
    }

    public List<Prompt> getAll() {
        return promptRepository.findAll();
    }
}