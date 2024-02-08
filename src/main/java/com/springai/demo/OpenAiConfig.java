package com.springai.demo;

import org.springframework.ai.chat.ChatClient;
import org.springframework.ai.openai.OpenAiChatClient;
import org.springframework.ai.openai.OpenAiChatOptions;
import org.springframework.ai.openai.api.OpenAiApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenAiConfig {

    @Bean
    public OpenAiApi openAiApi() {
        return new OpenAiApi("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");
    }

    @Bean
    public ChatClient chatClient(OpenAiApi openAiApi) {
        return new OpenAiChatClient(openAiApi)
                .withDefaultOptions(OpenAiChatOptions.builder()
                        .withModel("gpt-4-0125-preview")
                        .withTemperature(0.4F)
                        .withMaxTokens(500)
                        .build());
    }
}
