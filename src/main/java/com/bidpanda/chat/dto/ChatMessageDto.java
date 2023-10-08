package com.bidpanda.chat.dto;

import lombok.Data;

@Data // Getter, Setter 같이 포함
public class ChatMessageDto {
    private String roomId; // 방 번호
    private String writer;
    private String message;
}
