package com.shima.patientchart.controller;

import com.shima.patientchart.entity.PatientChart;
import com.shima.patientchart.service.PatientChartService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
public class PatientChartController {

    private final PatientChartService patientchartService;

    public PatientChartController(PatientChartService patientChartService) {
        this.patientchartService = patientChartService;
    }

    @GetMapping("/patientcharts")
    public List<PatientChart> getPatientChart() {
        int id = 0;
        List<PatientChart> patientcharts = patientchartService.findPatientChart(id);
        return patientcharts;
    }//Get 取得処理

    @GetMapping("/patientcharts/{id}")
    public PatientChart getPatientChart(@PathVariable("id") int id) {
        return (PatientChart) patientchartService.findPatientChart(id);//例外ハンドリング
    }

    @PostMapping("/patientcharts")
    public ResponseEntity<CreateResponse> createName(@RequestBody CreateRequest createRequest, UriComponentsBuilder uriComponentsBuilder) {
        URI uri = uriComponentsBuilder.path("/patientcharts/{id}").buildAndExpand(1).toUri();
        return ResponseEntity.created(uri).body(new CreateResponse("create a new patient chart"));
    }//Postmanからrequestを受け取る

    @PatchMapping("/patientcharts/{id}")
    public UpdateResponse updateName(@PathVariable int id, @RequestBody UpdateRequest updateRequest) {
        //Postmanから更新を処理する
        return new UpdateResponse("a name is updated!");
    }

    @DeleteMapping("/patientcharts/{id}")
    public DeleteResponse deleteName(@PathVariable int id) {
        //更新データの削除処理
        return new DeleteResponse("a name is removed!");
    }
}
