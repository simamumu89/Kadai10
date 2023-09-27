package com.shima.patientchart;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface PatientChartMapper {

    @Select("SELECT * FROM patients") //
    List<PatientChart> findAll();
}
