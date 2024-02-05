package ru.ivan.spring.ivanspringboot.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.ivan.spring.ivanspringboot.entity.Image;
import ru.ivan.spring.ivanspringboot.repository.ImageRepository;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ImageService {
    private final ImageRepository imageRepository;

    public Image getImageById(Long id) {
        Optional<Image> optionalImage = imageRepository.findById(id);
        return optionalImage.orElse(null);
    }
    public void deleteImage(Long id) {
        imageRepository.deleteById(id);
    }
}
