package com.video.system.mapper;


import com.video.system.domain.SysSelectOptions;
import com.video.system.domain.SysSelectTopic;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * (选择题选项表) Mapper 接口
 * </p>
 *
 * @author Du Yi Code
 * @since 2020-07-28
 */
public interface SysSelectOptionsMapper {

    int addSaveSelectOptions(@Param("list")List<SysSelectOptions> list);

}
