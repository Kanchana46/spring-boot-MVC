package com.code.webapp2.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.code.webapp2.User;

public interface UserRepo extends CrudRepository<User, Integer>{
	List<User> findByAge(int age);
	
	@Query("from User order by name")
	List<User> findByNameSorted();
}
