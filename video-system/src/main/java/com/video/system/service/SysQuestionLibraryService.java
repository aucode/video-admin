package com.video.system.service;

import com.video.system.domain.SysApplicationQuestions;
import com.video.system.domain.SysCourse;
import com.video.system.domain.SysQuestionLibrary;
import com.video.system.domain.SysSelectTopic;

import java.util.List;

/**
 * <p>
 * (题库表) 服务类
 * </p>
 *
 * @author Du Yi Code
 * @since 2020-07-28
 */
public interface SysQuestionLibraryService {
    List<SysQuestionLibrary> selectQuestionLibraryList(SysQuestionLibrary questionLibrary);

    int addQuestionLibraryInfo(SysQuestionLibrary questionLibrary);

    SysQuestionLibrary selectQuestionLibraryById(SysQuestionLibrary questionLibrary);

    int editSaveQuestionLibraryInfo(SysQuestionLibrary questionLibrary);

    List<SysQuestionLibrary> getLibraryLists(SysQuestionLibrary questionLibrary);

    List<SysApplicationQuestions> getLibraryapplicationLists(SysQuestionLibrary questionLibrary);

    int addSaveSelectTopic(SysSelectTopic selectTopic) throws Exception;

}
