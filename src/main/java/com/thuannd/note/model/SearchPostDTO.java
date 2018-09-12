package com.thuannd.note.model;

import java.io.Serializable;

public class SearchPostDTO extends SearchDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;

	private String title;

	public SearchPostDTO() {
		super();
	}

	public SearchPostDTO(Long id) {
		super();
		this.id = id;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

}
