package com.staynest.repository;
import com.staynest.entity.Message;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface MessageRepository extends JpaRepository<Message, Long> {
    List<Message> findBySenderIdAndReceiverIdOrderByTimestamp(Long senderId, Long receiverId);
    List<Message> findByReceiverIdAndSenderIdOrderByTimestamp(Long receiverId, Long senderId);
    List<Message> findByReceiverIdOrderByTimestampDesc(Long receiverId);
}
