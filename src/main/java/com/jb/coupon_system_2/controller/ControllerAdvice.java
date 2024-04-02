package com.jb.coupon_system_2.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@org.springframework.web.bind.annotation.ControllerAdvice
public class ControllerAdvice {

    @ExceptionHandler(CouponAlreadyExistsException.class)
    public ProblemDetail handleCouponAlreadyExistsException(CouponAlreadyExistsException ex, WebRequest request){
        return ProblemDetail.forStatusAndDetail(HttpStatus.BAD_REQUEST, ex.getMessage());
    }

    public static class CouponAlreadyExistsException extends RuntimeException {
        public CouponAlreadyExistsException(String message) {
            super(message);
        }
    }

    @ExceptionHandler(CustomerAlreadyExistsException.class)
    public ProblemDetail handleCustomerAlreadyExistsException(CustomerAlreadyExistsException ex, WebRequest request){
        return ProblemDetail.forStatusAndDetail(HttpStatus.BAD_REQUEST, ex.getMessage());
    }

    public static class CustomerAlreadyExistsException extends RuntimeException {
        public CustomerAlreadyExistsException(String message) {
            super(message);
        }
    }

    @ExceptionHandler(InvalidDateException.class)
    public ProblemDetail handleInvalidDateException(InvalidDateException ex, WebRequest request){
        return ProblemDetail.forStatusAndDetail(HttpStatus.BAD_REQUEST, ex.getMessage());
    }

    public static class InvalidDateException extends Throwable {
        public InvalidDateException(String message) {
            super(message);
        }
    }

    @ExceptionHandler(InvalidQuantityException.class)
    public ProblemDetail handleInvalidQuantityException(InvalidQuantityException ex, WebRequest request){
        return ProblemDetail.forStatusAndDetail(HttpStatus.BAD_REQUEST, ex.getMessage());
    }

    public static class InvalidQuantityException extends Throwable {
        public InvalidQuantityException(String message) {
            super(message);
        }
    }

    @ExceptionHandler(NoSuchCompanyException.class)
    public ProblemDetail handleNoSuchCompanyException(NoSuchCompanyException ex, WebRequest request){
        return ProblemDetail.forStatusAndDetail(HttpStatus.BAD_REQUEST, ex.getMessage());
    }

    public static class NoSuchCompanyException extends RuntimeException {
        public NoSuchCompanyException(String message) {
            super(message);
        }
    }

    @ExceptionHandler(NoSuchCouponException.class)
    public ProblemDetail handleNoSuchCouponException(NoSuchCouponException ex, WebRequest request){
        return ProblemDetail.forStatusAndDetail(HttpStatus.BAD_REQUEST, ex.getMessage());
    }

    public static class NoSuchCouponException extends RuntimeException {
        public NoSuchCouponException(String message) {
            super(message);
        }
    }

    @ExceptionHandler(NoSuchCustomerException.class)
    public ProblemDetail handleNoSuchCustomerException(NoSuchCustomerException ex, WebRequest request){
        return ProblemDetail.forStatusAndDetail(HttpStatus.BAD_REQUEST, ex.getMessage());
    }

    public static class NoSuchCustomerException extends RuntimeException {
        public NoSuchCustomerException(String message) {
            super(message);
        }
    }
}
