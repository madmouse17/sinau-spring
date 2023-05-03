package com.sinau.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sinau.spring.models.TodoModels;

public interface TodoRepository extends JpaRepository<TodoModels, Long> {

	
}
