package com.edza.crud.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.edza.crud.dto.UserDTO;
import com.edza.crud.entities.User;
import com.edza.crud.repositories.UserRepository;
import com.edza.crud.services.exceptions.EntityNotFoundException;

@Service
public class UserService {
	
	@Autowired
	private UserRepository repository;

	@Transactional(readOnly = true)
	public List<UserDTO> findAll() {
		List<User> list = repository.findAll();
		return list.stream().map(x -> new UserDTO(x)).collect(Collectors.toList());
	}

	public UserDTO findByCodigo(Long codigo) {	
		Optional<User> obj = repository.findById(codigo);
		User entity = obj.orElseThrow(() -> new EntityNotFoundException("Error na Busca por codigo"));
		return new UserDTO(entity);
	}

}
