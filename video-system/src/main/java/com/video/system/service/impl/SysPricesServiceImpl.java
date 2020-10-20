package com.video.system.service.impl;

import com.video.common.utils.StringUtils;
import com.video.system.domain.SysPrices;
import com.video.system.mapper.SysPricesMapper;
import com.video.system.service.SysPricesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * (课程价格表) 服务实现类
 * </p>
 *
 * @author Du Yi Code
 * @since 2020-07-28
 */
@Service
public class SysPricesServiceImpl implements SysPricesService {
    @Autowired
    private SysPricesMapper pricesMapper;

    @Override
    public int addCoursePrices(SysPrices sysPrices) {
        if(StringUtils.isNotNull(sysPrices) && sysPrices.getPricesId() == null){
            return pricesMapper.addCoursePrices(sysPrices);
        }
        return pricesMapper.updateCoursePrices(sysPrices);
    }

    @Override
    public SysPrices selectPricesByPricesId(Long pricesId) {
        return pricesMapper.selectPricesByPricesId(pricesId);
    }
}
