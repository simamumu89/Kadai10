package com.shima.patientchart;

import com.shima.patientchart.entity.PatientChart;

public class PatientUpdateForm {
    private String address;
    private String insurancecard;
    private String medicalhistory;

    public PatientUpdateForm(String address, String insurancecard, String medicalhistory) {
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
