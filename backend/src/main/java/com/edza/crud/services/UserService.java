package com.edza.crud.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.edza.crud.entities.User;
import com.edza.crud.repositories.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository repository;

	@Transactional(readOnly = true)
	public List<User> findAll() {
		return repository.findAll();
	}
	
}
