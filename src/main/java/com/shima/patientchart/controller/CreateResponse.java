package com.shima.patientchart.controller;

public class CreateResponse {

    private String message;

    public CreateResponse(String message) {

        this.message = message;
    }

    public CreateResponse() {

    }

    public String getMessage() {

        return message;
    }
}
