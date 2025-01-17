package com.ai.SpringAi;

import lombok.RequiredArgsConstructor;
import org.springframework.ai.chat.model.ChatModel;
import org.springframework.ai.chat.model.ChatResponse;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.ai.openai.OpenAiChatOptions;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class ChatService {
    private final ChatModel chatModel;

    public String getResponseOptions(String prompt){
        ChatResponse response = chatModel.call(
                new Prompt(
                        prompt,
                        OpenAiChatOptions.builder()
                                .withModel("gpt-4o-mini")
                                .withTemperature(0.4)
                                .build()
                ));
        return response.getResult().getOutput().getContent();
    }
}
