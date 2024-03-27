package com.jb.coupon_system_2.controller;

public class ControllerAdvice {
    public static class CouponAlreadyExistsException extends RuntimeException {
        public CouponAlreadyExistsException(String message) {
            super(message);
        }
    }

    public static class InvalidDateException extends Throwable {
        public InvalidDateException(String message) {
            super(message);
        }
    }

    public static class InvalidQuantityException extends Throwable {
        public InvalidQuantityException(String message) {
            super(message);
        }
    }

    public static class NoSuchCompanyException extends RuntimeException {
        public NoSuchCompanyException(String message) {
            super(message);
        }
    }

    public static class NoSuchCouponException extends RuntimeException {
        public NoSuchCouponException(String message) {
            super(message);
        }
    }

    public static class NoSuchCustomerException extends RuntimeException {
        public NoSuchCustomerException(String message) {
            super(message);
        }
    }
}
