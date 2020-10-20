package com.video.system.mapper;

import com.video.system.domain.SysRotationChart;

import java.util.List;

/**
 * @Project ruoyi
 * @Description: SysRotationChart
 * @Author Du Yi Code
 * @Explain
 * @Date 2020-08-30 22:56
 */
public interface SysRotationChartMapper {

    int add(SysRotationChart sysRotationChart);

    List<SysRotationChart> selectRotationChartList();

    SysRotationChart selectRotationChartById(Integer ids);

    Integer delectRotationChartById(Integer ids);
}
