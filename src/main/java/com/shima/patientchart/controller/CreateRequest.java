package com.shima.patientchart.controller;

public class CreateRequest {//Postmanからrequestを受け取るコード

    private String address;
    private String insuranCecard;
    private String medicalHistory;

    public CreateRequest(String address, String insurancecard, String medicalhistory) {
        this.address = address;
        this.insuranCecard = insurancecard;
        this.medicalHistory = medicalhistory;
    }

    public String getAddress() {

        return address;
    }

    public String getInsuranCecard() {

        return insuranCecard;
    }

    public String getMedicalHistory() {

        return medicalHistory;
    }
}