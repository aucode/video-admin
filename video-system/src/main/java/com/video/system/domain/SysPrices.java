package com.video.system.domain;

import com.video.common.core.domain.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * <p>
 * (课程价格表)
 * </p>
 *
 * @author Du Yi Code
 * @since 2020-07-28
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SysPrices extends BaseEntity {

    private static final long serialVersionUID=1L;

    /**
     * 课程价格id
     */
    private Long pricesId;

    /**
     * 课程价格

     */
    private Float coutsePrices;

    /**
     * 折扣,0:无折扣，1:有折扣
     */
    private String coutseDiscounted;

    /**
     * 优惠价格,1折，2折 ..........
     */
    private Float discountedPrice;

    /**
     * 课程id

     */
    private Long courseId;


}
