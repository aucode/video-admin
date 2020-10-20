package com.video.system.domain;

import com.video.common.core.domain.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NegativeOrZero;
import java.io.Serializable;

/**
 * <p>
 * (选择题选项表)
 * </p>
 *
 * @author Du Yi Code
 * @since 2020-07-28
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SysSelectOptions extends BaseEntity {

    private static final long serialVersionUID=1L;

    /**
     * 选项id
     */
    private Long optionsId;

    /**
     * 选项

     */
    private String options;

    /**
     * 选择题id

     */
    private Long topicId;


}
