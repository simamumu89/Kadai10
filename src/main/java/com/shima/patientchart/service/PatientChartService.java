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

    private final PatientChartMapper patientchartMapper;

    public PatientChartService(PatientChartMapper patientchartMapper) {
        this.patientchartMapper = patientchartMapper;
    }

    public List<PatientChart> findAllPatientChart() {//患者チャート ID の検索　　返り値の型
        return patientchartMapper.findAll();//患者カルテをすべて返す
    }

    public PatientChart findById(int id) throws UserNotFoundException {
        return patientchartMapper.findById(id)//指定したIDを返す　
                .orElseThrow(() -> new UserNotFoundException("Patient information not found")); // @ExceptionHandlerに繋げて例外処理
    }

    //Post(新規追加登録処理）
    public PatientChart insert(String name, String gender, String address, String insurancecard, String medicalhistory) {
        // addressがすでに存在するかどうかのチェック
        boolean isAddressPresent = this.patientchartMapper.findByAddress(address).isPresent();
        if (isAddressPresent) {
            throw new AddressAlreadyExistsException("Already registered data");
        }
        // nameがすでに存在するかどうかのチェック
        boolean isNamePresent = this.patientchartMapper.findByName(name).isPresent();
        if (isNamePresent) {
            throw new NameAlreadyExistsException("Already registered data");
        }
        PatientChart patientChart = new PatientChart(name, gender, address, insurancecard, medicalhistory);
        patientchartMapper.insert(patientChart);
        return patientChart;
    }

    //PATCH(
    public void update(int id, String address, String insurancecard, String medicalhistory) {
        PatientChart patientChart = new PatientChart(id, address, insurancecard, medicalhistory);
        patientchartMapper.update(patientChart);
    }

}
