package com.bidpanda.chat.controller;

import com.bidpanda.chat.dto.ChatRoomDto;
import com.bidpanda.chat.repository.ChatRoomTestRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping(value = "/chat")
@Log4j2
public class RoomController {
    private final ChatRoomTestRepository chatRoomRepository;

    //채팅방 목록 조회
    @GetMapping(value = "/rooms")
    public List<ChatRoomDto> rooms(){
        log.info("# All Chat Rooms");
        return chatRoomRepository.findAllRooms();
    }

    //채팅방 개설
    @PostMapping(value = "/room")
    public String create(@RequestParam String name, RedirectAttributes rttr){
        log.info("# Create Chat Room , name: " + name);
        rttr.addFlashAttribute("roomName", chatRoomRepository.createChatRoomDTO(name));
        return "redirect:/chat/rooms";
    }

    //채팅방 조회
    @GetMapping("/room")
    public void getRoom(String roomId){
        log.info("# get Chat Room, roomID : " + roomId);
//        model.addAttribute("room", repository.findRoomById(roomId));
        // view 리턴 필요
    }
}
