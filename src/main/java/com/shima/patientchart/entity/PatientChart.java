package com.shima.patientchart.entity;

public class PatientChart {//Entity

    private int id;
    private String name;

    private String gender;

    private String address;
    private String insurancecard;
    private String medicalhistory;


    //GET(全件取得と指定ID）のConstructor
    public PatientChart(int id, String name, String gender, String address, String insurancecard, String medicalhistory) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.address = address;
        this.insurancecard = insurancecard;
        this.medicalhistory = medicalhistory;
    }


    //Post(新規登録処理）のConstructor
    public PatientChart(String name, String gender, String address, String insurancecard, String medicalhistory) {
        this.name = name;
        this.gender = gender;
        this.address = address;
        this.insurancecard = insurancecard;
        this.medicalhistory = medicalhistory;
    }


    //PATCH(既存DBの更新)のUpdateResponseのConstructor
    public PatientChart(int id, String address, String insurancecard, String medicalhistory) {
        this.id = id;
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
