package com.deneme.deneme.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.deneme.deneme.enti.Todo;
import com.deneme.deneme.requests.TodoCreateRequest;
import com.deneme.deneme.requests.TodoUpdateRequest;
import com.deneme.deneme.services.TodoService;

@RestController
@RequestMapping(value="/todo")
public class TodoController {

	private TodoService todoService;

	public TodoController(TodoService todoService) {
		this.todoService = todoService;
	}
	
	@GetMapping
	public List<Todo> getAllTodos(@RequestParam Optional<Long> userId) {
		return todoService.getAllTodos(userId);
	}

	@PostMapping
	public Todo createOneTodo(@RequestBody TodoCreateRequest newTodoRequest) {
		return todoService.createOneTodo(newTodoRequest);
	}
	
	
	@GetMapping("/{todoId}")
	public Todo getOneTodo(@PathVariable Long todoId) {
		return todoService.getOneTodoById(todoId);
	}
	
	@PutMapping("/{todoId}")
	public Todo updateOneTodo(@PathVariable Long todoId, @RequestBody TodoUpdateRequest updateTodo) {
		return todoService.updateOneTodoById(todoId, updateTodo);
	}
	
	@DeleteMapping("/{todoId}")
	public void deleteOneTodo(@PathVariable Long todoId) {
		todoService.deleteOneTodoById(todoId);
	}
}
