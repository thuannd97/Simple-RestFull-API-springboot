package com.thuannd.note.model;

import java.util.List;

public class ResponseDTO<T> {
	private long totalRecords;
	private List<T> data;

	public long getTotalRecords() {
		return totalRecords;
	}

	public void setTotalRecords(long totalRecords) {
		this.totalRecords = totalRecords;
	}

	public List<T> getData() {
		return data;
	}

	public void setData(List<T> data) {
		this.data = data;
	}

}
