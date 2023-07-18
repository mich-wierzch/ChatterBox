package com.michwierzch.ChatterBox.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ChatModel {
    private String content;
    private String sender;
    private MessageType type;

    public enum MessageType {
        CHAT, LEAVE, JOIN
    }


}

