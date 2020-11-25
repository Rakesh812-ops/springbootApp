package com.neosoft.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.neosoft.dto.UserDTO;
import com.neosoft.entity.User;
import com.neosoft.service.UserService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/api/user")
@Slf4j
public class UserController {

	@Autowired
	private UserService userService;

	@PostMapping("/save")
	public ResponseEntity<?> saveUserDetails(@RequestBody UserDTO userDTO) {
		try {
			return userService.saveUserDetails(userDTO);
		} catch (Exception e) {
			throw new RuntimeException();
		}

	}
	
	@GetMapping("/getAll")
	public List<User> getAllUsers() {
		return userService.getAllUsers();
	}

	@GetMapping("/get/{id}")
	public User getUserById(@PathVariable("id") Integer id) {
		try {
			return userService.getUserById(id);
		} catch (Exception e) {
			throw new RuntimeException();
		}
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> deleteUserById(@PathVariable("id") Integer id) {
		try {
			return userService.deleteUserById(id);
		} catch (Exception e) {
			throw new RuntimeException();
		}
	}
	@PutMapping("/update/{id}")
        public ResponseEntity<?>updateUserDetailsById(@PathVariable("id") Integer id,UserDTO userDTO){
		try {
			return userService.updateUserDetailsById(id, userDTO);
		} catch (Exception e) {
			throw new RuntimeException();
		}
	
}
	
}