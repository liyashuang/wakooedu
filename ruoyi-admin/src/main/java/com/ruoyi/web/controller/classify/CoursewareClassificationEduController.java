package com.ruoyi.web.controller.classify;

import java.util.List;

import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.common.utils.ShiroUtils;
import com.ruoyi.common.utils.StringUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.educationalAdministration.domain.CoursewareClassificationEdu;
import com.ruoyi.educationalAdministration.service.ICoursewareClassificationEduService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * 课件分类Controller
 * 
 * @author wakoo
 * @date 2023-09-26
 */
@Controller
@RequestMapping("/educationalAdministration/edu")
public class CoursewareClassificationEduController extends BaseController
{
    private String prefix = "educationalAdministration/edu";

    @Resource
    private ICoursewareClassificationEduService coursewareClassificationEduService;

    @RequiresPermissions("educationalAdministration:edu:view")
    @GetMapping()
    public String edu()
    {
        return prefix + "/edu";
    }

    /**
     * 查询课件分类列表
     */
    @RequiresPermissions("educationalAdministration:edu:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(CoursewareClassificationEdu coursewareClassificationEdu)
    {
        startPage();
        List<CoursewareClassificationEdu> list = coursewareClassificationEduService.selectCoursewareClassificationEduList(coursewareClassificationEdu);
        return getDataTable(list);
    }

    /**
     * 导出课件分类列表
     */
    @RequiresPermissions("educationalAdministration:edu:export")
    @Log(title = "课件分类", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(CoursewareClassificationEdu coursewareClassificationEdu)
    {
        List<CoursewareClassificationEdu> list = coursewareClassificationEduService.selectCoursewareClassificationEduList(coursewareClassificationEdu);
        ExcelUtil<CoursewareClassificationEdu> util = new ExcelUtil<CoursewareClassificationEdu>(CoursewareClassificationEdu.class);
        return util.exportExcel(list, "课件分类数据");
    }

    /**
     * 新增课件分类
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存课件分类
     */
    @RequiresPermissions("educationalAdministration:edu:add")
    @Log(title = "课件分类", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(CoursewareClassificationEdu coursewareClassificationEdu, HttpServletRequest request)
    {
        coursewareClassificationEdu.setCreateBy(ShiroUtils.getLoginName());
        coursewareClassificationEdu.setUserId(getUserId());
        coursewareClassificationEdu.setDeptId(getSysUser().getDeptId());
        return toAjax(coursewareClassificationEduService.insertCoursewareClassificationEdu(coursewareClassificationEdu));
    }

    /**
     * 修改课件分类
     */
    @RequiresPermissions("educationalAdministration:edu:edit")
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        CoursewareClassificationEdu coursewareClassificationEdu = coursewareClassificationEduService.selectCoursewareClassificationEduById(id);
        mmap.put("coursewareClassificationEdu", coursewareClassificationEdu);
        System.out.println(mmap);
        return prefix + "/edit";
    }

    /**
     * 修改保存课件分类
     */
    @RequiresPermissions("educationalAdministration:edu:edit")
    @Log(title = "课件分类", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(CoursewareClassificationEdu coursewareClassificationEdu)
    {
        if (coursewareClassificationEdu.getSort()==null){
            coursewareClassificationEdu.setSort(0);
        }
        coursewareClassificationEdu.setUpdateBy(ShiroUtils.getLoginName());
        coursewareClassificationEdu.setUpdateTime(DateUtils.getNowDate());
        return toAjax(coursewareClassificationEduService.updateCoursewareClassificationEdu(coursewareClassificationEdu));
    }

    /**
     * 删除课件分类
     */
    @RequiresPermissions("educationalAdministration:edu:remove")
    @Log(title = "课件分类", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(coursewareClassificationEduService.deleteCoursewareClassificationEduByIds(ids));
    }

    @GetMapping( "/getsAllParentClasses")
    @ResponseBody
    public AjaxResult getsAllParentClasses()
    {
        return AjaxResult.success("查询成功",coursewareClassificationEduService.getsAllParentCategories());
    }


    @GetMapping( "/getsAllSubclassNames")
    @ResponseBody
    public AjaxResult getsAllSubclassNames()
    {
        return AjaxResult.success("查询成功",coursewareClassificationEduService.getsAllSubclassCourseNames());
    }

    @GetMapping( "/fetchSort")
    @ResponseBody
    public AjaxResult fetchSort()
    {
        return AjaxResult.success("查询成功",coursewareClassificationEduService.getAllOrder());
    }

    @PostMapping ( "/checkCampusNameUnique")
    @ResponseBody
    public Boolean checkCampusNameUnique(CoursewareClassificationEdu coursewareClassificationEdu)
    {
        return coursewareClassificationEduService.checkLoginNameUnique(coursewareClassificationEdu);
    }

}
