package com.video.web.controller.curriculum;


import com.video.common.config.Global;
import com.video.common.core.controller.BaseController;
import com.video.common.core.domain.AjaxResult;
import com.video.common.core.page.TableDataInfo;
import com.video.common.utils.file.FileUploadUtils;
import com.video.system.domain.SysCourse;
import com.video.system.domain.SysCourseClass;
import com.video.system.domain.SysUser;
import com.video.system.service.ISysUserService;
import com.video.system.service.SysCourseClassService;
import com.video.system.service.SysCourseService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

/**
 * <p>
 * (课程表) 前端控制器
 * </p>
 *
 * @author Du Yi Code
 * @since 2020-07-28
 */
@Controller
@RequestMapping("/curriculum/course")
public class SysCourseController  extends BaseController {
    private String prefix = "curriculum/course";

    @Autowired
    private SysCourseService sysCourseService;


    @Autowired
    private SysCourseClassService sysCourseClassService;

    @Autowired
    private ISysUserService userService;

    @RequiresPermissions("curriculum:course:veiw")
    @GetMapping()
    public String courseclass(){
        return prefix + "/course";
    }

    /**
     * 新增类型
     */
    @GetMapping("/add")
    public String add(ModelMap mmap, SysCourseClass courseClass, SysUser user){

        mmap.put("courseclass", sysCourseClassService.selectCourseClassList(courseClass));
        mmap.put("user", userService.selectUserList(user));
        return prefix + "/add";
    }

    @RequiresPermissions("curriculum:course:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(SysCourse sysCourse){
        startPage();
        List<SysCourse> list = sysCourseService.selectCourseList(sysCourse);
        return getDataTable(list);
    }

    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(@RequestParam("file") MultipartFile file, SysCourse sysCourse) throws IOException
    {

        String filePath = Global.getUploadPath();
        String fileName = FileUploadUtils.upload(filePath, file);
        sysCourse.setCourseUrl(fileName);
        return toAjax(sysCourseService.addCourseInfo(sysCourse));
    }

}

