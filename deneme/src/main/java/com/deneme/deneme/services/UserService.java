package com.deneme.deneme.services;

import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;

import com.deneme.deneme.enti.Todo;
import com.deneme.deneme.enti.User;
import com.deneme.deneme.repo.UserRepo;
import com.deneme.deneme.requests.TodoCreateRequest;
import com.deneme.deneme.requests.UserCreateRequest;


@Service
public class UserService {
	
	UserRepo userRepo;

	public UserService(UserRepo userRepo) {
		
		this.userRepo = userRepo;
	}

	public List<User> getAllUsers() {
		// TODO Auto-generated method stub
		return userRepo.findAll();
	}

	public User saveOneUser(User newUser) {
		return userRepo.save(newUser);
	}

	public User getOneUserById(Long userId) {
		return userRepo.findById(userId).orElse(null);
	}
	public User createOneTodo(UserCreateRequest newUserRequest) {
		User toSave = new User();
		
		
		toSave.setId(newUserRequest.getId());
		toSave.setPassword(newUserRequest.getPassword());;
		toSave.setUserName(newUserRequest.getUserName());;
		
		return userRepo.save(toSave);
		
	}
	public User updateOneUser(Long userId, User newUser) {
		Optional<User> user = userRepo.findById(userId);
		if(user.isPresent()) {
			User foundUser = user.get();
			foundUser.setUserName(newUser.getUserName());
			foundUser.setPassword(newUser.getPassword());
			userRepo.save(foundUser);
			return foundUser;
		}else
			return null;
	}

	public void deleteById(Long userId) {
		userRepo.deleteById(userId);
	}
}
