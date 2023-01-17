package com.ty.Hospital_boot.exception;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.ty.Hospital_boot.util.ResponseStructure;

@RestControllerAdvice
public class ApplicationExceptionHandler extends ResponseEntityExceptionHandler{

	@ExceptionHandler(NoSuchIdFoundException.class)
	public  ResponseEntity<ResponseStructure<String>> noSuchIdFoundHandler(NoSuchIdFoundException exception){
		
		ResponseStructure<String> responseStructure=new ResponseStructure<String>();
		ResponseEntity<ResponseStructure<String>> responseEntity=new ResponseEntity<ResponseStructure<String>>(responseStructure,HttpStatus.NOT_FOUND);
		responseStructure.setStatus(HttpStatus.NOT_FOUND.value());
		responseStructure.setMessage("No Such ID is Present");
		responseStructure.setData(exception.getMessage());
		return responseEntity;
	}
	
	
	@ExceptionHandler(NoSuchIdPresentForUpdateException.class)
	public  ResponseEntity<ResponseStructure<String>> noSuchIdPresentForUpdateHandler(NoSuchIdPresentForUpdateException exception){
		
		ResponseStructure<String> responseStructure=new ResponseStructure<String>();
		ResponseEntity<ResponseStructure<String>> responseEntity=new ResponseEntity<ResponseStructure<String>>(responseStructure,HttpStatus.NOT_FOUND);
		responseStructure.setStatus(HttpStatus.NOT_FOUND.value());
		responseStructure.setMessage("No Such Existing Id is present to be Updated");
		responseStructure.setData(exception.getMessage());
		return responseEntity;
	}
	
	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		
		List<ObjectError> errors=ex.getAllErrors(); 
		Map<String,String> map=new LinkedHashMap<String, String>();
		
		for (ObjectError er : errors) {
			String message= er.getDefaultMessage();
			String fieldname=((FieldError)er).getField();
			map.put(fieldname, message);
		}
		ResponseStructure<Map<String,String>> responseStructure= new ResponseStructure<Map<String,String>>();
		responseStructure.setStatus(HttpStatus.BAD_REQUEST.value());
		responseStructure.setMessage("No Proper Input");
		responseStructure.setData(map);
		return new ResponseEntity<>(responseStructure,HttpStatus.BAD_REQUEST);
		
	}

	
}
