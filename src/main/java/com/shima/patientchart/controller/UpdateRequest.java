package com.shima.patientchart.controller;

import jakarta.validation.constraints.NotNull;

public class UpdateRequest {
    @NotNull
    private String address;
    private String insurancecard;
    private String medicalhistory;


    //PATCH(既存DBの部分更新）のConstructor
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
