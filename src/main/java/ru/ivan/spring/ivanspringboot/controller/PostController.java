package ru.ivan.spring.ivanspringboot.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import ru.ivan.spring.ivanspringboot.entity.Post;
import ru.ivan.spring.ivanspringboot.services.PostService;
import ru.ivan.spring.ivanspringboot.services.UserService;

import javax.validation.Valid;
import java.io.IOException;
import java.security.Principal;
import java.util.Map;

@Controller
@RequiredArgsConstructor
public class PostController {
    private final PostService postService;
    private final UserService userService;

    @GetMapping("/")
    public String posts(Model model, Principal principal) {
        model.addAttribute("user", userService.getUserByPrincipal(principal));
        model.addAttribute("posts", postService.getAllPosts());
        return "posts";
    }

    @PostMapping("/create")
    public String createPost(@ModelAttribute @Valid Post post,
                             BindingResult bindingResult,
                             Model model,
                             @RequestParam("file") MultipartFile imageFile,
                             Principal principal
    ) throws IOException {
        if (bindingResult.hasErrors()) {
            Map<String, String> errors = ControllerUtils.getErrors(bindingResult);
            model.mergeAttributes(errors);
            model.addAttribute("user", userService.getUserByPrincipal(principal));
            model.addAttribute("posts", postService.getAllPosts());
            return "posts";
        }

        postService.savePost(post, imageFile, principal);
        return "redirect:/";
    }

    @PostMapping("/delete/{id}")
    public String deletePost(@PathVariable Long id) {
        postService.deletePost(id);
        return "redirect:/";
    }

    @GetMapping("/update/{id}")
    public String updatePost(@PathVariable Long id, Model model, Principal principal) {
        model.addAttribute("user", userService.getUserByPrincipal(principal));
        Post post = postService.getPostById(id);
        model.addAttribute("post", post);
        return "update_post";
    }

    @PostMapping("/update")
    public String update(@ModelAttribute Post post, @RequestParam(value = "file", required = false) MultipartFile imageFile,
    Principal principal) throws IOException {
        postService.updatePost(post, imageFile, principal);
        return "redirect:/";
    }

    @GetMapping("/post/{id}")
    public String postInfo(@PathVariable Long id, Model model, Principal principal) {
        Post post = postService.getPostById(id);
        boolean show = postService.check(id, post, principal);
        model.addAttribute("user", userService.getUserByPrincipal(principal));
        model.addAttribute("show", show);
        model.addAttribute("post", post);
        return "post-info";
    }
}