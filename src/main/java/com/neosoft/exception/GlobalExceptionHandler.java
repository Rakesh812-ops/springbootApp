package com.neosoft.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.neosoft.commons.Constant;
import com.neosoft.commons.DataNotFoundException;
import com.neosoft.entity.ErrorEntity;

@ControllerAdvice
public class GlobalExceptionHandler {

	
	/*@ExceptionHandler(RuntimeException .class)
	public ResponseEntity<ErrorEntity> handleRuntTimeException(RuntimeException re){
		ErrorEntity errorType=new ErrorEntity(LocalDateTime.now(), Constant.WENT_WRONG,Constant.WENT_WRONG_ERROR, HttpStatus.INTERNAL_SERVER_ERROR.value());
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorType);
	}*/
	@ExceptionHandler(DataNotFoundException.class)
	public ResponseEntity<ErrorEntity> handleDataNotFoundException(DataNotFoundException def){
		ErrorEntity errorType=new ErrorEntity(LocalDateTime.now(), Constant.DATA_NOT_FOUND,Constant.DATA_NOT_AVAILABLE_ERROR, HttpStatus.NOT_FOUND.value());
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorType);
		
	}
}
