package com.shima.patientchart.controller;

import com.shima.patientchart.entity.PatientChart;
import com.shima.patientchart.exception.AddressAlreadyExistsException;
import com.shima.patientchart.exception.NameAlreadyExistsException;
import com.shima.patientchart.exception.UserNotFoundException;
import com.shima.patientchart.service.PatientChartService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.time.ZonedDateTime;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
public class PatientChartController {

    private final PatientChartService patientchartService;

    public PatientChartController(PatientChartService patientChartService) {
        this.patientchartService = patientChartService;
    }

    //GET 指定したIDが存在しない場合
    @ExceptionHandler(value = UserNotFoundException.class)
    public ResponseEntity<Map<String, String>> handleUserNotFoundException(
            UserNotFoundException e, HttpServletRequest request) {
        Map<String, String> body = Map.of(
                "timestamp", ZonedDateTime.now().toString(),
                "status", String.valueOf(HttpStatus.NOT_FOUND.value()),
                "error", HttpStatus.NOT_FOUND.getReasonPhrase(),
                "message", e.getMessage(),
                "path", request.getRequestURI());
        return new ResponseEntity<>(body, HttpStatus.NOT_FOUND);
    }//404エラーを返す


    //POST 既存DBに登録されている情報のValidation
    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, String>> handleMethodArgumentNotValidException(
            MethodArgumentNotValidException e, HttpServletRequest request) {
        Map<String, String> body = Map.of(
                "timestamp", ZonedDateTime.now().toString(),
                "status", String.valueOf(HttpStatus.BAD_REQUEST.value()),
                "error", HttpStatus.BAD_REQUEST.getReasonPhrase(),
                "message", e.getBindingResult().getAllErrors().stream().map(err -> {
                    if (err instanceof FieldError) {
                        return String.format("%s: %s", ((FieldError) err).getField(), err.getDefaultMessage());
                    }
                    return err.toString();
                }).collect(Collectors.joining(", ")),
                "path", request.getRequestURI());
        return new ResponseEntity<>(body, HttpStatus.BAD_REQUEST);
    }//400エラーを返す


    // Addressが既に登録されている場合
    @ExceptionHandler(value = AddressAlreadyExistsException.class)
    public ResponseEntity<Map<String, String>> handleAddressAlreadyExistsException(
            AddressAlreadyExistsException e, HttpServletRequest request) {
        Map<String, String> body = Map.of(
                "timestamp", ZonedDateTime.now().toString(),
                "status", String.valueOf(HttpStatus.BAD_REQUEST.value()),
                "error", HttpStatus.BAD_REQUEST.getReasonPhrase(),
                "message", e.getMessage(),
                "path", request.getRequestURI());
        return new ResponseEntity<>(body, HttpStatus.BAD_REQUEST);
    }//400 エラー


    // Nameが既に登録されている場合
    @ExceptionHandler(value = NameAlreadyExistsException.class)
    public ResponseEntity<Map<String, String>> handleNameAlreadyExistsException(
            NameAlreadyExistsException e, HttpServletRequest request) {
        Map<String, String> body = Map.of(
                "timestamp", ZonedDateTime.now().toString(),
                "status", String.valueOf(HttpStatus.BAD_REQUEST.value()),
                "error", HttpStatus.BAD_REQUEST.getReasonPhrase(),
                "message", e.getMessage(),
                "path", request.getRequestURI());
        return new ResponseEntity<>(body, HttpStatus.BAD_REQUEST);
    }//400 エラー


    //GET
    //全件取得
    @GetMapping("/patient-charts")
    public List<PatientChart> getAllPatientChart() {
        return patientchartService.findAllPatientChart();
    }

    //GET
    //idで指定したデータ取得と例外処理
    @GetMapping("/patient-charts/{id}")
    public PatientChart getPatientChart(@PathVariable("id") int id) throws UserNotFoundException {
        return patientchartService.findById(id);//例外ハンドリング
    }

    //POST (Create)
    //新規登録(ID追加）　Validation追加
    @PostMapping("/patient-charts")
    public ResponseEntity<CreateResponse> createPatientChart(@RequestBody @Valid CreateRequest createRequest, UriComponentsBuilder uriComponentsBuilder) {
        PatientChart patientChart = patientchartService.insert(createRequest.getName(), createRequest.getGender(), createRequest.getAddress(), createRequest.getInsurancecard(), createRequest.getMedicalhistory());
        URI uri = uriComponentsBuilder.path("/patient-charts/{id}").buildAndExpand(patientChart.getId()).toUri();
        return ResponseEntity.created(uri).body(new CreateResponse("create a new patient chart"));
    }

    //PATCH (Update)
    //既存DBの情報を更新　Validation追加
    @PatchMapping("/patient-charts/{id}")
    public ResponseEntity<UpdateResponse> updatePatientChart(@PathVariable int id, @RequestBody @Valid UpdateRequest updateRequest) {
        patientchartService.update(id, updateRequest.getAddress(), updateRequest.getInsurancecard(), updateRequest.getMedicalhistory());
        UpdateResponse updateResponse = new UpdateResponse("Contents have been updated!!");
        return ResponseEntity.ok(updateResponse);
    }

    //Delete
    //idで指定した情報削除
    @DeleteMapping("/patient-charts/{id}")
    public ResponseEntity<DeleteResponse> deletePatientChart(@PathVariable int id) {
        patientchartService.delete(id);
        DeleteResponse deleteResponse = new DeleteResponse("Patient information deleted");
        return ResponseEntity.ok(deleteResponse);
    }
}
