package app.controllers;

import app.domain.Message;
import app.repos.MessageRepo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MessageController {

    private final MessageRepo messageRepo;

    public MessageController(MessageRepo messageRepo) {
        this.messageRepo = messageRepo;
    }

    @GetMapping("/messages")
    public String getMassage(Model model, Message message){
        model.addAttribute("message", message);
        model.addAttribute("messageList", messageRepo.findAll());
        return "messages";
    }

    @PostMapping("/messages")
    public String postMassage(Message message, Model model) {
        messageRepo.save(message);
        model.addAttribute("messageList", messageRepo.findAll());
        return "messages";
    }
}
