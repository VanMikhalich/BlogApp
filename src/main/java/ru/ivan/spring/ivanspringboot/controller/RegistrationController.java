package ru.ivan.spring.ivanspringboot.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import ru.ivan.spring.ivanspringboot.entity.User;
import ru.ivan.spring.ivanspringboot.entity.enums.Role;
import ru.ivan.spring.ivanspringboot.services.UserService;

import javax.validation.Valid;
import java.security.Principal;
import java.util.Collections;
import java.util.Map;

@Controller
@RequiredArgsConstructor
public class RegistrationController {
    private final UserService userService;
    private final PasswordEncoder passwordEncoder;

    @PostMapping("/registration")
    public String registerNewUser(@ModelAttribute @Valid User user,
                                  BindingResult bindingResult,
                                  Model model,
                                  Principal principal) {
        if (bindingResult.hasErrors()) {
            Map<String, String> errors = ControllerUtils.getErrors(bindingResult);
            model.mergeAttributes(errors);
            model.addAttribute("user", userService.getUserByPrincipal(principal));
            return "registration";
        }
        user.setActive(true);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setRoles(Collections.singleton(Role.ROLE_USER));
        userService.saveUser(user);
        return "redirect:/login";
    }

    @GetMapping("/registration")
    public String registration(Model model, Principal principal) {
        model.addAttribute("user", userService.getUserByPrincipal(principal));
        return "registration";
    }
}
