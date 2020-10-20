package com.video.system.mapper;

import com.video.system.domain.SysApplicationQuestions;
import com.video.system.domain.SysCourse;
import com.video.system.domain.SysQuestionLibrary;
import com.video.system.domain.SysSelectTopic;

import java.util.List;

/**
 * <p>
 * (题库表) Mapper 接口
 * </p>
 *
 * @author Du Yi Code
 * @since 2020-07-28
 */
public interface SysQuestionLibraryMapper {

    SysQuestionLibrary selectQuestionLibraryById(SysQuestionLibrary questionLibrary);

    List<SysQuestionLibrary> selectQuestionLibraryList(SysQuestionLibrary questionLibrary);

    int addQuestionLibraryInfo(SysQuestionLibrary questionLibrary);

    int editSaveQuestionLibraryInfo(SysQuestionLibrary questionLibrary);

    List<SysQuestionLibrary> getLibraryLists(SysQuestionLibrary questionLibrary);

    List<SysApplicationQuestions> getLibraryapplicationLists(SysQuestionLibrary questionLibrary);


}
