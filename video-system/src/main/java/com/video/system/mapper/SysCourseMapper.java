package com.video.system.mapper;

import com.video.system.domain.SysCourse;
import com.video.system.domain.SysCourseClass;

import java.util.List;

/**
 * <p>
 * (课程表) Mapper 接口
 * </p>
 *
 * @author Du Yi Code
 * @since 2020-07-28
 */
public interface SysCourseMapper {

    /**
     * 添加课程信息
     * @param sysCourse
     * @return
     */
    public int saveCourseInfo(SysCourse sysCourse);

    /**
     * 通过课程类型ID查找课程信息
     * @param classid
     * @return
     */
    public int selectCourseByClassId(Long classid);
    /**
     * 查询课程
     * @param sysCourse
     * @return
     */
    public List<SysCourse> selectCourseList(SysCourse sysCourse);


}
