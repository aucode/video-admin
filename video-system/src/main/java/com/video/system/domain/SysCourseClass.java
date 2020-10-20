package com.video.system.domain;

import com.video.common.core.domain.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * <p>
 * (课程类型)
 * </p>
 *
 * @author Du Yi Code
 * @since 2020-07-28
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SysCourseClass extends BaseEntity {

    private static final long serialVersionUID=1L;

    /**
     * 类型id
     */
    private Long classId;

    /**
     * 类型名称
     */
    private String className;


}
