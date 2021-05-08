package spring_mvc_crud.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
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
    public String newUser(@ModelAttribute("user") User user) {
        return "new";
    }

    @PostMapping("/new")
    public String create(@ModelAttribute("user") User user, @RequestParam("role") ArrayList<String> role) {
        if (userService.getUserByPassword(user.getPassword()) != null) return "userExists";
        Set<Role> roleSet = new HashSet<>();
        for (String roleId : role) {
            roleSet.add(roleService.getRoleById(Long.valueOf(roleId)));
        }
        user.setRoles(roleSet);
        userService.addUser(user);
        return "redirect:/admin";
    }

    @GetMapping("/{id}/edit")
    public String edit(@PathVariable("id") int id, Model model) {
        model.addAttribute("user", userService.getUser(id));
        return "edit";
    }

    @PatchMapping("/user/{id}")
    public String update(@ModelAttribute("user") User user,
                         @RequestParam ArrayList<String> role) {
        Set<Role> roleSet = new HashSet<>();
        for (String roleId : role) {
            roleSet.add(roleService.getRoleById(Long.valueOf(roleId)));
        }
        user.setRoles(roleSet);
        userService.updateUser(user);
        return "redirect:/admin";
    }

    @DeleteMapping("/user/{id}")
    public String delete(@PathVariable("id") int id) {
        userService.deleteUser(id);
        return "redirect:/admin";
    }
}



