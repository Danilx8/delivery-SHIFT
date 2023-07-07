package ru.cft.shift.intensive.template.exception;

public class CodeAbleException extends RuntimeException{
    private final int code;


    public CodeAbleException(int code, String message) {
        super(message);
        this.code = code;
    }

    public int getCode() {
        return code;
    }
}
