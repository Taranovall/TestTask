package com.university.journal.exception;

public class DepartmentNotExistException extends RuntimeException {

    public DepartmentNotExistException(String message) {
        super(message);
    }
}
