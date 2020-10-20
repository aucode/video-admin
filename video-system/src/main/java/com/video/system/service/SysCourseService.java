package com.video.system.service;


import com.video.system.domain.SysCourse;

import java.util.List;

/**
 * <p>
 * (课程表) 服务类
 * </p>
 *
 * @author Du Yi Code
 * @since 2020-07-28
 */
public interface SysCourseService {
    /**
     * 查询课程
     * @param sysCourse
     * @return
     */
    public List<SysCourse> selectCourseList(SysCourse sysCourse);

    /**
     * 添加课程信息
     * @param sysCourse
     * @return
     */
    public int addCourseInfo(SysCourse sysCourse);

}
