package com.video.web.controller.curriculum;


import com.video.common.config.Global;
import com.video.common.core.controller.BaseController;
import com.video.common.core.domain.AjaxResult;
import com.video.common.core.page.TableDataInfo;
import com.video.common.utils.StringUtils;
import com.video.common.utils.file.FileUploadUtils;
import com.video.framework.util.ShiroUtils;
import com.video.system.domain.SysCourse;
import com.video.system.domain.SysShoppingCart;
import com.video.system.domain.SysUser;
import com.video.system.service.SysShoppingCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

/**
 * <p>
 * (购物车) 前端控制器
 * </p>
 *
 * @author Du Yi Code
 * @since 2020-07-28
 */
@Controller
@RequestMapping("/curriculum/shopping")
public class SysShoppingCartController extends BaseController {
    private String prefix = "curriculum/shopping";

    @Autowired
    private SysShoppingCartService shoppingCartService;

    /**
     * 后台首页
     * @return
     */
    @GetMapping()
    public String cartIndex(){
        return prefix + "/index";
    }

    /**
     * 我的购物车
     * @return
     */
    @GetMapping("/mycart")
    public String toMyCart(ModelMap modelMap){
        SysUser sysUser = ShiroUtils.getSysUser();
        modelMap.put("userid",sysUser.getUserId());
        return prefix + "/mycart";
    }

    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(Long cartId)
    {

        System.out.println(cartId == null);
        startPage();  // 此方法配合前端完成自动分页
        List<SysShoppingCart> list = shoppingCartService.selectShoppingCartList(cartId);
        return getDataTable(list);
    }


    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(SysShoppingCart shoppingCart)
    {
        SysUser sysUser = ShiroUtils.getSysUser();
        if(StringUtils.isNotNull(sysUser)){
            return toAjax(shoppingCartService.addCartInfo(shoppingCart));
        }
        return error("未登录，请前往登录！");
    }
    @PostMapping("/delete")
    @ResponseBody
    public AjaxResult delete(SysShoppingCart shoppingCart)
    {
        SysUser sysUser = ShiroUtils.getSysUser();
        if(StringUtils.isNotNull(sysUser)){
            return toAjax(shoppingCartService.deleteCartInfo(shoppingCart));
        }
        return error("未登录，请前往登录！");
    }


}

