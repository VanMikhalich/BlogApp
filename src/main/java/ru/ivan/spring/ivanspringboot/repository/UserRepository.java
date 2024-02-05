package ru.ivan.spring.ivanspringboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.ivan.spring.ivanspringboot.entity.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
