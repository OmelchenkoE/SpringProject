package app.controllers;

import app.domain.Message;
import app.service.MessageServices;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;


@RequiredArgsConstructor
@Controller
public class MessageController {

    @Autowired
    private final MessageServices messageServices;

    @GetMapping("/messages")
    public String getMessage(Model model, Message message) {
        model.addAttribute("message", message);
        model.addAttribute("messageList", messageServices.readAll());
        return "messages";
    }

    @PostMapping("/messages")
    @Transactional
    public String postMassage(/*@AuthenticationPrincipal User user, */ Message message, Model model) {
        //message.setAuthor(user.getName());
        messageServices.create(message);
        model.addAttribute("messageList", messageServices.readAll());
        return "messages";
    }
}
