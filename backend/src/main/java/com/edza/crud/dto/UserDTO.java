package com.edza.crud.dto;

import java.io.Serializable;

import com.edza.crud.entities.User;

public class UserDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private int codigo;
	private String name;
	
	public UserDTO() {
	}

	public UserDTO(int codigo, String name) {
		this.codigo = codigo;
		this.name = name;
	}
	
	public UserDTO(User entity) {
		this.codigo = entity.getCodigo();
		this.name = entity.getName();
	}
	
	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
