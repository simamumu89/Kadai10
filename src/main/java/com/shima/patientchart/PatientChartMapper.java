package com.shima.patientchart;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Optional;

@Mapper
public interface PatientChartMapper {

    @Select("SELECT * FROM patientcharts")
    List<PatientChart> findAll();
}
