package com.nnk.springboot.services;

import java.util.List;

import com.nnk.springboot.domain.User;

public interface UserService {
	/**
	 * 
	 *  @param User
	 */
	public void saveUpdate(User user);
	
	/**
	 * 
	 * @param User
	 */
	public void delete(User user);
	
	/**
	 * 
	 * @return list User
	 */
	public List<User> listUser();
	
	/**
	 * 
	 * @param id
	 * @return User
	 */
	public User findUserById(int id);
}
