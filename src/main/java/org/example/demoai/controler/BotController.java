package org.example.demoai.controler;

import org.example.demoai.dto.ChatGPTRequest;
import org.example.demoai.dto.ChatGPTResponse;
import org.example.demoai.model.Prompt;
import org.example.demoai.service.PromptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/bot")
public class BotController {

    @Value("${openai.model}")
    private String model;

    @Value(("${openai.api.url}"))
    private String apiUrl;

    @Autowired
    private PromptService promptService;


    @Autowired
    private RestTemplate template;

    @PostMapping("/chat")
    public String chat(@RequestBody String prompt) {
        ChatGPTRequest request = new ChatGPTRequest(model, prompt);
        promptService.save(new Prompt(prompt, template.postForObject(apiUrl, request, ChatGPTResponse.class).getChoices().get(0).getMessage().getContent()));
        return template.postForObject(apiUrl, request, ChatGPTResponse.class).getChoices().get(0).getMessage().getContent();

    }
}
