package com.shima.patientchart.entity;

public class UpdateRequest {
    private String address;
    private String insurancecard;
    private String medicalhistory;

    public UpdateRequest(String address, String insurancecard, String medicalhistory) {
        this.address = address;
        this.insurancecard = insurancecard;
        this.medicalhistory = medicalhistory;
    }

    public String getAddress() {
        return address;
    }

    public String getInsurancecard() {
        return insurancecard;
    }

    public String getMedicalhistory() {
        return medicalhistory;
    }
}
