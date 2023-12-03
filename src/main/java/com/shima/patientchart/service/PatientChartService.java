package com.shima.patientchart.service;

import com.shima.patientchart.AddressAlreadyExistsException;
import com.shima.patientchart.NameAlreadyExistsException;
import com.shima.patientchart.UserNotFoundException;
import com.shima.patientchart.entity.PatientChart;
import com.shima.patientchart.mapper.PatientChartMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatientChartService {

    private final PatientChartMapper patientChartMapper;

    public PatientChartService(PatientChartMapper patientchartMapper) {
        this.patientChartMapper = patientchartMapper;
    }

    public List<PatientChart> findAllPatientChart() {//患者チャート ID の検索　　返り値の型
        return patientChartMapper.findAll();//患者カルテをすべて返す
    }

    public PatientChart findById(int id) throws UserNotFoundException {
        return patientChartMapper.findById(id)//指定したIDを返す　
                .orElseThrow(() -> new UserNotFoundException("Patient information not found")); // @ExceptionHandlerに繋げて例外処理
    }

    //Post(新規追加登録処理）
    public PatientChart insert(String name, String gender, String address, String insurancecard, String medicalhistory) {
        // addressがすでに存在するかどうかのチェック
        boolean isAddressPresent = this.patientChartMapper.findByAddress(address).isPresent();
        if (isAddressPresent) {
            throw new AddressAlreadyExistsException("Already registered data");
        }
        // nameがすでに存在するかどうかのチェック
        boolean isNamePresent = this.patientChartMapper.findByName(name).isPresent();
        if (isNamePresent) {
            throw new NameAlreadyExistsException("Already registered data");
        }
        PatientChart patientChart = new PatientChart(name, gender, address, insurancecard, medicalhistory);
        patientChartMapper.insert(patientChart);
        return patientChart;
    }

    //PATCH(既存DBの部分更新）
    public void update(int id, String address, String insurancecard, String medicalhistory) {
        patientChartMapper.findById(id)//指定したIDを返す　
                .orElseThrow(() -> new UserNotFoundException("Patient information not found"));
        // addressがすでに存在するかどうかのチェック
        boolean isAddressPresent = this.patientChartMapper.findByAddressExceptId(address, id).isPresent();
        if (isAddressPresent) {
            throw new AddressAlreadyExistsException("Already registered data");
        }
        PatientChart patientChart = new PatientChart(id, address, insurancecard, medicalhistory);
        patientChartMapper.update(patientChart);
    }

    //DELETE(指定したid削除）
    public void delete(int id) {
        patientChartMapper.findById(id)
                .orElseThrow(() -> new UserNotFoundException("Patient information not found"));
        patientChartMapper.delete(id);
    }

}
