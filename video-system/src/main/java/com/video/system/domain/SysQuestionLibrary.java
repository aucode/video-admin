package com.video.system.domain;

import com.video.common.core.domain.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * <p>
 * (题库表)
 * </p>
 *
 * @author Du Yi Code
 * @since 2020-07-28
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SysQuestionLibrary extends BaseEntity {

    private static final long serialVersionUID=1L;

    /**
     * 题库id
     */
    private Long libraryId;

    /**
     * 题目
     */
    private String title;
    /**
     * 类型id
     */
    private Long classId;

}
