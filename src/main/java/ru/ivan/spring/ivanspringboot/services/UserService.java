package ru.ivan.spring.ivanspringboot.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.ivan.spring.ivanspringboot.entity.User;
import ru.ivan.spring.ivanspringboot.repository.UserRepository;

import java.security.Principal;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    public void saveUser(User user) {
        userRepository.save(user);
    }

    public User getUserById(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    public User getUserByPrincipal(Principal principal) {
        if (principal == null)
            return new User();
        return userRepository.findByUsername(principal.getName());
    }
}
