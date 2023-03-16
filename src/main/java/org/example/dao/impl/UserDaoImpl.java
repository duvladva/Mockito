package org.example.dao.impl;

import org.example.dao.UserDao;
import org.example.model.User;

import java.util.ArrayList;
import java.util.List;

public class UserDaoImpl implements UserDao {
    private final List<User> users = new ArrayList<>();

    public UserDaoImpl() {
        users.add(new User("Алексей"));
        users.add(new User("Борис"));
        users.add(new User("Владимир"));
    }

    @Override
    public User getUserByName(String name) {
        for (User user : users) {
            if (user.getName().equals(name)) {
                return user;
            }
        }
        return null;
    }

    @Override
    public List<User> findAllUsers() {
        return users;
    }
}