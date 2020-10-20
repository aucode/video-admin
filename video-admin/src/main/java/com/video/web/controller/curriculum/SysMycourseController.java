package com.video.web.controller.curriculum;


import com.video.common.core.controller.BaseController;
import com.video.common.core.domain.AjaxResult;
import com.video.common.core.page.TableDataInfo;
import com.video.common.utils.StringUtils;
import com.video.framework.util.ShiroUtils;
import com.video.system.domain.SysMycourse;
import com.video.system.domain.SysShoppingCart;
import com.video.system.domain.SysUser;
import com.video.system.service.SysMycourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * (我的课程) 前端控制器
 * </p>
 *
 * @author Du Yi Code
 * @since 2020-07-28
 */
@Controller
@RequestMapping("/curriculum/mycourse")
public class SysMycourseController extends BaseController {

    private String prefix = "curriculum/mycourse";

    @Autowired
    private SysMycourseService mycourseService;


    @GetMapping()
    public String myCourseIndex(){
        return prefix + "/index";
    }


    @GetMapping("/mycourse")
    public String toMyCourseIndex(ModelMap modelMap){
        SysUser sysUser = ShiroUtils.getSysUser();
        modelMap.put("userid",sysUser.getUserId());
        return prefix + "/mycourse";
    }

    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(Long userId)
    {

        startPage();  // 此方法配合前端完成自动分页
        List<SysMycourse> list = mycourseService.selectMycoursetList(userId);
        return getDataTable(list);
    }

    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(SysMycourse shoppingCart)
    {
        SysUser sysUser = ShiroUtils.getSysUser();
        if(StringUtils.isNotNull(sysUser)){
            return toAjax(mycourseService.addMycourseInfo(shoppingCart));
        }
        return error("未登录，请前往登录！");
    }
}

