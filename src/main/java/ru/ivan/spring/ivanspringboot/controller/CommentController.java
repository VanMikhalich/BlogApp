package ru.ivan.spring.ivanspringboot.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.ivan.spring.ivanspringboot.entity.Comment;
import ru.ivan.spring.ivanspringboot.entity.User;
import ru.ivan.spring.ivanspringboot.services.CommentService;
import ru.ivan.spring.ivanspringboot.services.UserService;

import java.security.Principal;

@Controller
@RequiredArgsConstructor
public class CommentController {
    private final CommentService commentService;
    private final UserService userService;


    @PostMapping("/create_comment/{id}")
    public String createComment(@PathVariable Long id, @ModelAttribute Comment comment, Principal principal) {
        commentService.createComment(id, comment, principal);
        return "redirect:/post/" + id;
    }

    @PostMapping("/delete_comment/{id}")
    public String deleteComment(@PathVariable Long id) {
        Comment comment = commentService.getCommentById(id);
        commentService.deleteComment(id);
        return "redirect:/post/" + comment.getPost().getId();
    }

    @GetMapping("/update_comment/{id}")
    public String update(@PathVariable Long id, Model model, Principal principal) {
        Comment comment = commentService.getCommentById(id);
        model.addAttribute("user", userService.getUserByPrincipal(principal));
        model.addAttribute("comment", comment);
        return "update_comment";

    }
    @PostMapping("/update_comment")
    public String update(Long id, @RequestParam String text){
        Comment comment = commentService.getCommentById(id);
        commentService.updateComment(comment, text);
        return "redirect:/post/" + comment.getPost().getId();
    }
}
