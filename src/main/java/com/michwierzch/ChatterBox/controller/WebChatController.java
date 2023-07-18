package com.michwierzch.ChatterBox.controller;

import com.michwierzch.ChatterBox.model.ChatModel;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WebChatController {

    @GetMapping("/")
    public String getChatPage(){
        return "chat";
    }


    @MessageMapping("/chat.register")
    @SendTo("/topic/public")
    public ChatModel register(@Payload ChatModel chatModel, SimpMessageHeaderAccessor headerAccessor) {
        headerAccessor.getSessionAttributes().put("username", chatModel.getSender());
        return chatModel;
    }

    @MessageMapping("/chat.send")
    @SendTo("/topic/public")
    public ChatModel sendMessage(@Payload ChatModel chatModel) {
        return chatModel;
    }
}
