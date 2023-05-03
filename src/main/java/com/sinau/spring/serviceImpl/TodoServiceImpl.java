package com.sinau.spring.serviceImpl;

import java.time.Instant;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sinau.spring.models.SuccessModels;
import com.sinau.spring.models.TodoModels;
import com.sinau.spring.repository.TodoRepository;
import com.sinau.spring.service.TodoService;

@Service
public class TodoServiceImpl implements TodoService {
	@Autowired
	private TodoRepository todoRepository;

	@Override
	public TodoModels createTodo(TodoModels todo) {
		// TODO Auto-generated method stub
	
		return todoRepository.save(todo);
	}

	
	public Optional<TodoModels> FindTodo(Long id) {
		// TODO Auto-generated method stub
		return todoRepository.findById(id);
		
	}


	@Override
	public List<TodoModels> showAll() {
		// TODO Auto-generated method stub
		
		return todoRepository.findAll();
	}


	@Override
	public TodoModels updateTodo(Long id,TodoModels todoM) {
		Optional<TodoModels> todoFind = todoRepository.findById(id);
	TodoModels todo = todoFind.get();
	todo.setAktivitas(todoM.getAktivitas());
	todo.setDate(todoM.getDate());
	todo.setSelesai(todoM.getSelesai());
	todo.setUpdated_at(Instant.now());
		return todoRepository.save(todo);
	}


	@Override
	public SuccessModels deleteTodo(Long id) {
		// TODO Auto-generated method stub
		Optional<TodoModels> todoFind = todoRepository.findById(id);
		todoRepository.delete(todoFind.get());
		SuccessModels success = new SuccessModels();
		success.setMessage("Hapus Todo Berhasil!");
		success.setType("success");
		return success;
	}

}
