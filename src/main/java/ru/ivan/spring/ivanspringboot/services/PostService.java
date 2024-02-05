package ru.ivan.spring.ivanspringboot.services;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import ru.ivan.spring.ivanspringboot.entity.Comment;
import ru.ivan.spring.ivanspringboot.entity.Image;
import ru.ivan.spring.ivanspringboot.entity.Post;
import ru.ivan.spring.ivanspringboot.entity.User;
import ru.ivan.spring.ivanspringboot.facade.ImageFacade;
import ru.ivan.spring.ivanspringboot.repository.PostRepository;
import ru.ivan.spring.ivanspringboot.repository.UserRepository;

import java.io.IOException;
import java.security.Principal;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class PostService {
    private final PostRepository postRepository;
    private final ImageFacade imageFacade;
    private final UserRepository userRepository;

    public void deletePost(Long id) {
        log.info("Delete post with id {}", id);
        postRepository.deleteById(id);
    }

    public void savePost(Post post, MultipartFile imageFile, Principal principal) throws IOException {
        post.setUser(getUserByPrincipal(principal));
        Image image = imageFacade.toImageEntity(imageFile);
        post.setImage(image);
        postRepository.save(post);
    }

    public Post getPostById(Long id) {
        return postRepository.findById(id).orElse(null);
    }

    public List<Post> getAllPosts() {
        return postRepository.findAll();
    }

    public void updatePost(Post post, MultipartFile imageFile, Principal principal) throws IOException {
        /*if (imageFile != null) {
            Post oldPost = getPostById(post.getId());
            Image oldImage = oldPost.getImage();
            log.info("Delete Image with id {}", oldImage.getId());
            imageRepository.delete(oldImage);
        }*/
        /*Image image = imageFacade.toImageEntity(imageFile);
        post.setImage(image);*/
        log.info("Update {}", post);
        savePost(post, imageFile, principal);
    }

    public boolean check(Long id, Post post, Principal principal) {
        User user = userRepository.findByUsername(principal.getName());
        List<Post> userPosts = user.getPosts();
        List<Comment> userComments = user.getComments();
        boolean show = false;
        for (Post userPost : userPosts) {
            if(userPost.getId().equals(id)) show = true;
        }
        for (Comment userComment : userComments) {
            for (Comment postComment: post.getComments()) {
                if (userComment.getId().equals(postComment.getId())) {
                    postComment.setShow(true);
                }
            }
        }
        return show;
    }

    public User getUserByPrincipal(Principal principal) {
        if (principal == null)
            return new User();
        return userRepository.findByUsername(principal.getName());
    }
}
