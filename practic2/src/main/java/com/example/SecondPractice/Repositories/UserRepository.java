package com.example.SecondPractice.Repositories;

import com.example.SecondPractice.Entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    User findByEmail(String email);

    void deleteByEmail(String email);
}
