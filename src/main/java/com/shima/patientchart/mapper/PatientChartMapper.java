package com.shima.patientchart.mapper;

import com.shima.patientchart.entity.PatientChart;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Optional;

@Mapper
public interface PatientChartMapper {

    //全DBの情報を取得
    @Select("SELECT * FROM patientcharts")
    List<PatientChart> findAll();

    //GET　指定したid
    @Select("SELECT * FROM patientcharts WHERE id = #{id}")//患者カルテ選択からどこでID
    Optional<PatientChart> findById(int id);

    //POST処理
    @Insert("INSERT INTO patientcharts (name, gender, address, insurancecard, medicalhistory) VALUES (#{name},#{gender},#{address}, #{insurancecard}, #{medicalhistory})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    void insert(PatientChart patientChart);

    @Update("UPDATE patientcharts SET address = #{address}, insurancecard = #{insurancecard}, medicalhistory = #{medicalhistory} WHERE id = #{id}")
    void update(PatientChart patientChart);
}

