package com.springai.demo;

import org.springframework.ai.chat.ChatClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OpenAiClient {

    @Autowired
    ChatClient chatClient;

    public String getTallMountains(String country) {

        String promptString = "Tall five mountains in "+ country;
        return chatClient.call(promptString);
    }
}
