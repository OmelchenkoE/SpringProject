package app.controllers;

import app.repos.UserRepo;
import app.users.Roles;
import app.users.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import java.util.Collections;

@Controller
public class MainController {

    @Autowired
    private UserRepo userRepo;

   @GetMapping("/")
    public String usersForm(Model model) {
        model.addAttribute("user", new User());
        return "registration";
    }

    @PostMapping("/users")
    public @ResponseBody Iterable<User> usersSubmit(@ModelAttribute User user, Model model) {
        user.setRoles(Collections.singleton(Roles.USER));
        userRepo.save(user);
        return userRepo.findAll();
    }
}