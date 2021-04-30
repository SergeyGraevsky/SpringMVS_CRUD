package spring_mvc_crud.controllers;

import org.hibernate.internal.build.AllowPrintStacktrace;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import spring_mvc_crud.models.User;
import spring_mvc_crud.service.UserDetailsServiceImpl;
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
        model.addAttribute("roles",activeUser.getRoles());
        return "hello";
    }

    @GetMapping("/login")
    public String loginPage() {
        return "login";
    }

    //Метод GET запрашивает представление ресурса. Запросы с использованием этого метода могут только извлекать данные.

    //POST используется для отправки сущностей к определённому ресурсу.
    // Часто вызывает изменение состояния или какие-то побочные эффекты на сервере.

    //PUT заменяет все текущие представления ресурса данными запроса.

    //DELETE удаляет указанный ресурс.

    //PATCH используется для частичного изменения ресурса.
}
