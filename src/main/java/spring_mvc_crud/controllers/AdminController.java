package spring_mvc_crud.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import spring_mvc_crud.models.Role;
import spring_mvc_crud.models.User;
import spring_mvc_crud.service.RoleServiceImpl;
import spring_mvc_crud.service.UserServiceImpl;

import java.util.*;

@Controller
@RequestMapping("/")
public class AdminController {

    private final UserServiceImpl userService;
    private final RoleServiceImpl roleService;

    @Autowired
    public AdminController(UserServiceImpl userService, RoleServiceImpl roleService) {
        this.userService = userService;
        this.roleService = roleService;
    }

    @GetMapping("/admin")
    public String index(Model model) {
        model.addAttribute("users", userService.getAllUsers());
        return "admin";
    }

    @GetMapping("/user/{id}")
    public String show(@PathVariable("id") int id, Model model) {
        model.addAttribute("user", userService.getUser(id));
        return "showuser";
    }

    @GetMapping("/new")
    public ModelAndView newUser() {
        User user = new User();
        ModelAndView mav = new ModelAndView("new");
        mav.addObject("user", user);
        List<Role> roles = (List<Role>) roleService.getRoles();
        mav.addObject("roles", roles);
        return mav;
    }

    @PostMapping("/new")
    public String create(@RequestParam String name,
                         @RequestParam String surname,
                         @RequestParam Integer yearOfBirth,
                         @RequestParam String password,
                         @RequestParam String username,
                         @RequestParam ArrayList<String> roles) {
        ArrayList<String> stringRoleList = roles;
        Set<Role> roleSet = new HashSet<>();
        for (String roleId : stringRoleList) {
            roleSet.add(roleService.getRoleById(Long.valueOf(roleId)));
        }
        User user = new User(name, surname, yearOfBirth, password, username, roleSet);
        userService.addUser(user);
        return "redirect:/admin";
    }

    @GetMapping("/{id}/edit")
    public String edit(@PathVariable("id") int id, Model model) {
        model.addAttribute("user", userService.getUser(id));
        List<Role> roles = (List<Role>) roleService.getRoles();
        model.addAttribute("roles", roles);
        return "edit";
    }

    @PatchMapping("/user/{id}")
    public String update(@PathVariable("id") int id,
                         @RequestParam String name,
                         @RequestParam String surname,
                         @RequestParam Integer yearOfBirth,
                         @RequestParam String password,
                         @RequestParam String username,
                         @RequestParam ArrayList<String> roles) {
        ArrayList<String> stringRoleList = roles;
        Set<Role> roleSet = new HashSet<>();
        for (String roleId : stringRoleList) {
            roleSet.add(roleService.getRoleById(Long.valueOf(roleId)));
        }
        User user = new User(id, name, surname, yearOfBirth, password, username, roleSet);
        userService.updateUser(user);
        return "redirect:/admin";
    }

    @DeleteMapping("/user/{id}")
    public String delete(@PathVariable("id") int id) {
        userService.deleteUser(id);
        return "redirect:/admin";
    }
}
