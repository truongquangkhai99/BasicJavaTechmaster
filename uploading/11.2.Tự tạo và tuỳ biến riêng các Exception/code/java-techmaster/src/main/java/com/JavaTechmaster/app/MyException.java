/*
 * Khoá học Java căn bản + nâng cao, Techmaster Vietnam
 * https://techmaster.vn
 * Author: Mr Nguyen Duc Hoang
 * */
package com.JavaTechmaster.app;

public class MyException extends Exception {
    private final ErrorCode code;
    //constructor
    MyException(String message, ErrorCode code) {
        super(message);
        this.code = code;
    }
    //getter
    public ErrorCode getCode() {
        return code;
    }
}
enum ErrorCode {
    INVALID_PORT_CONFIGURATION,
    WRONG_NAME,
    //...etc
}