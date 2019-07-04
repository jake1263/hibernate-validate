package com.irish.exception;

import java.util.List;
import java.util.stream.Collectors;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.validation.Valid;

import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.irish.dto.ResultInfo;

@RestControllerAdvice
public class GlobalExceptionHandler {

	//这里处理@RequestBody ，验证不通过抛出的异常
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResultInfo<?> validationErrorHandler(MethodArgumentNotValidException ex) {
        List<String> errorInformation = ex.getBindingResult().getAllErrors()
                .stream()
                .map(ObjectError::getDefaultMessage)
                .collect(Collectors.toList());
        return new ResultInfo<>(400, errorInformation.get(0).toString(), null);
    }
    
  //这里是处理 @PathVariable和@RequestParam  验证不通过抛出的异常
    @ExceptionHandler(ConstraintViolationException.class)
    public ResultInfo<?> validationErrorHandler(ConstraintViolationException ex) {
        List<String> errorInformation = ex.getConstraintViolations()
                .stream()
                .map(ConstraintViolation::getMessage)
                .collect(Collectors.toList());
        return new ResultInfo<>(400, errorInformation.toString(), null);
    }
}