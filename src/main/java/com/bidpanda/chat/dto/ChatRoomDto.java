package com.bidpanda.chat.dto;

import lombok.Data;

import java.util.UUID;

@Data
public class ChatRoomDto {
    private String roomId;
    private String name;

    public static ChatRoomDto create(String name) {
        ChatRoomDto room = new ChatRoomDto();

        room.roomId = UUID.randomUUID().toString();
        room.name = name;
        return room;
    }
}
