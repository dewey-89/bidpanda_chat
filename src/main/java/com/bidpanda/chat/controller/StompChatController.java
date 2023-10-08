package com.bidpanda.chat.controller;

import com.bidpanda.chat.dto.ChatMessageDto;
import lombok.RequiredArgsConstructor;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

@Controller
@RequiredArgsConstructor
public class StompChatController {
    private final SimpMessagingTemplate template; // 특정 브로커로 메시지 전달

    /**
     * Client가 SEND 할 수 있는 경로
     * config.WebSocketConfig class에서 설정한 applicationDestinationPrefixes @MessageMapping 정보가 병함됨
     * "/app/chat/enter 로 client가 메시지를 보내면 채팅방 입장
     */
    @MessageMapping(value = "/chat/enter")
    public void enter(ChatMessageDto message){
        message.setMessage(message.getWriter() + "님이 채팅방에 참여하였습니다.");
        template.convertAndSend("/queue/chat/room/" + message.getRoomId(), message);
    }

    /*
     * /queue/chat/room/{roomId}를 sub하는 모든 주소로 메시지가 보내짐
     */
    @MessageMapping(value = "/chat/message")
    public void message(ChatMessageDto message){
        template.convertAndSend("/queue/chat/room/" + message.getRoomId(), message);
    }

}
