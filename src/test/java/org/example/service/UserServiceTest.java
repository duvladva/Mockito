package org.example.service;

import org.example.dao.UserDao;
import org.example.model.User;
import org.example.service.impl.UserServiceImpl;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class UserServiceTest {
    private static final User CORRECT_USER = new User("Алексей");
    private static final User NOT_CORRECT_USER = new User("Геннадий");
    private static final List<User> users = List.of(
            new User("Алексей"),
            new User("Борис"),
            new User("Владимир")
    );

    @Mock
    private UserDao userDaoMock;
    @InjectMocks
    private UserServiceImpl out;

    public UserServiceTest() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    @DisplayName("true, если есть в списке")
    void shouldReturnTrueIfUserExist() {
        when(userDaoMock.findAllUsers()).thenReturn(users);
        assertEquals(users, userDaoMock.findAllUsers());
        assertTrue(out.checkUserExist(CORRECT_USER));
    }

    @Test
    @DisplayName("false, если нет в списке")
    void shouldReturnFalseIfUserNotExist() {
        when(userDaoMock.findAllUsers()).thenReturn(users);
        assertEquals(users, userDaoMock.findAllUsers());
        assertFalse(out.checkUserExist(NOT_CORRECT_USER));
    }
}