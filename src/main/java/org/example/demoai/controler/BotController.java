package org.example.demoai.controler;

import lombok.AllArgsConstructor;
import org.example.demoai.dto.ChatGPTRequest;
import org.example.demoai.dto.ChatGPTResponse;
import org.example.demoai.dto.Message;
import org.example.demoai.dto.PnRdto;
import org.example.demoai.model.PromptAndResponse;
import org.example.demoai.service.PromptAndResponseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
@AllArgsConstructor
public class BotController {


    private final PromptAndResponseService promptAndResponseService;


    @PostMapping("/chat")
    public String chat(@RequestBody String prompt) {
       return promptAndResponseService.chat(prompt);
    }

    @GetMapping("/chat")
    public String getChat(@RequestParam String prompt) {
        return promptAndResponseService.chat(prompt);
    }

    @GetMapping("")
    public ResponseEntity<?> welcome() {
        return ResponseEntity.
                ok(new Message
                        ("bot",
                                "You can enter /history to see the conversation." +
                                        "For new prompt -> POST on /api/chat with the prompt as the body or" +
                                        "GET with param on /api/chat?prompt=<yourPrompt>"
                        ));
    }

    @GetMapping("/history")
    public ResponseEntity<List<PnRdto>> history() {

        return ResponseEntity.ok(promptAndResponseService.getAllDto());
    }

}
