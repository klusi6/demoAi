package org.example.demoai.dto;

import org.example.demoai.model.PromptAndResponse;

public record PnRdto(String prompt, String response) {
    public PnRdto(PromptAndResponse promptAndResponse){
        this(promptAndResponse.getPrompt(), promptAndResponse.getResponse());
    }
}
