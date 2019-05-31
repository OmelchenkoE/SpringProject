package app.controllers;

import app.domain.Message;
import app.domain.User;
import app.repos.MessageRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MessageController {

    @Autowired
    private MessageRepo messageRepo;


    @GetMapping("/messages")
    public String getMassage(Model model, Message message){
        model.addAttribute("message", message);
        model.addAttribute("messageList", messageRepo.findAll());
        return "messages";
    }

    @PostMapping("/messages")
    public String postMassage(@ModelAttribute Message message,Model model) {
        messageRepo.save(message);
        model.addAttribute("userList", messageRepo.findAll());
        return "messages";
    }
}
