package ru.ivan.spring.ivanspringboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.ivan.spring.ivanspringboot.entity.Post;

public interface PostRepository extends JpaRepository<Post, Long> {
}
