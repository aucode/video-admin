package com.video.system.service;

import com.video.system.domain.SysPrices;

import java.util.List;

/**
 * <p>
 * (课程价格表) 服务类
 * </p>
 *
 * @author Du Yi Code
 * @since 2020-07-28
 */
public interface SysPricesService {
    public int addCoursePrices(SysPrices courseClass);

    public SysPrices selectPricesByPricesId(Long pricesId);
}
