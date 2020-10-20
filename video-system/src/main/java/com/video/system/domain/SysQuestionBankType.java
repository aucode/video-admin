package com.video.system.domain;

import com.video.common.core.domain.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * <p>
 * 题库类型表
 * </p>
 *
 * @author Du Yi Code
 * @since 2020-07-28
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SysQuestionBankType extends BaseEntity {

    private static final long serialVersionUID=1L;

    /**
     * 题库类id
     */
    private Long questionBankTypeId;

    /**
     * 题库类型表名
     */
    private String questionBankTypeName;


}
