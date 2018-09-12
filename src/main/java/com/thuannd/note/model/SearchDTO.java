package com.thuannd.note.model;

import java.io.Serializable;

public class SearchDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private String keyWord;

	public SearchDTO() {
		super();
	}

	public String getKeyWord() {
		return keyWord;
	}

	public void setKeyWord(String keyWord) {
		this.keyWord = keyWord;
	}

}
