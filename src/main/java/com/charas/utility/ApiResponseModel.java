package com.charas.utility;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ApiResponseModel<T> {

	@JsonProperty("data")
	private T data;
	
	@JsonProperty("errors")
	private List<ErrorModel> listError;

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public List<ErrorModel> getListError() {
		return listError;
	}

	public void setListError(List<ErrorModel> listError) {
		this.listError = listError;
	}
	
	
	
}
