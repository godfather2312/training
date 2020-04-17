package com.endress.ims.applicants.business.boundary;


import com.endress.ims.applicants.business.control.MessageService;
import com.endress.ims.applicants.business.entity.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(path = "/messages", produces = MediaType.APPLICATION_JSON_VALUE)
public class MessageRestController {

    @Autowired
    private MessageService messageService;

    @PostMapping
    public void sendMessage(@RequestParam("email") String emailAddress, @RequestBody @Valid Message message) {
        messageService.sendMessage(message);
    }

    @GetMapping
    public List<Message> getSentMessages() {
        return messageService.retrieveSentMessages();
    }
}
