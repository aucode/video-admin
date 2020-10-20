package com.video.system.service;

import com.video.common.exception.BusinessException;
import com.video.system.domain.SysCourse;
import com.video.system.domain.SysCourseClass;

import java.util.List;


/**
 * <p>
 * (课程类型) 服务类
 * </p>
 *
 * @author Du Yi Code
 * @since 2020-07-28
 */
public interface SysCourseClassService {
    /**
     * 删除课程类型
     * @param classIds
     * @return
     */
    public int deleteCourseClassByCclassIds(String classIds) throws BusinessException;
    /**
     * 校验课程类型是否唯一
     * @param className
     * @return
     */
    public String checkTypeUnique(String className);

    /**
     * 保存课程类型信息
     * @param courseClass 课程类型信息
     * @return 结果
     */
    public int insertCourseClass(SysCourseClass courseClass);
    /**
     * 根据条件分页查询类型列表
     *
     * @return 类型信息集合信息
     */
    public List<SysCourseClass> selectCourseClassList(SysCourseClass courseClass);

    /**
     * 通过课程类型ID查找课程类型信息
     * @param classid
     * @return
     */
    public SysCourseClass selectCourseClassByCById(Long classid);

    /**
     * 通过课程类型ID查找课程信息
     * @param classid
     * @return
     */
    public int selectCourseByClassId(Long classid);

    /**
     *校验课程类型名称
     * @param courseClass
     * @return
     */
    public String checkCourseClassNameUnique(SysCourseClass courseClass);

    /**
     * 更新课程类型
     * @param courseClass
     * @return
     */
    public int updateCourseClass(SysCourseClass courseClass);

}
