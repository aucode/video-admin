package com.video.system.mapper;

import com.video.system.domain.SysChapters;

import java.util.List;

/**
 * <p>
 * (章节表) Mapper 接口
 * </p>
 *
 * @author Du Yi Code
 * @since 2020-07-28
 */
public interface SysChaptersMapper {
    int saveChatersInfoByCourseId(SysChapters chapters);

    List<SysChapters> selectChaptersList(SysChapters chapters);

    SysChapters selectChapters(long ids);


    Integer delectById(long ids);

}
