package spring_mvc_crud.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import spring_mvc_crud.models.User;
import spring_mvc_crud.service.UserServiceImpl;


@Controller
@RequestMapping("/")
public class LoginController {

    private final UserServiceImpl userService;

    @Autowired
    public LoginController(UserServiceImpl userService) {
        this.userService = userService;
    }

    @GetMapping("/hello")
    public String printWelcome(@AuthenticationPrincipal User activeUser, Model model) {
        model.addAttribute("roles", activeUser.getRoles());
        return "hello";
    }

    @GetMapping("/login")
    public String loginPage() {
        return "login";
    }

}
