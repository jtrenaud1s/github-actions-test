package me.jtrenaud1s.githubactionstest.service;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import me.jtrenaud1s.githubactionstest.domain.model.User;
import me.jtrenaud1s.githubactionstest.domain.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@AllArgsConstructor
@NoArgsConstructor(access = lombok.AccessLevel.PRIVATE)
public class UserService {

    private UserRepository userRepository;

    // crud operations for service layer on User entity

    public User getUserById(Long id) {
        log.info("Getting user with id: {}", id);
        return userRepository.findById(id).orElse(null);
    }

    public List<User> getAllUsers() {
        log.info("Getting all users");
        return (List<User>) userRepository.findAll();
    }

    public User upsertUser(User user) {
        log.info("Creating user: {}", user);
        return userRepository.save(user);
    }

    public void deleteUser(Long id) {
        log.info("Deleting user with id: {}", id);
        userRepository.deleteById(id);
    }
}
