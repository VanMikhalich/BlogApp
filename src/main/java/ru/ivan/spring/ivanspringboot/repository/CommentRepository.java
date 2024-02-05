package ru.ivan.spring.ivanspringboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.ivan.spring.ivanspringboot.entity.Comment;

public interface CommentRepository extends JpaRepository<Comment, Long> {
}
