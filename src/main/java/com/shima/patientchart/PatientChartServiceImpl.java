package com.shima.patientchart;

import com.shima.patientchart.entity.PatientChart;
import com.shima.patientchart.mapper.PatientChartMapper;
import com.shima.patientchart.service.PatientChartService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PatientChartServiceImpl {
    private final PatientChartMapper patientChartMapper;

    public PatientChartServiceImpl(PatientChartMapper patientChartMapper) {
        this.patientChartMapper = patientChartMapper;
    }
    public PatientChartService findPatientChart(int id){
        Optional<PatientChart> patientChartServiceImpl = this.patientChartMapper.findById(id);
        return PatientChart.get();// このままだとユーザーが存在しないときにNoSuchElementExceptionになる
    }
}
