package com.video.system.service.impl;

import com.video.system.domain.SysCourse;
import com.video.system.mapper.SysCourseMapper;
import com.video.system.service.SysCourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * (课程表) 服务实现类
 * </p>
 *
 * @author Du Yi Code
 * @since 2020-07-28
 */
@Service
public class SysCourseServiceImpl implements SysCourseService {
    @Autowired
    private SysCourseMapper courseMapper;

    /**
     * 查询课程
     *
     * @param sysCourse
     * @return
     */
    @Override
    public List<SysCourse> selectCourseList(SysCourse sysCourse) {
        return courseMapper.selectCourseList(sysCourse);
    }

    /**
     * 添加课程信息
     *
     * @param sysCourse
     * @return
     */
    @Override
    public int addCourseInfo(SysCourse sysCourse) {
        return courseMapper.saveCourseInfo(sysCourse);
    }
}
