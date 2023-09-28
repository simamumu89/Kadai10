package com.shima.patientchart;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatientChartService {

    private final PatientChartMapper patientchartMapper;

    public PatientChartService(PatientChartMapper patientchartMapper) {
        this.patientchartMapper = patientchartMapper;
    }

    public List<PatientChart> getPatientChart(){
        List<PatientChart> patientcharts = patientchartMapper.findAll();

        return patientcharts;
    }
}
