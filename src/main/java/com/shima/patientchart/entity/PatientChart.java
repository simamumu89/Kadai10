package com.shima.patientchart.entity;

import com.shima.patientchart.service.PatientChartService;

public class PatientChart {//Entity

    private int id;
    private String name;
    private String gender;
    private String address;
    private String insurancecard;
    private String medicalhistory;

    public PatientChart(int id, String name, String gender, String address, String insurancecard, String medicalhistory) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.address = address;
        this.insurancecard = insurancecard;
        this.medicalhistory = medicalhistory;
    }

    public int getId() {

        return id;
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
