package com.video.system.service;

import com.video.system.domain.SysMycourse;
import com.video.system.domain.SysShoppingCart;

import java.util.List;

/**
 * <p>
 * (我的课程) 服务类
 * </p>
 *
 * @author Du Yi Code
 * @since 2020-07-28
 */
public interface SysMycourseService{

    List<SysMycourse> selectMycoursetList(Long userId);

    int addMycourseInfo(SysMycourse mycourse);

}
