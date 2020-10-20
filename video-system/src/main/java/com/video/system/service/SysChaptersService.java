package com.video.system.service;

import com.video.system.domain.SysChapters;

import java.util.List;

/**
 * <p>
 * (章节表) 服务类
 * </p>
 *
 * @author Du Yi Code
 * @since 2020-07-28
 */
public interface SysChaptersService {

    SysChapters selectChapters(long ids);

    int saveChatersInfoByCourseId(SysChapters chapters);

    List<SysChapters> selectChaptersList(SysChapters chapters);

    Integer delectById(long ids);

}
