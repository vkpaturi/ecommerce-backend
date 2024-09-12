package com.project.spring.ecommercebackend.controllerAdvices;

import com.project.spring.ecommercebackend.dtos.exceptionsDTOs.ArithmeticExceptionDTO;
import com.project.spring.ecommercebackend.dtos.exceptionsDTOs.ProductNotFoundExceptionDTO;
import com.project.spring.ecommercebackend.exceptions.ProductNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionHandlers {

    @ExceptionHandler(ArithmeticException.class)
    public ResponseEntity<ArithmeticExceptionDTO> handleArithmeticException(ArithmeticException ex) {
        ArithmeticExceptionDTO dto = new ArithmeticExceptionDTO();
        dto.setMessage(ex.getMessage() + " Some Arithmetic Exception has occurred");
        return new ResponseEntity<>(dto, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(ArrayIndexOutOfBoundsException.class)
    public ResponseEntity<String> handleArrayIndexOutOfBoundsException(ArrayIndexOutOfBoundsException ex) {
        return new ResponseEntity<>("Please do your array indexes correctly", HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(ProductNotFoundException.class)
    public ResponseEntity<ProductNotFoundExceptionDTO> handleProductNotFoundException(ProductNotFoundException ex) {
        ProductNotFoundExceptionDTO dto = new ProductNotFoundExceptionDTO();
        dto.setMessage(ex.getMessage());
        return new ResponseEntity<>(dto, HttpStatus.NOT_FOUND);
    }
}
