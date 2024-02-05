package ru.ivan.spring.ivanspringboot.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.ivan.spring.ivanspringboot.entity.Comment;
import ru.ivan.spring.ivanspringboot.entity.Post;
import ru.ivan.spring.ivanspringboot.entity.User;
import ru.ivan.spring.ivanspringboot.repository.CommentRepository;
import ru.ivan.spring.ivanspringboot.repository.PostRepository;
import ru.ivan.spring.ivanspringboot.repository.UserRepository;

import java.security.Principal;

@Service
@RequiredArgsConstructor
public class CommentService {
    private final PostRepository postRepository;
    private final CommentRepository commentRepository;
    private final UserRepository userRepository;


    public void createComment(Long id, Comment comment, Principal principal) {
        Post post = postRepository.findById(id).orElse(null);
        comment.setPost(post);
        comment.setUser(getUserByPrincipal(principal));
        post.getComments().add(comment);
        postRepository.save(post);
    }

    public void deleteComment(Long id){
        commentRepository.deleteById(id);
    }

    public Comment getCommentById(Long id) {
        return commentRepository.findById(id).orElse(null);
    }

    public void updateComment(Comment comment, String text) {
        comment.setText(text);
        commentRepository.save(comment);
    }

    public User getUserByPrincipal(Principal principal) {
        if (principal == null)
            return new User();
        return userRepository.findByUsername(principal.getName());
    }
}
