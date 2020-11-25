package com.neosoft.entity;

import java.time.LocalDateTime;

public class SuccessEntity {
	private LocalDateTime timeStamp;
	private String message;
	private Integer statusCode;
	
	
	public SuccessEntity(LocalDateTime timeStamp, String message,Integer statusCode) {
		this.timeStamp = timeStamp;
		this.message = message;
		this.statusCode = statusCode;
	}
	public LocalDateTime getTimeStamp() {
		return timeStamp;
	}
	public void setTimeStamp(LocalDateTime timeStamp) {
		this.timeStamp = timeStamp;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Integer getStatusCode() {
		return statusCode;
	}
	public void setStatusCode(Integer statusCode) {
		this.statusCode = statusCode;
	}
	
	

}
