package com.sinau.spring.service;

import java.util.List;
import java.util.Optional;

import com.sinau.spring.models.SuccessModels;
import com.sinau.spring.models.TodoModels;

public interface TodoService {

	TodoModels createTodo(TodoModels todo);
	Optional<TodoModels> FindTodo(Long id);
	List<TodoModels> showAll();
	TodoModels updateTodo(Long id,TodoModels todoM);
	SuccessModels deleteTodo(Long id);
}
