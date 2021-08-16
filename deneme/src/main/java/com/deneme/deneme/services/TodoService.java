package com.deneme.deneme.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.deneme.deneme.enti.Todo;
import com.deneme.deneme.enti.User;
import com.deneme.deneme.repo.TodoRepo;
import com.deneme.deneme.requests.TodoCreateRequest;
import com.deneme.deneme.requests.TodoUpdateRequest;

@Service
public class TodoService {
	private TodoRepo todoRepository;
	private UserService userService;
	
	
	public TodoService(TodoRepo todoRepository, UserService userService) {
		this.todoRepository = todoRepository;
		this.userService = userService;
	}

	public List<Todo> getAllTodos(Optional<Long> userId) {
		if(userId.isPresent())
			return todoRepository.findByUserId(userId.get());
		return todoRepository.findAll();
	}

	public Todo getOneTodoById(Long todoId) {
		return todoRepository.findById(todoId).orElse(null);
	}

	public Todo createOneTodo(TodoCreateRequest newTodoRequest) {
		User user = userService.getOneUserById(newTodoRequest.getUserId());
		if(user == null)
			return null;
		Todo toSave = new Todo();
		toSave.setId(newTodoRequest.getId());
		toSave.setText(newTodoRequest.getText());
		toSave.setTitle(newTodoRequest.getTitle());
		toSave.setUser(user);
		return todoRepository.save(toSave);
	}

	public Todo updateOneTodoById(Long todoId, TodoUpdateRequest updateTodo) {
		Optional<Todo> todo = todoRepository.findById(todoId);
		if(todo.isPresent()) {
			Todo toUpdate = todo.get();
			toUpdate.setText(updateTodo.getText());
			toUpdate.setTitle(updateTodo.getTitle());
			todoRepository.save(toUpdate);
			return toUpdate;
		}
		return null;
	}

	public void deleteOneTodoById(Long todoId) {
		todoRepository.deleteById(todoId);
	}
}
