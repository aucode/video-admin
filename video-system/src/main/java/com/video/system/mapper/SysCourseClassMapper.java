package com.video.system.mapper;

import com.video.system.domain.SysCourseClass;

import java.util.List;

/**
 * <p>
 * (课程类型) Mapper 接口
 * </p>
 *
 * @author Du Yi Code
 * @since 2020-07-28
 */
public interface SysCourseClassMapper{
    /**
     * 通过课程类型ID查找课程类型信息
     * @param classid
     * @return
     */
    public SysCourseClass selectCourseClassByCById(Long classid);
    /**
     * 删除课程类型
     * @param classIds
     * @return
     */
    public int deleteCourseClassByCclassIds(Long[] classIds);
    /**
     * 校验课程类型是否唯一
     * @param className
     * @return
     */
    public int checkTypeUnique(String className);

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
     *校验课程类型名称
     * @param className
     * @return
     */
    public SysCourseClass checkCourseClassNameUnique(String className);
    /**
     * 更新课程类型
     * @param courseClass
     * @return
     */
    public int updateCourseClass(SysCourseClass courseClass);

}
