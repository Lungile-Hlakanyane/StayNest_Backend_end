package com.staynest.controller;
import com.staynest.DTO.MessageDTO;
import com.staynest.entity.Message;
import com.staynest.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/messages")
public class MessageController {

    @Autowired
    private MessageService messageService;

    @PostMapping("/send")
    public ResponseEntity<Message> sendMessage(@RequestBody MessageDTO dto) {
        Message message = new Message();
        message.setSenderId(dto.getSenderId());
        message.setReceiverId(dto.getReceiverId());
        message.setContent(dto.getContent());
        Message saved = messageService.saveMessage(message);
        return ResponseEntity.ok(saved);
    }
    @GetMapping("/history")
    public ResponseEntity<List<Message>> getChatHistory(
            @RequestParam Long user1Id,
            @RequestParam Long user2Id) {
        List<Message> history = messageService.getChatHistory(user1Id, user2Id);
        return ResponseEntity.ok(history);
    }

    @GetMapping("/inbox/{receiverId}")
    public ResponseEntity<List<Message>> getInboxMessages(@PathVariable Long receiverId) {
        List<Message> messages = messageService.getMessagesByReceiver(receiverId);
        return ResponseEntity.ok(messages);
    }

}
