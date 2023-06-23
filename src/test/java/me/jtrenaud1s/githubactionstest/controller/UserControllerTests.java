package me.jtrenaud1s.githubactionstest.controller;

import me.jtrenaud1s.githubactionstest.domain.model.User;
import me.jtrenaud1s.githubactionstest.service.UserService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class UserControllerTests {

    @InjectMocks
    private UserController userController;

    @Mock
    private UserService userService;

    // Test UserController here

    @Test
    void testGetUserById() {
        when(userService.getUserById(anyLong())).thenReturn(new User());
        ResponseEntity<User> response = userController.getUserById(1L);
        verify(userService).getUserById(anyLong());
        assertNotNull(response.getBody());
    }

    @Test
    void getAllUsers() {
        when(userService.getAllUsers()).thenReturn(List.of(new User()));
        ResponseEntity<List<User>> response = userController.getAllUsers();
        verify(userService).getAllUsers();
        assertNotNull(response.getBody());
    }

    @Test
    void testCreateUser() {
        when(userService.upsertUser(new User())).thenReturn(new User());
        ResponseEntity<User> response = userController.createUser(new User());
        verify(userService).upsertUser(new User());
        assertNotNull(response.getBody());
    }

    @Test
    void testUpdateUser() {
        when(userService.upsertUser(new User())).thenReturn(new User());
        ResponseEntity<User> response = userController.updateUser(new User());
        verify(userService).upsertUser(new User());
        assertNotNull(response.getBody());
    }

    @Test
    void testDeleteUser() {
        ResponseEntity<Void> response = userController.deleteUser(1L);
        verify(userService).deleteUser(anyLong());
        assertEquals(200, response.getStatusCode().value());
    }

}
