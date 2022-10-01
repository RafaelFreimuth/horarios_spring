package com.sorteador.horarios.util.response;

import java.io.Serializable;

public class PayloadResponse<T> implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private T data;

	public PayloadResponse() {}
	
	public PayloadResponse(T data) {
		this.data = data;
	}
	
	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}
	
	public static <T> PayloadResponse<T> of(T data) {
		return new PayloadResponse<>(data);
	}
}
