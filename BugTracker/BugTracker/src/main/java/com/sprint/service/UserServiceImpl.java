package com.sprint.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sprint.exception.UserNotFoundException;
import com.sprint.model.User;
import com.sprint.repository.UserRepo;


@Service("UserService")
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserRepo userRepo;

	@Override
	public User add(User user) throws UserNotFoundException {
		userRepo.saveAndFlush(user);
		return user;
	}

	@Override
	public User update(User user) throws UserNotFoundException {
		User bean = null;
		try {
			bean = userRepo.findById(user.getUserId()).get();
		}
		catch(Exception e) {
			throw new UserNotFoundException("User details not found!");
		}
		userRepo.saveAndFlush(user);
		return bean;
	}

	@Override
	public User delete(User user) throws UserNotFoundException {
		User bean = null;
		try {
			bean = userRepo.findById(user.getUserId()).get();
		}
		catch(Exception e) {
			throw new UserNotFoundException("User details not found!");
		}
		userRepo.deleteById(user.getUserId());
		return bean;
	}

	@Override
	public List<User> findByUsername(String username) throws UserNotFoundException {
		List<User> users = new ArrayList<>();
		try {
			for(User i :userRepo.findAll()) {
				if(i.getUsername().equals(username)) {
					users.add(i);
				}
			}
		}
		catch(Exception e) {
			throw new UserNotFoundException("User details not Found");
		}
		return users;
	}

	@Override
	public User findById(int userId) throws UserNotFoundException {
		User bean = null;
		try {
			bean = userRepo.findById(userId).get();
		}
		catch(Exception e) {
			throw new UserNotFoundException("User details not found!");
		}
		return bean;
	}

	

}
