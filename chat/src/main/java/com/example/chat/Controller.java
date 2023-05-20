package com.example.chat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/testapp")
public class Controller {

    @Autowired
    private ChatService chatService;

    @PostMapping(path = "/")
    ResponseEntity createMsg(@RequestBody MessageDto msg) {
        chatService.createMessage(msg);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping(path = "/")
    ResponseEntity getMsg(@RequestParam("text") Integer userId) {
        return new ResponseEntity<>(chatService.getByUserId(userId), HttpStatus.OK);
    }

}
