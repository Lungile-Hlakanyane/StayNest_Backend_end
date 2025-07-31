package com.staynest.service;
import com.staynest.entity.Message;
import java.util.List;
public interface MessageService {

    Message saveMessage(Message message);
    List<Message> getChatHistory(Long user1Id, Long user2Id);
    List<Message> getMessagesByReceiver(Long receiverId);
}
