package com.springai.demo;

import com.theokanning.openai.service.OpenAiService;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenAiConfig {

    @Bean
    public OpenAiService openAiApiService() {
        return new OpenAiService("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");
    }


}