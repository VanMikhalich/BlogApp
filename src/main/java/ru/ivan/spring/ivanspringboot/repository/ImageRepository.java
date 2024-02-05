package ru.ivan.spring.ivanspringboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.ivan.spring.ivanspringboot.entity.Image;

public interface ImageRepository extends JpaRepository<Image, Long> {
}
