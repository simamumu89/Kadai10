package com.shima.patientchart;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PatientChartController {

    private final PatientChartService patientchartService;

    public PatientChartController(PatientChartService patientChartService) {
        this.patientchartService = patientChartService;
    }

    @GetMapping("/patientcharts")
    public List<PatientChart> getPatientChart(){
        List<PatientChart> patientcharts = patientchartService.getPatientChart();
        return patientcharts;　//Get 取得処理
    }
}
