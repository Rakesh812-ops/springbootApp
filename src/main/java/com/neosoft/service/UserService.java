package com.neosoft.service;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;

import com.neosoft.dto.UserDTO;
import com.neosoft.entity.User;

public interface UserService {
	
	public ResponseEntity<?> saveUserDetails(UserDTO userDTO);
	List<User> getAllUsers();
	User getUserById(Integer id);
	ResponseEntity<?> deleteUserById(Integer id);
	ResponseEntity<?> updateUserDetailsById(Integer id,UserDTO userDTO);
//	Optional<User> getUserByName(String name);

	

}
