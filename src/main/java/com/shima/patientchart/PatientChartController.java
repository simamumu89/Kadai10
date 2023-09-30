package com.shima.patientchart;

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
    public List<PatientChart> getPatientChart(){
        List<PatientChart> patientcharts = patientchartService.getPatientChart();
        return patientcharts;
    }//Get 取得処理

    @PostMapping("/patientcharts")
    public ResponseEntity<CreateResponse> createName(@RequestBody CreateRequest createRequest, UriComponentsBuilder uriComponentsBuilder){
        URI uri = uriComponentsBuilder.path("/patientcharts/{id}").buildAndExpand(1).toUri();
        return ResponseEntity.created(uri).body(new CreateResponse("create a new name"));
    }//Postmanからrequestを受け取る

    @PatchMapping("/patientcharts/{id}")
    public UpdateResponse updateName(@PathVariable int id, @RequestBody UpdateRequest updateRequest){
        //Postmanから更新を処理する
        return new UpdateResponse("a name is updated!");
    }
    @DeleteMapping("/patientcharts/{id}")
    public DeleteRequest deleteName(@PathVariable int id){
        //更新データの削除処理
        return new DeleteRequest("a name is removed!");
    }
}
