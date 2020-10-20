package com.video.system.service.impl;

import com.video.system.domain.SysChapters;
import com.video.system.mapper.SysChaptersMapper;
import com.video.system.service.SysChaptersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * (章节表) 服务实现类
 * </p>
 *
 * @author Du Yi Code
 * @since 2020-07-28
 */
@Service
public class SysChaptersServiceImpl implements SysChaptersService {
    @Autowired
    private SysChaptersMapper chaptersMapper;

    @Override
    public SysChapters selectChapters(long ids) {
        return chaptersMapper.selectChapters(ids);
    }

    @Override
    public int saveChatersInfoByCourseId(SysChapters chapters) {
        return chaptersMapper.saveChatersInfoByCourseId(chapters);
    }

    @Override
    public List<SysChapters> selectChaptersList(SysChapters chapters) {
        return chaptersMapper.selectChaptersList(chapters);
    }

    @Override
    public Integer delectById(long ids) {
        return chaptersMapper.delectById(ids);
    }


}
