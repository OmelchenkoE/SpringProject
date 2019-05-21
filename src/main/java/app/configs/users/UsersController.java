package app.configs.users;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UsersController {
    Store store = new Store();

    //TODO: find out why I should use it for the page, and shouldn't use a similar for another pages
    @GetMapping("/registration")
    public String usersForm(Model model) {
        model.addAttribute("user", new User());
        return "registration";
    }

    @PostMapping("/users")
    public String usersSubmit(@ModelAttribute User user, Model model) {
        store.addUser(user.getName(), user.getPassword());
        model.addAttribute("store",store);
        return "users";
    }

}