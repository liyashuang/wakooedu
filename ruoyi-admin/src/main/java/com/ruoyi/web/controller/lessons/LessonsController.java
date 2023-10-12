package com.ruoyi.web.controller.lessons;

import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.common.utils.ShiroUtils;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.educationalAdministration.domain.HeadPersonnel;
import com.ruoyi.educationalAdministration.domain.Lessons;
import com.ruoyi.educationalAdministration.service.ICoursewareClassificationEduService;
import com.ruoyi.educationalAdministration.service.ILessonsService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.page.TableDataInfo;

import javax.annotation.Resource;
import java.util.List;
import java.util.Objects;

/**
 * 课件管理Controller
 * 
 * @author wakoo
 * @date 2023-10-07
 */
@Controller
@RequestMapping("/educationalAdministration/lessons")
public class LessonsController extends BaseController
{
    private String prefix = "educationalAdministration/lessons";

    @Resource
    private ILessonsService lessonsService;
    @Resource
    private ICoursewareClassificationEduService iCoursewareClassificationEduService;


    @RequiresPermissions("educationalAdministration:lessons:view")
    @GetMapping()
    public String lessons()
    {
        return prefix + "/lessons";
    }

    /**
     * 查询课件管理列表
     */
    @RequiresPermissions("educationalAdministration:lessons:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(Lessons lessons)
    {
        startPage();
        List<Lessons> list = lessonsService.selectLessonsList(lessons);
        return getDataTable(list);
    }

    /**
     * 导出课件管理列表
     */
    @RequiresPermissions("educationalAdministration:lessons:export")
    @Log(title = "课件管理", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(Lessons lessons)
    {
        List<Lessons> list = lessonsService.selectLessonsList(lessons);
        ExcelUtil<Lessons> util = new ExcelUtil<Lessons>(Lessons.class);
        return util.exportExcel(list, "课件管理数据");
    }

    /**
     * 新增课件管理
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存课件管理
     */
    @RequiresPermissions("educationalAdministration:lessons:add")
    @Log(title = "课件管理", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(Lessons lessons)
    {
        lessons.setCreateBy(ShiroUtils.getLoginName());
        lessons.setUserId(getUserId());
        lessons.setDeptId(getSysUser().getDeptId());
        return toAjax(lessonsService.insertLessons(lessons));
    }

    /**
     * 修改课件管理
     */
    @RequiresPermissions("educationalAdministration:lessons:edit")
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        Lessons lessons = lessonsService.selectLessonsById(id);
        mmap.put("lessons", lessons);
        return prefix + "/edit";
    }

    /**
     * 修改保存课件管理
     */
    @RequiresPermissions("educationalAdministration:lessons:edit")
    @Log(title = "课件管理", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(Lessons lessons)
    {
        lessons.setUpdateBy(ShiroUtils.getLoginName());
        lessons.setUpdateTime(DateUtils.getNowDate());
        return toAjax(lessonsService.updateLessons(lessons));
    }

    /**
     * 删除课件管理
     */
    @RequiresPermissions("educationalAdministration:lessons:remove")
    @Log(title = "课件管理", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(lessonsService.deleteLessonsByIds(ids));
    }

    @GetMapping("/getsTheParentClassClassification")
    @ResponseBody
    public AjaxResult getsTheParentClassClassification(){
        return AjaxResult.success(lessonsService.queryAllParentClasses());
    }

    @GetMapping("/queryOrderAndParentClass")
    @ResponseBody
    public AjaxResult queryOrderAndParentClass(Integer num){
        if (num != 1){
            return AjaxResult.success(lessonsService.querySuperclass());
        }else {
            return AjaxResult.success(lessonsService.queryAllOrder());
        }
    }

    @GetMapping("/getsTheExcludedParentClass")
    @ResponseBody
    public AjaxResult getsTheExcludedParentClass(){
        return AjaxResult.success(iCoursewareClassificationEduService.getsAllTheSuperclassesExceptTheTopLevel());
    }

    /**
     * 校验父类
     * @param lessons *
     * @return *
     */
    @PostMapping("/checkCampusNameUnique")
    @ResponseBody
    public boolean checkCampusNameUnique(Lessons lessons)
    {
        return lessonsService.checkPhoneUnique(lessons);
    }

    @RequestMapping("/less")
    public String less(){
        return prefix + "/lessons";
    }
}
