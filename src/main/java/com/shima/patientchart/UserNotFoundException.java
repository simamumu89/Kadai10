package com.shima.patientchart;

public class UserNotFoundException extends Throwable {//投げる幅を広げる

    public UserNotFoundException(String message) {//文字列メッセージ

        super(message);
    }
}
