package ru.ivan.spring.ivanspringboot.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ru.ivan.spring.ivanspringboot.services.UserService;

import java.security.Principal;

@Controller
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @GetMapping("/login")
    public String login(Model model, Principal principal) {
        model.addAttribute("user", userService.getUserByPrincipal(principal));
        return "login";
    }
}
