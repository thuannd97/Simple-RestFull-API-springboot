package com.thuannd.note.model;

import java.io.Serializable;

public class SearchUserDTO extends SearchDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;

	private String name;

	public SearchUserDTO() {
		super();
	}

	public SearchUserDTO(Long id) {
		super();
		this.id = id;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
