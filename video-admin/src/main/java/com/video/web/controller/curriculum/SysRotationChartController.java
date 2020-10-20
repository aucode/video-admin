package com.video.web.controller.curriculum;

import com.video.common.config.Global;
import com.video.common.core.controller.BaseController;
import com.video.common.core.domain.AjaxResult;
import com.video.common.core.page.TableDataInfo;
import com.video.common.utils.file.FileUploadUtils;
import com.video.system.domain.SysRotationChart;
import com.video.system.service.SysRotationChartService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * @Project ruoyi
 * @Description: SysRotationChartController
 * @Author Du Yi Code
 * @Explain
 * @Date 2020-08-30 23:01
 */
@Controller
public class SysRotationChartController extends BaseController {
    private String prefix = "curriculum/rotationchar";
    @Autowired
    private SysRotationChartService sysRotationChartService;

    @RequestMapping("rotation/char/v")
    public String rotationChar(){
        return prefix + "/index";
    }
    @PostMapping("rotation/char/list")
    @ResponseBody
    public TableDataInfo list(SysRotationChart sysCourse){
        startPage();
        List<SysRotationChart> list = sysRotationChartService.selectRotationChartList();
        return getDataTable(list);
    }

    @RequestMapping("rotation/char")
    public String rotationAdd(){
        return prefix + "/add";
    }

    @PostMapping("rotation/add")
    @ResponseBody
    public AjaxResult addSave(@RequestParam("file") MultipartFile file) throws IOException
    {

        String filePath = Global.getUploadPath();
        String fileName = FileUploadUtils.upload(filePath, file);
        SysRotationChart rotationChart = new SysRotationChart();
        rotationChart.setUrl(fileName);
        return toAjax(sysRotationChartService.add(rotationChart));

    }
    @RequiresPermissions("curriculum:rotation:remove")
    @PostMapping("rotation/remove")
    @ResponseBody
    public AjaxResult remove(Integer ids)
    {
        String uploadPath = Global.getUploadPath();
        SysRotationChart rotationChart = sysRotationChartService.selectRotationChartById(ids);
        String rotationChartUrl = rotationChart.getUrl();
        File file = new File(uploadPath + rotationChartUrl.substring(15));
        if (file.isFile() && file.exists()) {
            file.delete();
            Integer integer = sysRotationChartService.delectRotationChartById(ids);
            if(integer == 0){
                return error("删除失败。");
            }else {
                return toAjax(1);
            }
        } else {
            return error("文件删除失败。");

        }

    }
}
