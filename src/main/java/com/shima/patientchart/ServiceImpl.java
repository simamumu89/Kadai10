package com.shima.patientchart;

import com.shima.patientchart.entity.PatientChart;
import com.shima.patientchart.mapper.PatientChartMapper;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ServiceImpl {
    private final PatientChartMapper patientChartMapper;

    public ServiceImpl(PatientChartMapper patientChartMapper) {

        this.patientChartMapper = patientChartMapper;
    }

    public PatientChart findPatientChart(int id) throws UserNotFoundException {//ID からユーザーが見つかりませんとスローする
        Optional<PatientChart> patientChart = this.patientChartMapper.findById(id);//ID による検索オプション
        if (patientChart.isPresent()) {//もし患者チャートが存在する場合
            return patientChart.get();//患者チャートを返す
        } else {//それ以外
            throw new UserNotFoundException("user not found");//ユーザーが見つかりませんとUserNotFoundException をスローする
        }
    }
}
