package com.shima.patientchart.service;

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

    public List<PatientChart> findPatientChart(int id) {
        List<PatientChart> patientcharts = patientchartMapper.findAll();

        return patientcharts;
    }
}
