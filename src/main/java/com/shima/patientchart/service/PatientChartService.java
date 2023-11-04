package com.shima.patientchart.service;

import com.shima.patientchart.UserNotFoundException;
import com.shima.patientchart.entity.PatientChart;
import com.shima.patientchart.mapper.PatientChartMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PatientChartService {

    private final PatientChartMapper patientchartMapper;

    public PatientChartService(PatientChartMapper patientchartMapper) {

        this.patientchartMapper = patientchartMapper;
    }

    public List<PatientChart> findAllPatientChart() {//患者チャート ID の検索　　返り値の型
        List<PatientChart> patientCharts = patientchartMapper.findAll();//患者チャートのリストを患者チャートマッパをすべてを見つける

        return patientCharts;//患者カルテを返All
    }
    public PatientChart findById(int id) throws UserNotFoundException {
        return patientchartMapper.findById(id)//指定したIDを返す　
                .orElseThrow(() -> new UserNotFoundException("Patient information not found")); // @ExceptionHandlerに繋げて例外処理
    }
    //Post(登録処理）
    public PatientChart insert(String name, String gender, String address, String insurancecard, String medicalhistory){
        PatientChart patientChart = new PatientChart(null, address, insurancecard, medicalhistory);//コンストラクターと繋がる
        patientchartMapper.insert(patientChart);
        return patientChart;
    }

}
