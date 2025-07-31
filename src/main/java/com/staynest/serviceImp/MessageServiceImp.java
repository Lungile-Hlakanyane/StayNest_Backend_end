package com.staynest.serviceImp;
import com.staynest.entity.Message;
import com.staynest.repository.MessageRepository;
import com.staynest.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.List;

@Service
public class MessageServiceImp implements MessageService {
    @Autowired
    private MessageRepository messageRepository;
    @Override
    public Message saveMessage(Message message) {
        message.setTimestamp(LocalDateTime.now());
        return messageRepository.save(message);
    }
    @Override
    public List<Message> getChatHistory(Long user1Id, Long user2Id) {
        List<Message> messages = messageRepository.findBySenderIdAndReceiverIdOrderByTimestamp(user1Id, user2Id);
        messages.addAll(messageRepository.findByReceiverIdAndSenderIdOrderByTimestamp(user1Id, user2Id));
        messages.sort(Comparator.comparing(Message::getTimestamp));
        return messages;
    }
    @Override
    public List<Message> getMessagesByReceiver(Long receiverId) {
        return messageRepository.findByReceiverIdOrderByTimestampDesc(receiverId);
    }
}
