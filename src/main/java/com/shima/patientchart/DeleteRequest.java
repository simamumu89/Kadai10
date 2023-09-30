package com.shima.patientchart;

public class DeleteRequest {
    private String message;

    public DeleteRequest(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
