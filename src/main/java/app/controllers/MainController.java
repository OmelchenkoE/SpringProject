package app.controllers;

import app.repos.UserRepo;
import app.domain.Roles;
import app.domain.User;
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
    public String usersFormGet(User user, Model model) {
        model.addAttribute("user", user);
        return "registration";
    }

    @GetMapping("/registration")//used
    public String usersFormGet1(User user, Model model) {
        model.addAttribute("user", user);
        return "registration";
    }

    @PostMapping("/")
    public String usersFormpost() {
        return "registration";
    }

    @PostMapping("/registration")
    public String usersFormpost1() {
        return "registration";
    }

    @PostMapping("/users")
    public String usersSubmit(@ModelAttribute User user, Model model) {
        user.setRoles(Collections.singleton(Roles.USER));
        user.setActive(true);
        userRepo.save(user);
        return "users";
    }

    @GetMapping("/users")//used
    public String userList(Model model) {
        model.addAttribute("userList", userRepo.findAll());
        return "/users";
    }
}