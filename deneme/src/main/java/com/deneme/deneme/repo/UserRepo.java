package com.deneme.deneme.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.deneme.deneme.enti.User;

public interface UserRepo extends JpaRepository<User, Long> {

}
