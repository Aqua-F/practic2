package com.example.SecondPractice.Repositories;

import com.example.SecondPractice.Entities.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AccountRepository extends JpaRepository<Account, Integer> {
    public List<Account> findByUserId(int userId);
    public void deleteByUserId(int userId);
}
