package com.neosoft.repository;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.neosoft.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
	
	  @Override
	  @Query("from User u where u.status=true and u.userId=:id")
	  Optional<User> findById(Integer id);
	  
	  @Query("update User u set u.status=false where u.userId=:id") 
	  @Modifying
	  @Transactional
	 void softDelete(Integer id);
	  
	  @Query("from User u where u.status=false and u.userName=:name") 
	  User findByName(String name);
	  
	 


}
