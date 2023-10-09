package com.shima.patientchart.service;

import com.shima.patientchart.UserNotFoundException;
import com.shima.patientchart.entity.PatientChart;
import com.shima.patientchart.mapper.PatientChartMapper;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PatientChartService {

    private PatientChartMapper patientchartMapper;
    private com.shima.patientchart.mapper.PatientChartMapper PatientChartMapper;

    public PatientChartService(PatientChartMapper patientchartMapper) {

        this.patientchartMapper = patientchartMapper;
    }

    public Optional<PatientChart> findAllPatientChart(int id) {//患者チャート ID の検索
        Optional<PatientChart> patientcharts = patientchartMapper.findById();//患者チャートのリストを患者チャートマッパをすべてを見つける

        return patientcharts;//患者カルテを返All
    }

    public PatientChart findPatientChart(int id) throws UserNotFoundException {
        Optional<PatientChart> PatientChart = this.PatientChartMapper.findById();//IDによる検索オプション
        if (PatientChart.isPresent()) {//もし患者チャートが存在する場合
            return PatientChart.get();
        } else {//それ以外
            throw new UserNotFoundException("user not found");//ユーザーが見つかりませんとUserNotFoundExceptionをスローする
        }
    }
}
