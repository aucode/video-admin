package com.video.system.service.impl;

import com.video.common.utils.StringUtils;
import com.video.system.domain.*;
import com.video.system.mapper.SysQuestionLibraryMapper;
import com.video.system.mapper.SysSelectOptionsMapper;
import com.video.system.mapper.SysSelectTopicMapper;
import com.video.system.service.SysQuestionLibraryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * <p>
 * (题库表) 服务实现类
 * </p>
 *
 * @author Du Yi Code
 * @since 2020-07-28
 */
@Service
public class SysQuestionLibraryServiceImpl implements SysQuestionLibraryService {

    @Autowired
    private SysQuestionLibraryMapper questionLibraryMapper;

    @Autowired
    private SysSelectOptionsMapper selectOptionsMapper;

    @Autowired
    private SysSelectTopicMapper selectTopicMapper;


    @Override
    public List<SysQuestionLibrary> selectQuestionLibraryList(SysQuestionLibrary questionLibrary) {
        return questionLibraryMapper.selectQuestionLibraryList(questionLibrary);
    }

    @Override
    public int addQuestionLibraryInfo(SysQuestionLibrary questionLibrary) {
        return questionLibraryMapper.addQuestionLibraryInfo(questionLibrary);
    }

    @Override
    public SysQuestionLibrary selectQuestionLibraryById(SysQuestionLibrary questionLibrary) {
        return questionLibraryMapper.selectQuestionLibraryById(questionLibrary);
    }

    @Override
    public int editSaveQuestionLibraryInfo(SysQuestionLibrary questionLibrary) {
        return questionLibraryMapper.editSaveQuestionLibraryInfo(questionLibrary);
    }

    @Override
    public List<SysQuestionLibrary> getLibraryLists(SysQuestionLibrary questionLibrary) {
        return questionLibraryMapper.getLibraryLists(questionLibrary);
    }

    @Override
    public List<SysApplicationQuestions> getLibraryapplicationLists(SysQuestionLibrary questionLibrary) {
        return questionLibraryMapper.getLibraryapplicationLists(questionLibrary);
    }

    @Override
    @Transactional
    public int addSaveSelectTopic(SysSelectTopic selectTopic) throws Exception{
        //添加选择题
        Long aLong = selectTopicMapper.addSaveSelectTopic(selectTopic);
        //添加选择题选项
        if(aLong == 0){
            throw new RuntimeException("发生异常了..");
        }
        List<SysSelectOptions> selectOptions = selectTopic.getSelectOptions();
        if(StringUtils.isNotNull(selectOptions)){
            selectOptions.forEach(item -> item.setTopicId(selectTopic.getTopicId()));
            int options = selectOptionsMapper.addSaveSelectOptions(selectOptions);
            if(options == 0){
                throw new RuntimeException("发生异常了..");
            }
        }
        return 1;
    }
}
