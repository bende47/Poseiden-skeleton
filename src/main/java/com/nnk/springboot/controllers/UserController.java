package com.nnk.springboot.controllers;

import com.nnk.springboot.domain.User;
import com.nnk.springboot.repositories.UserRepository;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
public class UserController {

	private static final Logger logger = LogManager.getRootLogger();

	@Autowired
	private UserRepository userRepository;

	/**
	 * Load all User
	 * 
	 * @param model current Model
	 * @return itself update
	 */
	@RequestMapping("/user/list")
	public String home(Model model) {
		logger.info("Request = @RequestMapping(\"/user/list\")");
		model.addAttribute("users", userRepository.findAll());
		return "user/list";
	}

	/**
	 * Return add User list
	 * 
	 * @return itself update
	 */
	@GetMapping("/user/add")
	public String addUser(User bid) {
		logger.info("Request = @GetMapping(\"/user/add\")");
		return "user/add";
	}

	/**
	 * Use for validate a new UserList
	 * 
	 * @return redirect to User Home if valid
	 */
	@PostMapping("/user/validate")
	public String validate(@Valid User user, BindingResult result, Model model) {
		logger.info("Request = @PostMapping(\"/user/validate\" + @RequestBody = {}", user + ")");

		if (!result.hasErrors()) {
			BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
			user.setPassword(encoder.encode(user.getPassword()));
			userRepository.save(user);
			model.addAttribute("users", userRepository.findAll());
			logger.info("User ajouté avec succès");

			return "redirect:/user/list";
		}
		return "user/add";
	}

	/**
	 * Use for navigate to the update form with the User asked
	 * 
	 * @return redirect to User update resource
	 */
	@GetMapping("/user/update/{id}")
	public String showUpdateForm(@PathVariable("id") Integer id, Model model) {
		logger.info("Request = @GetMapping(\"/user/update/" + id + "\")");
		User user = userRepository.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + id));
		user.setPassword("");
		model.addAttribute("user", user);
		return "user/update";
	}

	/**
	 * Use for update a bid and validate it
	 * 
	 * @return redirect to User Home if valid
	 */
	@PostMapping("/user/update/{id}")
	public String updateUser(@PathVariable("id") Integer id, @Valid User user, BindingResult result, Model model) {
		logger.info("Request = @PostMapping(\"/user/update/" + id + "\" + @RequestBody = {}", user + ")");

		if (result.hasErrors()) {
			return "user/update";
		}

		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		user.setPassword(encoder.encode(user.getPassword()));
		user.setId(id);
		userRepository.save(user);
		model.addAttribute("users", userRepository.findAll());
		logger.info("User modifié avec succès");

		return "redirect:/user/list";
	}

	/**
	 * Use for delete a bid
	 * 
	 * @return redirect to User Home
	 */
	@GetMapping("/user/delete/{id}")
	public String deleteUser(@PathVariable("id") Integer id, Model model) {
		logger.info("Request = @GetMapping(\"/bidList/user/" + id + "\")");
		User user = userRepository.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + id));
		userRepository.delete(user);
		model.addAttribute("users", userRepository.findAll());
		logger.info("User ajouté supprimé succès");

		return "redirect:/user/list";
	}
}
