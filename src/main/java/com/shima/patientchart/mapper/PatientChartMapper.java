package com.shima.patientchart.mapper;

import com.shima.patientchart.entity.PatientChart;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface PatientChartMapper {

    @Select("SELECT * FROM patientcharts")
    List<PatientChart> findAll();
}
