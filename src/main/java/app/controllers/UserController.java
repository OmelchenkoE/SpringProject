package app.controllers;

import app.domain.Roles;
import app.domain.User;
import app.service.UserServices;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RequiredArgsConstructor
@Controller
public class UserController {

    private static final String ADMIN = "ADMIN";

    @Autowired
    UserServices userServices;

    @PreAuthorize("hasAuthority('" + ADMIN + "')")
    @GetMapping("/remove")
    public String toRemovinPage() {
        return "remove";
    }

    @PreAuthorize("hasAuthority('" + ADMIN + "')")
    @GetMapping("/registration")
    public String toCreatingNewUserPage(@ModelAttribute User user, Model model) {
        model.addAttribute("rolesList", Roles.values());
        return "registration";
    }

    @PostMapping("/users")
    @Transactional
    public String creatingNewUser(@ModelAttribute User user, Model model) {
        model.addAttribute("user", userServices.create(user));
        return "users";
    }

    @PreAuthorize("hasAuthority('" + ADMIN + "')")
    @PostMapping("/remove")
    @Transactional
    public String removingUser(@RequestParam int id) {
        userServices.delete(id);
        return "remove";
    }

    @GetMapping("/users")
    public String getUserList(Model model) {
        model.addAttribute("userList", userServices.readAll());
        return "/users";
    }
}