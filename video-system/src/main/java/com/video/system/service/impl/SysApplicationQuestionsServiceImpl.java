package com.video.system.service.impl;

import com.video.system.domain.SysApplicationQuestions;
import com.video.system.mapper.SysApplicationQuestionsMapper;
import com.video.system.service.SysApplicationQuestionsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 * (应用题表） 服务实现类
 * </p>
 *
 * @author Du Yi Code
 * @since 2020-07-28
 */
@Service
public class SysApplicationQuestionsServiceImpl implements SysApplicationQuestionsService {
    @Autowired
    private SysApplicationQuestionsMapper applicationQuestionsMapper;

    @Override
    public int addSaveApplicationQuestions(SysApplicationQuestions applicationQuestions) {
        return applicationQuestionsMapper.addSaveApplicationQuestions(applicationQuestions);
    }
}
