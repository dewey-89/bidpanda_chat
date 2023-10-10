package com.bidpanda.chat.repository;

import com.bidpanda.chat.model.ChatRecord;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ChatRecordRepository extends MongoRepository<ChatRecord, String> {
    @Query(value = "{roomId:?0}")
    Optional<ChatRecord> findChatRecordByRoomIdEquals(String roomId);
}
