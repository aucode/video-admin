package com.video.system.service;

import com.video.system.domain.SysRotationChart;
import com.video.system.mapper.SysRotationChartMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @Project ruoyi
 * @Description: SysRotationChartService
 * @Author Du Yi Code
 * @Explain
 * @Date 2020-08-30 22:56
 */

public interface SysRotationChartService {
    int add(SysRotationChart sysRotationChart);

    List<SysRotationChart> selectRotationChartList();

    SysRotationChart selectRotationChartById(Integer ids);

    Integer delectRotationChartById(Integer ids);
}
