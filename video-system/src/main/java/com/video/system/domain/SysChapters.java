package com.video.system.domain;

import com.video.common.core.domain.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * <p>
 * (章节表)
 * </p>
 *
 * @author Du Yi Code
 * @since 2020-07-28
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SysChapters extends BaseEntity {

    private static final long serialVersionUID=1L;

    /**
     * 章节id
     */
      private Long chaptersId;

    /**
     * 章节名称
     */
    private String chaptersName;

    /**
     * 章节路径

     */
    private String chaptersUrl;

    /**
     * 是否需要购买，0:不需要购买，1：需要购买
     */
    private String chaptersPurchase;

    /**
     * 课程id
     */
    private Long courseId;


}
