package com.hour.carmedy.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.hour.carmedy.model.ChatRequestModel;
import com.hour.carmedy.service.DungeonChatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/chat")
public class DungeonChatController {

    @Autowired
    DungeonChatService dungeonChatService;

    @PostMapping("/query")
    public String sendMessage(@RequestBody(required = true) ChatRequestModel query) throws JsonProcessingException {

        return dungeonChatService.queryCreature(query.getUserId(), query.getContent(), query.getPersonality());

    }



}
