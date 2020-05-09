package com.nnk.springboot.controllers.api;

import com.nnk.springboot.domain.User;
import com.nnk.springboot.repositories.UserRepository;
import com.nnk.springboot.services.UserService;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import javax.validation.Valid;

@RestController
public class UserControllerApi {

	@Autowired
	private UserService userService;

	/**
	 * Use for validate a new UserList
	 * 
	 * @return redirect to User Home if valid
	 */
	@PostMapping("/user")
	public String validate(@RequestBody User user) {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		user.setPassword(encoder.encode(user.getPassword()));
		userService.saveUpdate(user);
		return "User ajouté avec succès";

	}

	/**
	 * Return add User list
	 * 
	 * @return itself update
	 */
	@GetMapping("/user")
	public List<User> allUser() {
		return userService.listUser();
	}

	
	/**
	 * Use for update a bid and validate it
	 * 
	 * @return redirect to User Home if valid
	 */
	@PutMapping("/user/{id}")
	public String updateUser(@PathVariable("id") Integer id, @RequestBody User user) {		

		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		
		if(userService.findUserById(id)==null) {
			return "User introuvable";
		}else {
			user.setPassword(encoder.encode(user.getPassword()));
			user.setId(id);
			userService.saveUpdate(user);
			return "User modifié avec succès";
		}

	}

	/**
	 * Use for delete a bid
	 * 
	 * @return redirect to User Home
	 */
	@DeleteMapping("/user/{id}")
	public String deleteUser(@PathVariable("id") Integer id, Model model) {
		User user =userService.findUserById(id);
		
		if(user==null) {
			return "User introuvable";	
		}else {
			userService.delete(user);
			return "User ajouté supprimé succès";
		}
		
	}
}
