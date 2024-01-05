package org.example.demoai.service;

import org.example.demoai.dto.ChatGPTRequest;
import org.example.demoai.dto.ChatGPTResponse;
import org.example.demoai.dto.PnRdto;
import org.example.demoai.model.PromptAndResponse;
import org.example.demoai.repository.PromptAndResponseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PromptAndResponseService {
    @Value("${openai.model}")
    private String model;

    @Value(("${openai.api.url}"))
    private String apiUrl;

    @Autowired
    private RestTemplate template;

   private final PromptAndResponseRepository promptAndResponseRepository;

    public PromptAndResponseService(PromptAndResponseRepository promptAndResponseRepository) {
        this.promptAndResponseRepository = promptAndResponseRepository;
    }

    public List<PromptAndResponse> getAll() {
        return promptAndResponseRepository.findAll();
    }

    public void save(PromptAndResponse promptAndResponse) {
        promptAndResponseRepository.save(promptAndResponse);
    }

    public List<PnRdto> getAllDto() {
        return promptAndResponseRepository.findAll().stream().map(PnRdto::new).collect(Collectors.toList());
    }

    public String chat(String prompt) {
        ChatGPTRequest request = new ChatGPTRequest(model, prompt);
        promptAndResponseRepository.save(new PromptAndResponse(prompt, template.postForObject(apiUrl, request, ChatGPTResponse.class).getChoices().get(0).getMessage().getContent()));
        return template.postForObject(apiUrl, request, ChatGPTResponse.class).getChoices().get(0).getMessage().getContent();
    }

}
