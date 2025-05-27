package com.example.DAO;

import com.example.Entities.User;
import com.example.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UserDAO {
    private final UserRepository userRepository;

    @Autowired
    public UserDAO(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    //Сохранение сущности в базу
    public User saveUser(User user) {
        return userRepository.save(user);
    }

    //Поиск сущности по полю
    public User findUserById(int id) {
        return userRepository.findById(id).get();
    }

    public User findUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    //Удаление сущности по условию
    public void deleteUserById(int id) {
        userRepository.deleteById(id);
    }

    public void deleteUserByEmail(String email) {
        userRepository.deleteByEmail(email);
    }
}
