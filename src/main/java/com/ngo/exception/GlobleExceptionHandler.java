package com.ngo.exception;

import java.sql.SQLIntegrityConstraintViolationException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.ngo.payload.ApiResponce;

@RestControllerAdvice
public class GlobleExceptionHandler <filederror> {
	
	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<ApiResponce>ResourceNotFoundException (ResourceNotFoundException ex){
		String message = ex.getMessage();
		ApiResponce api=new ApiResponce(message, false);
		api.setMessage(message);
		return new ResponseEntity<ApiResponce>(api,HttpStatus.BAD_REQUEST);
		
		}
	
	@ExceptionHandler(SQLIntegrityConstraintViolationException.class)
	public ResponseEntity<ApiResponce>SQLIntegrityException(SQLIntegrityConstraintViolationException ex){
		String message = ex.getMessage();
		ApiResponce api=new ApiResponce(message, false);
		api.setMessage(message);
		return new ResponseEntity<ApiResponce>(api,HttpStatus.BAD_REQUEST);
		}
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<Map<String,String>>handleMethodArgumentNotValidException(MethodArgumentNotValidException ex){
		Map<String,String>map=new HashMap();
		ex.getBindingResult().getAllErrors().forEach((error)->{
			String message=error.getDefaultMessage();
			String filedName=((FieldError)error).getField();
			map.put(message, filedName);
		});
	return new ResponseEntity<Map<String,String>>(map,HttpStatus.BAD_REQUEST);
		}
	
	

}
