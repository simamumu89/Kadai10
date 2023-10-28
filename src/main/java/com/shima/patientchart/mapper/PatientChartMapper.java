package com.shima.patientchart.mapper;

import com.shima.patientchart.entity.PatientChart;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Optional;

@Mapper
public interface PatientChartMapper {

    @Select("SELECT * FROM patient-charts")
    List<PatientChart> findAll();

    @Select("SELECT * FROM patient-charts WHERE id = #{id}")//患者カルテ選択からどこでID
    Optional<PatientChart> findById(int id);

    @Insert("INSERT INTO patient-charts (address, insurancecard, medicalhistory) VALUES (#{address}, #{insurancecard}, #{medicalhistory}")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    void insert(PatientChart patientChart);
}
