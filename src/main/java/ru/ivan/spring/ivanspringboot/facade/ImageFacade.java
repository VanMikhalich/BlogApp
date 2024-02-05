package ru.ivan.spring.ivanspringboot.facade;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;
import ru.ivan.spring.ivanspringboot.entity.Image;

import java.io.IOException;

@Component
public class ImageFacade {
    public Image toImageEntity(MultipartFile file) throws IOException {
        Image image = new Image();
        image.setName(file.getName());
        image.setOriginalFileName(file.getOriginalFilename());
        image.setContentType(file.getContentType());
        image.setSize(file.getSize());
        image.setBytes(file.getBytes());
        return image;
    }
}
