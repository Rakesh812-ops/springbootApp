package com.neosoft.serviceImpl;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.neosoft.commons.Constant;
import com.neosoft.commons.DataNotFoundException;
import com.neosoft.dto.UserDTO;
import com.neosoft.entity.ErrorEntity;
import com.neosoft.entity.SuccessEntity;
import com.neosoft.entity.User;
import com.neosoft.repository.UserRepository;
import com.neosoft.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private ModelMapper modelMapper;

	// @Autowired
	private UserRepository userrepo;

	public UserServiceImpl(UserRepository userrepo) {

		this.userrepo = userrepo;
	}

	@SuppressWarnings("unused")
	@Override
	public ResponseEntity<?> saveUserDetails(UserDTO userDTO) {

		User user = modelMapper.map(userDTO, User.class);
		user.setCreated(LocalDateTime.now());
		user.setStatus(Boolean.TRUE);
		SuccessEntity success = new SuccessEntity(LocalDateTime.now(), Constant.SAVE_DETAILS, HttpStatus.OK.value());
		ErrorEntity errEntity = new ErrorEntity(LocalDateTime.now(), Constant.NOT_SAVED, Constant.NOT_SAVED_ERROR,
				HttpStatus.BAD_REQUEST.value());
		if (user != null) {
			userrepo.save(user);
			return new ResponseEntity<SuccessEntity>(success, HttpStatus.OK);
		} else {
			return new ResponseEntity<ErrorEntity>(errEntity, HttpStatus.BAD_REQUEST);
		}

	}

	@Override
	public List<User> getAllUsers() {

		return userrepo.findAll();
	}

	@Override
	public User getUserById(Integer id) {
		Optional<User> user = userrepo.findById(id);
		if (user.isPresent()) {
			return user.get();
		} else {
			throw new DataNotFoundException(Constant.DATA_NOT_FOUND);
		}
	}

	@Override
	public ResponseEntity<?> deleteUserById(Integer id) {
		SuccessEntity success = new SuccessEntity(LocalDateTime.now(), Constant.DATA_DELETED, HttpStatus.OK.value());
		Optional<User> user = userrepo.findById(id);
		if (user.isPresent()) {
			userrepo.softDelete(id);
			//userrepo.deleteById(id);
			return new ResponseEntity<SuccessEntity>(success, HttpStatus.OK);
		} else {
			throw new DataNotFoundException(Constant.DATA_NOT_FOUND);
		}
	}
	@Override
	public ResponseEntity<?> updateUserDetailsById(Integer id, UserDTO userDTO) {
		Optional<User> user = userrepo.findById(id);
		SuccessEntity success = new SuccessEntity(LocalDateTime.now(), Constant.DATA_UPDATED, HttpStatus.OK.value());
		if (user.isPresent()) {
			User user2 = user.get();
			user2.setModified();
			user2.setStatus(Boolean.TRUE);
			modelMapper.map(userDTO, user2);
			userrepo.save(user2);
			return new ResponseEntity<SuccessEntity>(success, HttpStatus.OK);
		} else {
			throw new DataNotFoundException(Constant.DATA_NOT_FOUND);
		}
	}
	
	/*
	 * @Override public Optional<User> getUserByName(String name) {
	 * 
	 * return userrepo.findByName(name); }
	 */
	
	
	/* @Override public UserDetails loadUserByUsername(String username) throws
	  UsernameNotFoundException { 
		  Optional<User> user = getUserByName(username);
		  List<SimpleGrantedAuthority> roles= null;
	  if(user.isEmpty()) { 
		  throw new
	  DataNotFoundException(Constant.DATA_NOT_FOUND); 
		  } 
	  User user2 = user.get();
	  roles=Arrays.asList(new SimpleGrantedAuthority("ROLE_ADMIN"));
	  return new org.springframework.security.core.userdetails.User (username,user2.getPassword(),Arrays.asList(new SimpleGrantedAuthority("ADMIN"))
			  .stream().collect(Collectors.toList())); 
	  }
	*/
}