package com.shima.patientchart.controller;

import jakarta.validation.constraints.NotNull;

//リクエストボディのJsonに対応するJavaのオブジェクト
public class CreateRequest {
    @NotNull
    private String name;
    private String gender;
    @NotNull
    private String address;
    private String insurancecard;
    private String medicalhistory;

    public CreateRequest(String name, String gender, String address, String insurancecard, String medicalhistory) {
        this.name = name;
        this.gender = gender;
        this.address = address;
        this.insurancecard = insurancecard;
        this.medicalhistory = medicalhistory;
    }

    public String getName() {
        return name;
    }

    public String getGender() {
        return gender;
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

