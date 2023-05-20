package com.example.chat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

@Service
public class ChatService {


    @Autowired
    MessageRepository messageRepository;

    void createMessage(MessageDto msgDto) {
        Message msg = new Message();
        msg.setUserId(msgDto.getUserId());
        msg.setBody(msgDto.getBody());
        msg.setCreatedAt(Instant.now());
        messageRepository.save(msg);
    }

    List<MessageDto> getByUserId(Integer userId) {
        List<Message> msgList = messageRepository.findByUserId(userId);
        Instant now = Instant.now();
        List<MessageDto> msgDtoList = new ArrayList<>();
        msgList.forEach(msg -> {

                    MessageDto msgDto = new MessageDto();
                    msgDto.setUserId(msg.getUserId());
                    msgDto.setBody(msg.getBody());
                    msgDto.setCreatedAt(msg.getCreatedAt());
                    msgDto.setRetreiveDuation(Duration.between(msg.getCreatedAt(), now).toSeconds());
                    msgDtoList.add(msgDto);
                }
        );
        return msgDtoList;
    }
}
