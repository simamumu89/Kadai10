package com.shima.patientchart.mapper;

import com.shima.patientchart.entity.PatientChart;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Optional;

@Mapper
public interface PatientChartMapper {

    @Select("SELECT * FROM patientcharts")
    List<PatientChart> findAll();

    @Select("SELECT * FROM patientcharts WHERE id = #{id}")
    Optional<PatientChart> findById(int id);
}