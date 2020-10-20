package com.video.web.controller.curriculum;


import com.video.common.annotation.Log;
import com.video.common.constant.CourseClassConstants;
import com.video.common.core.controller.BaseController;
import com.video.common.core.domain.AjaxResult;
import com.video.common.core.page.TableDataInfo;
import com.video.common.enums.BusinessType;
import com.video.system.domain.SysCourseClass;
import com.video.system.service.SysCourseClassService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * (课程类型) 前端控制器
 * </p>
 *
 * @author Du Yi Code
 * @since 2020-07-28
 */
@Controller
@RequestMapping("/curriculum/courseclass")
public class SysCourseClassController extends BaseController {

    private String prefix = "curriculum/courseclass";

    @Autowired
    private SysCourseClassService sysCourseClassService;

    @RequiresPermissions("curriculum:courseclass:veiw")
    @GetMapping()
    public String courseclass(){
        return prefix + "/courseclass";
    }

    /**
     * 新增类型
     */
    @GetMapping("/add")
    public String add(ModelMap mmap){
        return prefix + "/add";
    }

    /**
     * 修改课程类型
     */
    @GetMapping("/edit/{classId}")
    public String edit(@PathVariable("classId") Long classId,ModelMap mmap)
    {
        mmap.put("courseclass", sysCourseClassService.selectCourseClassByCById(classId));
        return prefix + "/edit";
    }

    @RequiresPermissions("curriculum:course:edit")
    @Log(title = "课程类型更新", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(@Validated SysCourseClass courseClass){
        return toAjax(sysCourseClassService.updateCourseClass(courseClass));
    }

    /**
     * 校验课程类型名称
     */
    @PostMapping("/checkCourseClassNameUnique")
    @ResponseBody
    public String checkCourseClassNameUnique(SysCourseClass courseClass){
        return sysCourseClassService.checkCourseClassNameUnique(courseClass);
    }

    @RequiresPermissions("curriculum:course:add")
    @Log(title = "类型管理", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(@Validated SysCourseClass courseClass){
        if(CourseClassConstants.COURSE_TYPE_NOT_NAME.equals(sysCourseClassService.checkTypeUnique(courseClass.getClassName()))){
            return error("新增课程类型'" + courseClass.getClassName() + "'失败，课程类型已存在");
        }
        return toAjax(sysCourseClassService.insertCourseClass(courseClass));
    }


    @RequiresPermissions("curriculum:course:remove")
    @Log(title = "课程类型管理",  businessType = BusinessType.DELETE)
    @PostMapping("/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        try
        {
            return toAjax(sysCourseClassService.deleteCourseClassByCclassIds(ids));
        }
        catch (Exception e)
        {
            return error(e.getMessage());
        }
    }


    @RequiresPermissions("curriculum:course:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(SysCourseClass courseClass)
    {
        startPage();  // 此方法配合前端完成自动分页
        List<SysCourseClass> list = sysCourseClassService.selectCourseClassList(courseClass);
        return getDataTable(list);
    }
}