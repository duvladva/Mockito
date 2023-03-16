package org.example.dao;

import org.example.dao.impl.UserDaoImpl;
import org.example.model.User;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserDaoTest {
    private static final UserDaoImpl userDao = new UserDaoImpl();
    public static final String VALID_NAME = "Алексей";
    public static final String INVALID_NAME = "Геннадий";

    @Test
    @DisplayName("Проверка имени в списке")
    void shouldGetUserByName() {
        assertEquals(new User(VALID_NAME), userDao.getUserByName(VALID_NAME));
    }


    @Test
    @DisplayName("Возврат null если имени не существует в списке")
    void shouldGetNullGetUserByName() {
        assertNull(userDao.getUserByName(INVALID_NAME));
    }

}