package com.edza.crud.dto;

import java.io.Serializable;

import com.edza.crud.entities.User;

public class UserDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Long codigo;
	private String name;
	
	public UserDTO() {
	}

	public UserDTO(Long codigo, String name) {
		this.codigo = codigo;
		this.name = name;
	}
	
	public UserDTO(User entity) {
		this.codigo = entity.getCodigo();
		this.name = entity.getName();
	}
	
	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
