package com.nnk.springboot.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nnk.springboot.domain.User;
import com.nnk.springboot.repositories.UserRepository;

@Service
public class UserServiceImpl implements UserService{
	@Autowired 
	private UserRepository UserRepository;

	@Override
	public void saveUpdate(User User) {		
		UserRepository.save(User);
	}

	@Override
	public void delete(User User) {
		UserRepository.delete(User);
	}

	@Override
	public List<User> listUser() {
		return UserRepository.findAll();
	}

	@Override
	public User findUserById(int id) {
		User User = UserRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid User Id:" + id));
		return User;
	}
	
}
