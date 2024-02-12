package com.springai.demo;

import com.theokanning.openai.service.OpenAiService;
import org.springframework.ai.client.AiClient;
import org.springframework.ai.client.AiResponse;
import org.springframework.ai.parser.BeanOutputParser;
import org.springframework.ai.prompt.Prompt;
import org.springframework.ai.prompt.PromptTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Map;

@Service
public class OpenAiGptClient {

    @Autowired
    AiClient aiClient;

    @Autowired
    OpenAiService openAiApiService;

    public Mountains getTallMountains(String country) {

        var outputParser = new BeanOutputParser<>(Mountains.class);
        String promptString = "Give me the list of Tall five mountains in {country} in the format {format}";

        PromptTemplate promptTemplate = new PromptTemplate(promptString, Map.of("country", country, "format", outputParser.getFormat()));
        Prompt prompt = promptTemplate.create();

        AiResponse aiResponse = aiClient.generate(prompt);
        return outputParser.parse(aiResponse.getGeneration().getText());

    }
}
