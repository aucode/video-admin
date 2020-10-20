package com.video.system.mapper;

import com.video.system.domain.SysPrices;

import java.util.List;

/**
 * <p>
 * (课程价格表) Mapper 接口
 * </p>
 *
 * @author Du Yi Code
 * @since 2020-07-28
 */
public interface SysPricesMapper {
    public int updateCoursePrices(SysPrices courseClass);
    public int addCoursePrices(SysPrices courseClass);
    public SysPrices selectPricesByPricesId(Long pricesId);

}
