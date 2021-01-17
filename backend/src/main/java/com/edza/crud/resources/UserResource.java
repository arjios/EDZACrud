package com.edza.crud.resources;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.edza.crud.entities.User;

@RestController
@RequestMapping(value = "/users")
public class UserResource {
	
	@GetMapping
	public ResponseEntity<List<User>> findAll() {
		List<User> list = new ArrayList<>();
		list.add(new User(1, "Antonio"));
		list.add(new User(2, "José"));
		list.add(new User(3, "João"));
		list.add(new User(4, "Pedro"));
		return ResponseEntity.ok().body(list);
	}

}
