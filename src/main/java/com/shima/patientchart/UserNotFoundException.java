package com.shima.patientchart;

public class UserNotFoundException extends Throwable {//投げる幅を広げる

    public UserNotFoundException(String message, Throwable cause) {//文字列メッセージと投げられる原因

        super(message, cause);
    }
}
