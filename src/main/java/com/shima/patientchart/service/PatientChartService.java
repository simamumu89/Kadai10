package com.shima.patientchart.service;

import com.shima.patientchart.UserNotFoundException;
import com.shima.patientchart.entity.PatientChart;
import com.shima.patientchart.mapper.PatientChartMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PatientChartService {

    private PatientChartMapper patientchartMapper;

    public PatientChartService(PatientChartMapper patientchartMapper) {
        this.patientchartMapper = patientchartMapper;
    }

    public List<PatientChart> findAllPatientChart() {//患者チャート ID の検索　　返り値の型
        List<PatientChart> patientcharts = patientchartMapper.findAll();//患者チャートのリストを患者チャートマッパをすべてを見つける

        return patientcharts;//患者カルテを返All
    }
    public Optional<PatientChart> findByIdPatientChart(int id){
        Optional<PatientChart> patientCharts = patientchartMapper.findById();
        return patientCharts;
    }

    public PatientChart findPatientChart(int id) throws UserNotFoundException {
        Optional<PatientChart> PatientChart = this.patientchartMapper.findById();//IDによる検索オプション
        if (PatientChart.isPresent()) {//もし患者チャートが存在する場合
            return PatientChart.get();
        } else {//それ以外
            throw new UserNotFoundException("user not found");//ユーザーが見つかりませんとUserNotFoundExceptionをスローする
        }
    }
}
