package com.video.system.service.impl;

import com.video.common.constant.CourseClassConstants;
import com.video.common.core.text.Convert;
import com.video.common.exception.BusinessException;
import com.video.common.utils.StringUtils;
import com.video.system.domain.SysCourseClass;
import com.video.system.mapper.SysCourseClassMapper;
import com.video.system.mapper.SysCourseMapper;
import com.video.system.service.SysCourseClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * (课程类型) 服务实现类
 * </p>
 *
 * @author Du Yi Code
 * @since 2020-07-28
 */
@Service
public class SysCourseClassServiceImpl implements SysCourseClassService {

    @Autowired
    SysCourseClassMapper courseClassMapper;

    @Autowired
    SysCourseMapper courseMapper;

    /**
     * 删除课程类型
     *
     * @param classIds
     * @return
     */
    @Override
    public int deleteCourseClassByCclassIds(String classIds)  throws BusinessException {
        Long[] classids = Convert.toLongArray(classIds);
        for (Long classid : classids)
        {
            SysCourseClass courseClass = selectCourseClassByCById(classid);

            if (selectCourseByClassId(classid) > 0)
            {
                throw new BusinessException(String.format("%1$s已分配,不能删除", courseClass.getClassName()));
            }
        }
        return courseClassMapper.deleteCourseClassByCclassIds(classids);
    }

    /**
     * 校验课程类型是否唯一
     *
     * @param className
     * @return
     */
    @Override
    public String checkTypeUnique(String className) {
        int count = courseClassMapper.checkTypeUnique(className);
        if (count > 0){
            return CourseClassConstants.COURSE_TYPE_NOT_NAME;
        }
        return CourseClassConstants.COURSE_TYPE_NAME;
    }

    /**
     * 保存课程类型信息
     *
     * @param courseClass 课程类型信息
     * @return 结果
     */
    @Override
    public int insertCourseClass(SysCourseClass courseClass) {
        return courseClassMapper.insertCourseClass(courseClass);
    }

    /**
     * 根据条件分页查询类型列表
     *
     * @return 类型信息集合信息
     */
    @Override
    public List<SysCourseClass> selectCourseClassList(SysCourseClass courseClass) {
        return courseClassMapper.selectCourseClassList(courseClass);
    }

    /**
     * 通过课程类型ID查找课程类型信息
     *
     * @param classid
     * @return
     */
    @Override
    public SysCourseClass selectCourseClassByCById(Long classid) {
        return courseClassMapper.selectCourseClassByCById(classid);
    }

    /**
     * 通过课程类型ID查找课程信息
     *
     * @param classid
     * @return
     */
    @Override
    public int selectCourseByClassId(Long classid) {
        return courseMapper.selectCourseByClassId(classid);
    }

    /**
     * 校验课程类型名称
     *
     * @param courseClass
     * @return
     */
    @Override
    public String checkCourseClassNameUnique(SysCourseClass courseClass) {
        SysCourseClass aClass = courseClassMapper.checkCourseClassNameUnique(courseClass.getClassName());

        if (StringUtils.isNotNull(aClass)){
            return CourseClassConstants.COURSE_TYPE_NOT_NAME;
        }
        return CourseClassConstants.COURSE_TYPE_NAME;
    }

    /**
     * 更新课程类型
     *
     * @param courseClass 类型信息
     * @return
     */
    @Override
    public int updateCourseClass(SysCourseClass courseClass) {
        return courseClassMapper.updateCourseClass(courseClass);
    }
}
