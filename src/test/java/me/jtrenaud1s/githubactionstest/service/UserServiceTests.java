package me.jtrenaud1s.githubactionstest.service;

import me.jtrenaud1s.githubactionstest.domain.model.User;
import me.jtrenaud1s.githubactionstest.domain.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class UserServiceTests {

    @InjectMocks
    private UserService userService;

    @Mock
    private UserRepository userRepository;

    @Test
    void testGetUserById() {
        when(userRepository.findById(anyLong())).thenReturn(Optional.of(new User()));
        User user = userService.getUserById(1L);
        assertNotNull(user);
        verify(userRepository).findById(anyLong());
    }

    @Test
    void testGetAllUsers() {
        when(userRepository.findAll()).thenReturn(List.of(new User()));
        List<User> users = userService.getAllUsers();
        assertNotNull(users);
        assertEquals(1, users.size());
        verify(userRepository).findAll();
    }

    @Test
    void testUpsertUser() {
        when(userRepository.save(any(User.class))).thenReturn(new User());
        User user = userService.upsertUser(new User());
        assertNotNull(user);
        verify(userRepository).save(any(User.class));
    }

    @Test
    void testDeleteUser() {
        doNothing().when(userRepository).deleteById(anyLong());
        userService.deleteUser(1L);
        verify(userRepository).deleteById(anyLong());
    }
}
