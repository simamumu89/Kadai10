package com.shima.patientchart.exception;

public class UserNotFoundException extends RuntimeException {//投げる幅を広げる

    public UserNotFoundException(String message) {//文字列メッセージ

        super(message);
    }
}
