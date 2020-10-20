package com.video.web.controller.curriculum;


import com.video.common.core.controller.BaseController;
import com.video.common.core.domain.AjaxResult;
import com.video.common.utils.StringUtils;
import com.video.system.domain.SysCourseClass;
import com.video.system.domain.SysPrices;
import com.video.system.domain.SysUser;
import com.video.system.service.SysPricesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * (课程价格表) 前端控制器
 * </p>
 *
 * @author Du Yi Code
 * @since 2020-07-28
 */
@Controller
@RequestMapping("/curriculum/prices")
public class SysPricesController extends BaseController {
    private String prefix = "curriculum/course";

    @Autowired
    private SysPricesService pricesService;

    /**
     * 保存课程价格信息
     * @param sysPrices
     * @return
     */
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(SysPrices sysPrices){
        return toAjax(pricesService.addCoursePrices(sysPrices));
    }

    /**
     * 修改价格
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long pricesId,ModelMap mmap){
        SysPrices sysPrices = pricesService.selectPricesByPricesId(pricesId);
        if(StringUtils.isNull(sysPrices)){
            SysPrices prices = new SysPrices();
            prices.setCourseId(pricesId);
            mmap.put("prices",prices);
            return prefix + "/prices";
        }
        mmap.put("prices",sysPrices);
        return prefix + "/prices";
    }

}

