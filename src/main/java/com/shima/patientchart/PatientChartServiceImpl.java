package com.shima.patientchart;

import com.shima.patientchart.entity.PatientChart;
import com.shima.patientchart.mapper.PatientChartMapper;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PatientChartServiceImpl {
    private final PatientChartMapper patientChartMapper;

    public PatientChartServiceImpl(PatientChartMapper patientChartMapper) {
        this.patientChartMapper = patientChartMapper;
    }

    public PatientChart findPatientChart(int id) {
        Optional<PatientChart> patientChart = this.patientChartMapper.findById(id);
        return patientChart.get(); //このままだとユーザーが存在しないときにNoSuchElementExceptionになる
    }
}
