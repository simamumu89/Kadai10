package com.shima.patientchart.controller;

import com.shima.patientchart.UserNotFoundException;
import com.shima.patientchart.entity.PatientChart;
import com.shima.patientchart.service.PatientChartService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.time.ZonedDateTime;
import java.util.List;
import java.util.Map;

@RestController
public class PatientChartController {

    private final PatientChartService patientchartService;

    public PatientChartController(PatientChartService patientChartService) {
        this.patientchartService = patientChartService;
    }

    @ExceptionHandler(value = UserNotFoundException.class)
    public ResponseEntity<Map<String, String>> handleUserNotFoundException(// UserNotFoundException を処理する
            UserNotFoundException e, HttpServletRequest request) {
        Map<String, String> body = Map.of(
                "timestamp", ZonedDateTime.now().toString(),
                "status", String.valueOf(HttpStatus.NOT_FOUND.value()),
                "error", HttpStatus.NOT_FOUND.getReasonPhrase(),
                "message", e.getMessage(),
                "path", request.getRequestURI());
        return new ResponseEntity<>(body, HttpStatus.NOT_FOUND);
    }//404エラーを返す

    @GetMapping("/patientcharts")
    public List<PatientChart> getAllPatientChart() {
        return patientchartService.findAllPatientChart();// Serviceの返り値を受け取る変数の型
    }//Get 取得処理

    @GetMapping("/patientcharts/{id}")
    public PatientChart getPatientChart(@PathVariable("id") int id) throws UserNotFoundException {
        return patientchartService.findPatientChart(id);//例外ハンドリング
    }

    @PostMapping("/patientcharts")
    public ResponseEntity<CreateResponse> createName(@RequestBody CreateRequest createRequest, UriComponentsBuilder uriComponentsBuilder) {
        URI uri = uriComponentsBuilder.path("/patientcharts/{id}").buildAndExpand(1).toUri();
        return ResponseEntity.created(uri).body(new CreateResponse("create a new patient chart"));
    }//PostmanからRequestを受け取る

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
