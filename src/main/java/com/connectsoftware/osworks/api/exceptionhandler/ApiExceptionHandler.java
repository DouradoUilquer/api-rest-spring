package com.connectsoftware.osworks.api.exceptionhandler;

import java.time.LocalDateTime;
import java.util.ArrayList;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ApiExceptionHandler extends ResponseEntityExceptionHandler {

	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		var camp = new ArrayList<Problem.Camp>();

		for (ObjectError error : ex.getBindingResult().getAllErrors()) {
			String name = ((FieldError) error).getField();
			String msg = error.getDefaultMessage();

			camp.add(new Problem.Camp(name, msg));
		}

		var problem = new Problem();
		problem.setStatus(status.value());
		problem.setTitle("CAMPOS INVALIDOS");
		problem.setData(LocalDateTime.now());
		problem.setCamp(camp);

		return super.handleExceptionInternal(ex, problem, headers, status, request);
	}
}
