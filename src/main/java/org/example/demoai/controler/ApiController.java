package org.example.demoai.controler;

import org.example.demoai.service.PromptService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ApiController {

    private final PromptService promptService;

    public ApiController(PromptService promptService) {
        this.promptService = promptService;
    }

    @GetMapping("/api")
    public ResponseEntity<?> getAll() {
        return ResponseEntity.ok(promptService.getAll());
    }


}
