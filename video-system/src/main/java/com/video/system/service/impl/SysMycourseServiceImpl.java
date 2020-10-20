package com.video.system.service.impl;

import com.video.system.domain.SysMycourse;
import com.video.system.domain.SysShoppingCart;
import com.video.system.mapper.SysMycourseMapper;
import com.video.system.service.SysMycourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * (我的课程) 服务实现类
 * </p>
 *
 * @author Du Yi Code
 * @since 2020-07-28
 */
@Service
public class SysMycourseServiceImpl implements SysMycourseService {
    @Autowired
    private SysMycourseMapper mycourseMapper;

    @Override
    public List<SysMycourse> selectMycoursetList(Long userId) {
        return mycourseMapper.selectMycoursetList(userId);
    }

    @Override
    public int addMycourseInfo(SysMycourse mycourse) {
        return mycourseMapper.addMycourseInfo(mycourse);
    }
}
