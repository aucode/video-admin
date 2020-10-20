package com.video.system.mapper;

import com.video.system.domain.SysMycourse;

import java.util.List;

/**
 * <p>
 * (我的课程) Mapper 接口
 * </p>
 *
 * @author Du Yi Code
 * @since 2020-07-28
 */
public interface SysMycourseMapper {

    List<SysMycourse> selectMycoursetList(Long userId);

    int addMycourseInfo(SysMycourse mycourse);


}
