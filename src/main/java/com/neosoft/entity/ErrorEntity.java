package com.neosoft.entity;

import java.time.LocalDateTime;

public class ErrorEntity {
	
	
	private LocalDateTime timeStamp;
	private String message;
	private String errorMsg;
	private Integer statusCode;
	
	
	public ErrorEntity(LocalDateTime timeStamp, String message, String errorMsg, Integer statusCode) {
		this.timeStamp = timeStamp;
		this.message = message;
		this.errorMsg = errorMsg;
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
	public String getErrorMsg() {
		return errorMsg;
	}
	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}
	public Integer getStatusCode() {
		return statusCode;
	}
	public void setStatusCode(Integer statusCode) {
		this.statusCode = statusCode;
	}
	
	

}
