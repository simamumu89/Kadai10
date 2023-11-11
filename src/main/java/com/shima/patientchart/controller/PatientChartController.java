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

    public PatientChartController(PatientChartService patientchartService) {
        this.patientchartService = patientchartService;
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

    //GETの実装
    //全件取得の実装
    @GetMapping("/patient-charts")
    public List<PatientChart> getAllPatientChart() {
        return patientchartService.findAllPatientChart();// Serviceの返り値を受け取る変数の型
    }

    //ID検索でデータ取得と例外処理
    @GetMapping("/patient-charts/{id}")
    public PatientChart getPatientChart(@PathVariable("id") int id) throws UserNotFoundException {
        return patientchartService.findById(id);//例外ハンドリング
    }

    //POST
    //新規登録(ID追加）　PostmanからCreateRequestを受け取る
    @PostMapping("/patient-charts")
    public ResponseEntity<CreateResponse> createPatientChart(@RequestBody CreateRequest createRequest, UriComponentsBuilder uriComponentsBuilder) {
        PatientChart patientChart = patientchartService.insert(createRequest.getName(),createRequest.getGender(),createRequest.getAddress(),createRequest.getInsurancecard(),createRequest.getMedicalhistory());
        URI uri = uriComponentsBuilder.path("/patient-charts/{id}").buildAndExpand(1).toUri();
        return ResponseEntity.created(uri).body(new CreateResponse("create a new patient chart"));
    }

    //Postmanから更新を処理する
    @PatchMapping("/patient-charts/{id}")
    public ResponseEntity<UpdateResponse> updatePatientChart(@PathVariable int id, @RequestBody UpdateRequest updateRequest) {
        patientchartService.update(updateRequest.getAddress(),updateRequest.getInsurancecard(),updateRequest.getMedicalhistory());
        UpdateResponse updateResponse = new UpdateResponse("Contents have been updated!!");
        return ResponseEntity.ok(UpdateResponse);
    }

    @DeleteMapping("/patient-charts/{id}")
    public DeleteResponse deleteName(@PathVariable int id) {
        //更新データの削除処理
        return new DeleteResponse("a name is removed!");
    }
}
