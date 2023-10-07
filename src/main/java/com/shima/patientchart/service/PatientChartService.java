package com.shima.patientchart.service;

import com.shima.patientchart.entity.PatientChart;
import com.shima.patientchart.mapper.PatientChartMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatientChartService {

    private PatientChartMapper patientchartMapper;

    public PatientChartService(PatientChartMapper patientchartMapper) {

        this.patientchartMapper = patientchartMapper;
    }

    public List<PatientChart> findPatientChart(int id) {//患者チャート ID の検索
        List<PatientChart> patientcharts = patientchartMapper.findAll();//患者チャートのリストを患者チャートマッパをすべてを見つける

        return patientcharts;//患者カルテを返す
    }

}
