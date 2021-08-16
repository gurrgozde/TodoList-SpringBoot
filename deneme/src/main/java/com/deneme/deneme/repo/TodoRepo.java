package com.deneme.deneme.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.deneme.deneme.enti.Todo;

public interface TodoRepo extends JpaRepository<Todo, Long> {

	List<Todo> findByUserId(Long userId);

}
