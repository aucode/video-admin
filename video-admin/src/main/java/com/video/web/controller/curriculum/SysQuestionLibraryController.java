package com.video.web.controller.curriculum;


import com.video.common.core.controller.BaseController;
import com.video.common.core.domain.AjaxResult;
import com.video.common.core.page.TableDataInfo;
import com.video.system.domain.SysApplicationQuestions;
import com.video.system.domain.SysCourseClass;
import com.video.system.domain.SysQuestionLibrary;
import com.video.system.domain.SysSelectTopic;
import com.video.system.service.SysApplicationQuestionsService;
import com.video.system.service.SysCourseClassService;
import com.video.system.service.SysQuestionLibraryService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * (题库表) 前端控制器
 * </p>
 *
 * @author Du Yi Code
 * @since 2020-07-28
 */
@Controller
@RequestMapping("/question/library")
public class SysQuestionLibraryController extends BaseController {
    private String prefix = "curriculum/question";
    @Autowired
    private SysQuestionLibraryService questionLibraryService;

    @Autowired
    private SysApplicationQuestionsService applicationQuestionsService;

    @Autowired
    private SysCourseClassService sysCourseClassService;

    @RequiresPermissions("curriculum:library:veiw")
    @GetMapping()
    public String courseclass(){
        return prefix + "/library";
    }

    @GetMapping("/add")
    public String add(ModelMap mmap, SysCourseClass courseClass){
        mmap.put("courseclass", sysCourseClassService.selectCourseClassList(courseClass));
        return prefix + "/add";
    }

    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(SysQuestionLibrary questionLibrary)
    {
        return toAjax(questionLibraryService.addQuestionLibraryInfo(questionLibrary));
    }
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(SysQuestionLibrary questionLibrary)
    {
        startPage();  // 此方法配合前端完成自动分页
        List<SysQuestionLibrary> list = questionLibraryService.selectQuestionLibraryList(questionLibrary);
        return getDataTable(list);
    }

    @GetMapping("/edit/{libraryId}")
    public String edit(@PathVariable("libraryId") Long libraryId,ModelMap mmap)
    {
        SysQuestionLibrary questionLibrary = new SysQuestionLibrary();
        questionLibrary.setLibraryId(libraryId);
        mmap.put("courseclass", sysCourseClassService.selectCourseClassList(null));
        mmap.put("library", questionLibraryService.selectQuestionLibraryById(questionLibrary));
        return prefix + "/edit";
    }

    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(SysQuestionLibrary questionLibrary)
    {
        return toAjax(questionLibraryService.editSaveQuestionLibraryInfo(questionLibrary));
    }

    @GetMapping("/view/title/{id}")
    public String viewTitle(ModelMap mmap, @PathVariable("id") Long libraryId){
        mmap.put("libraryid", libraryId);
        return prefix + "/librarys";
    }

    //选择题
    @GetMapping("librarylist/{id}")
    @ResponseBody
    public TableDataInfo LibraryLists(@PathVariable("id") Long libraryId, SysQuestionLibrary questionLibrary){
        questionLibrary.setLibraryId(libraryId);
        List<SysQuestionLibrary> list = questionLibraryService.getLibraryLists(questionLibrary);
        return getDataTable(list);
    }
    //应用题
    @GetMapping("application/{id}")
    @ResponseBody
    public TableDataInfo application(@PathVariable("id") Long libraryId, SysQuestionLibrary questionLibrary){
        questionLibrary.setLibraryId(libraryId);
        List<SysApplicationQuestions> list = questionLibraryService.getLibraryapplicationLists(questionLibrary);
        return getDataTable(list);
    }
    //选择题
    @GetMapping("/addSelectTopic/{libraryId}")
    public String addSelectTopic(@PathVariable("libraryId") Long libraryId,ModelMap mmap)
    {

        mmap.put("libraryId", libraryId);
        return prefix + "/selecttopic";
    }
    //保存选择题
    @PostMapping("/addSelectTopic")
    @ResponseBody
    public AjaxResult addSaveSelectTopic(SysSelectTopic selectTopic,ModelMap mmap) throws Exception {
        mmap.put("libraryId", selectTopic.getLibraryId());
        return toAjax(questionLibraryService.addSaveSelectTopic(selectTopic));
    }
    //保存应用题
    @PostMapping("/addApplicationQuestions")
    @ResponseBody
    public AjaxResult addSaveApplicationQuestions(SysApplicationQuestions applicationQuestions)
    {
        return toAjax(applicationQuestionsService.addSaveApplicationQuestions(applicationQuestions));
    }
    //应用题
    @GetMapping("/addApplicationQuestions/{libraryId}")
    public String addApplicationQuestions(@PathVariable("libraryId") Long libraryId,ModelMap mmap)
    {

        mmap.put("libraryId", libraryId);
        return prefix + "/applicationquestions";
    }
}

