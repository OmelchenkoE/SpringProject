package app;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AppContoller {

    @GetMapping("/")
    public String index() {
        return "index";
    }
}