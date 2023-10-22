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
    public Optional<PatientChart> findByIdPatientChart(int id){
        Optional<PatientChart> patientCharts = patientchartMapper.findById(id);
        return patientCharts;//指定したIDを返す
    }

    public PatientChart findPatientChart(int id) throws UserNotFoundException {
        Optional<PatientChart> patientChart = this.patientchartMapper.findById(id);//IDによる検索オプション
        if (patientChart.isPresent()) {//もし患者チャートが存在する場合
            return patientChart.get();
        } else {//それ以外
            throw new UserNotFoundException("user not found");//ユーザーが見つかりませんとUserNotFoundExceptionをスローする
        }
    }
}
