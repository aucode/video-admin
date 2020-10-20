package com.video.web.controller.curriculum;


import com.video.common.config.Global;
import com.video.common.core.controller.BaseController;
import com.video.common.core.domain.AjaxResult;
import com.video.common.core.page.TableDataInfo;
import com.video.common.exception.file.FileNameLengthLimitExceededException;
import com.video.common.exception.file.FileSizeLimitExceededException;
import com.video.common.exception.file.InvalidExtensionException;
import com.video.common.utils.file.FileUploadUtils;
import com.video.common.utils.file.MimeTypeUtils;
import com.video.system.domain.SysChapters;
import com.video.system.service.SysChaptersService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * <p>
 * (章节表) 前端控制器
 * </p>
 *
 * @author Du Yi Code
 * @since 2020-07-28
 */
@Controller
@RequestMapping("/curriculum/chapters")
public class SysChaptersController extends BaseController {
    private String prefix = "curriculum/chapters";

    @Autowired
    private SysChaptersService chaptersService;



    @RequiresPermissions("curriculum:chapter:veiw")
    @GetMapping("/{id}")
    public String courseclass(@PathVariable("id") Long chaptersid,ModelMap mmap){
        mmap.put("chaptersid", chaptersid);
        return prefix + "/chapters";
    }
    @RequiresPermissions("curriculum:chapters:remove")
    @PostMapping("rotation/remove")
    @ResponseBody
    public AjaxResult remove(Long ids)
    {
        String uploadPath = Global.getUploadPath();
        SysChapters sysChapters = chaptersService.selectChapters(ids);
        String chaptersUrl = sysChapters.getChaptersUrl();

        File file = new File(uploadPath+chaptersUrl.substring(15));
        if (file.isFile() && file.exists()) {
            file.delete();
            Integer integer = chaptersService.delectById(ids);
            if(integer == 0){
                return error("删除失败。");
            }else {
                return toAjax(1);
            }
        } else {
            return error("文件删除失败。");

        }

    }

    @GetMapping("/add/{id}")
    public String add(@PathVariable("id") Long chaptersid,ModelMap mmap){
        mmap.put("addchaptersid", chaptersid);
        return prefix + "/add";
    }

    @PostMapping("/uploadFile")
    @ResponseBody
    public AjaxResult uploadFile(@RequestParam("file") MultipartFile file,
                                 SysChapters chapters){
        String extension = FileUploadUtils.getExtension(file);
        if(!FileUploadUtils.getExtension(file).equalsIgnoreCase("mp4")){
            return error("请上传MP4文件...");
        }
        String filePath = Global.getUploadPath();
        String upload = "0";
        try {
            upload = FileUploadUtils.upload(filePath, file, MimeTypeUtils.MEDIA_EXTENSION);
        }catch (IOException e){
            return error("文件上传异常。");
        }catch (FileSizeLimitExceededException e){
            return error("文件过大，小于200M");
        }catch (FileNameLengthLimitExceededException e){
            return error("文件名太长");
        }catch (InvalidExtensionException e){
            return error("文件校验异常");
        }
        chapters.setChaptersUrl(upload);
        return toAjax(chaptersService.saveChatersInfoByCourseId(chapters));
    }
    @RequiresPermissions("curriculum:chapter:list")
    @PostMapping("/list/{id}")
    @ResponseBody
    public TableDataInfo list(@PathVariable("id")Long chaptersid,SysChapters chapters)
    {
        startPage();  // 此方法配合前端完成自动分页
        chapters.setCourseId(chaptersid);
        List<SysChapters> list = chaptersService.selectChaptersList(chapters);
        return getDataTable(list);
    }

}

