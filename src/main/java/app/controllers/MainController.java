package app.controllers;

import app.repos.UserRepo;
import app.domain.Roles;
import app.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MainController {

    private static final String ADMIN = "ADMIN";

    private final UserRepo userRepo;

    public MainController(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    @GetMapping("/")
    public String usersFormGet() {
        return "index";
    }

    @PreAuthorize("hasAuthority('"+ADMIN+"')")
    @GetMapping("/remove")
    public String removeUserGet(User user, Model model) {
        model.addAttribute("user", user);
        return "remove";
    }

    @PreAuthorize("hasAuthority('"+ADMIN+"')")
    @GetMapping("/registration")
    public String addUserFormGet(User user, Model model) {
        model.addAttribute("rolesList", Roles.values());
        model.addAttribute("user", user);
        return "registration";
    }

    @PostMapping("/")
    public String usersFormPost() {
        return "index";
    }

    @PreAuthorize("hasAuthority('"+ADMIN+"')")
    @PostMapping("/registration")
    public String addUserPost() {
        return "registration";
    }

    @PostMapping("/users")
    public String usersSubmit(@ModelAttribute User user, Model model) {
        user.setActive(true);
        model.addAttribute("user", user);
        userRepo.save(user);
        model.addAttribute("userList", userRepo.findAll());
        return "users";
    }

    @PreAuthorize("hasAuthority('"+ADMIN+"')")
    @PostMapping("/remove")
    public String removeUser(@ModelAttribute User user) {
        userRepo.deleteById(user.getId());
        return "remove";
    }

    @GetMapping("/users")
    public String userList(Model model) {
        model.addAttribute("userList", userRepo.findAll());
        return "/users";
    }
}