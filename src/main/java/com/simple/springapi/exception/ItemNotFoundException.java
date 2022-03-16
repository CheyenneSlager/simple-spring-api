package com.simple.springapi.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value= HttpStatus.NOT_FOUND, reason="Oops! The data you are looking for could not be found.")  // 404
public class ItemNotFoundException extends RuntimeException {

}