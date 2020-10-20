package com.video.system.service.impl;

import com.video.system.domain.SysRotationChart;
import com.video.system.mapper.SysRotationChartMapper;
import com.video.system.service.SysRotationChartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Project ruoyi
 * @Description: SysRotationChartService
 * @Author Du Yi Code
 * @Explain
 * @Date 2020-08-30 22:57
 */
@Service
public class SysRotationChartServiceImpl implements SysRotationChartService {
    @Autowired
    private SysRotationChartMapper sysRotationChartMapper;

    @Override
    public int add(SysRotationChart sysRotationChart) {
        return sysRotationChartMapper.add(sysRotationChart);
    }

    @Override
    public List<SysRotationChart> selectRotationChartList() {
        return sysRotationChartMapper.selectRotationChartList();
    }

    @Override
    public SysRotationChart selectRotationChartById(Integer ids) {
        return sysRotationChartMapper.selectRotationChartById(ids);
    }

    @Override
    public Integer delectRotationChartById(Integer ids) {
        return sysRotationChartMapper.delectRotationChartById(ids);
    }
}
