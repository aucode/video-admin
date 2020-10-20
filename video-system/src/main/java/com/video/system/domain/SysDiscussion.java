package com.video.system.domain;

import com.video.common.core.domain.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * <p>
 * sys_discussion(讨论表)
 * </p>
 *
 * @author Du Yi Code
 * @since 2020-07-28
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SysDiscussion extends BaseEntity {

    private static final long serialVersionUID=1L;

    /**
     * 讨论id
     */
    private Long mycourseId;

    /**
     * 用户id
     */
    private Long userId;

    /**
     * 课程id
     */
    private Long courseId;

    /**
     * 评论内容
     */
    private String courseDiscussion;


}
