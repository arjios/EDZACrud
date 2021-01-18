package com.edza.crud.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.edza.crud.dto.UserDTO;
import com.edza.crud.entities.User;
import com.edza.crud.repositories.UserRepository;
import com.edza.crud.services.exceptions.ResourceNotFoundException;

@Service
public class UserService {
	
	@Autowired
	private UserRepository repository;

	@Transactional(readOnly = true)
	public List<UserDTO> findAll() {
		List<User> list = repository.findAll();
		return list.stream().map(x -> new UserDTO(x)).collect(Collectors.toList());
	}

	@Transactional(readOnly = true)
	public UserDTO findByCodigo(Long codigo) {	
		Optional<User> obj = repository.findById(codigo);
		User entity = obj.orElseThrow(() -> new ResourceNotFoundException("Error na Busca por codigo"));
		return new UserDTO(entity);
	}
	
	@Transactional
	public UserDTO insert(UserDTO dto) {
		User entity = new User();
		entity.setName(dto.getName());
		entity = repository.save(entity);
		return new UserDTO(entity);
	}

	@Transactional
	public UserDTO update(Long codigo, UserDTO dto) {
		try {
			User entity = repository.getOne(codigo);
			entity.setName(dto.getName());
			entity = repository.save(entity);
			return new UserDTO(entity);
		}
		catch(EntityNotFoundException e) {
			throw new ResourceNotFoundException("Codigo " + codigo + " not found for Update");
		}
	}

	public void delete(Long codigo) {
		try {
			repository.deleteById(codigo);
		}
		catch(EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException("Codigo " + codigo + " not found for Delete");
		}
		
	}

}
