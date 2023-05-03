package com.sinau.spring.controller;

import java.time.Instant;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sinau.spring.models.SuccessModels;
import com.sinau.spring.models.TodoModels;
import com.sinau.spring.service.TodoService;

import jakarta.validation.Valid;
import jakarta.websocket.server.PathParam;

@RestController
public class TodoController {

	@Autowired
	private TodoService todoService;
	
	@PostMapping("/todo")
	ResponseEntity<SuccessModels>createTodo(@Valid @RequestBody TodoModels todo){
		todo.setCreated_at(Instant.now());
		todo.setUpdated_at(Instant.now());
		todoService.createTodo(todo);
		
		SuccessModels success = new SuccessModels();
		success.setMessage("Sukses menambah todo");
		success.setType("success");
		
		return  ResponseEntity.status(HttpStatus.OK).contentType(MediaType.APPLICATION_JSON).body(success);
		
	}
	
	@GetMapping("/todo")
	ResponseEntity<Optional<TodoModels>>showTodo(@PathParam(value = "id") Long id){
		
		return ResponseEntity.status(HttpStatus.OK).contentType(MediaType.APPLICATION_JSON).body(todoService.FindTodo(id));
		
	}
	
	@GetMapping("/todo-all")
	ResponseEntity<List<TodoModels>>todoAll(){
		
		return ResponseEntity.status(HttpStatus.OK).contentType(MediaType.APPLICATION_JSON).body(todoService.showAll());
		
	}
	
	@PutMapping("/todo")
	ResponseEntity<SuccessModels>updateTodo(@PathParam(value = "id")Long id,@RequestBody TodoModels todo){
	 todoService.updateTodo(id, todo);
	 SuccessModels success = new SuccessModels();
	 success.setMessage("Update Todo Berhasil!");
	 success.setType("success");
	 return ResponseEntity.status(HttpStatus.OK).contentType(MediaType.APPLICATION_JSON).body(success);
		
	}
	
	@DeleteMapping("/todo")
	ResponseEntity<SuccessModels>deleteTodo(@PathParam(value="id") Long id){
		
		 return ResponseEntity.status(HttpStatus.OK).contentType(MediaType.APPLICATION_JSON).body(todoService.deleteTodo(id));
	}
}
