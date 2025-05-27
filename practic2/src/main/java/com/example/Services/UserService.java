package com.example.Services;

import com.example.DAO.UserDAO;
import com.example.Entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final UserDAO userDAO;

    @Autowired
    public UserService(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    public boolean authenticateUser(String email, String password) {
        User user = userDAO.findUserByEmail(email);
        return user != null && user.getPassword().equals(password);
    }

    public boolean userExists(String email) {
        return userDAO.findUserByEmail(email) != null;
    }

    public void saveUser(User user) {
        userDAO.saveUser(user);
    }

    public boolean deleteUserById(int id) {
        User user = userDAO.findUserById(id);

        if (user != null) {
            userDAO.deleteUserById(id);
            return true;
        }
        return false;
    }

    public User findUserById(int userId) {
        return userDAO.findUserById(userId);
    }

    public User findUserByEmail(String email) {
        return userDAO.findUserByEmail(email);
    }
}
