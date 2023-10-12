package com.ruoyi.web.controller.campus;

import java.util.List;

import com.ruoyi.common.annotation.DataScope;
import com.ruoyi.common.utils.ShiroUtils;
import com.ruoyi.educationalAdministration.domain.Lessons;
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
import com.ruoyi.educationalAdministration.domain.CampusManagement;
import com.ruoyi.educationalAdministration.service.ICampusManagementService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

import javax.servlet.http.HttpServletRequest;

/**
 * 校区管理Controller
 * 
 * @author wakoo
 * @date 2023-09-19
 */
@Controller
@RequestMapping("/educationalAdministration/management")
public class CampusManagementController extends BaseController
{
    private String prefix = "educationalAdministration/management";

    @Autowired
    private ICampusManagementService campusManagementService;

    @RequiresPermissions("educationalAdministration:management:view")
    @GetMapping()
    public String management()
    {
        return prefix + "/management";
    }

    /**
     * 查询校区管理列表
     */
    @RequiresPermissions("educationalAdministration:management:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(CampusManagement campusManagement)
    {
        startPage();
        List<CampusManagement> list = campusManagementService.selectCampusManagementList(campusManagement);
        return getDataTable(list);
    }

    /**
     * 导出校区管理列表
     */
    @RequiresPermissions("educationalAdministration:management:export")
    @Log(title = "校区管理", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(CampusManagement campusManagement)
    {
        List<CampusManagement> list = campusManagementService.selectCampusManagementList(campusManagement);
        ExcelUtil<CampusManagement> util = new ExcelUtil<CampusManagement>(CampusManagement.class);
        return util.exportExcel(list, "校区管理数据");
    }

    /**
     * 新增校区管理
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存校区管理
     */
    @RequiresPermissions("educationalAdministration:management:add")
    @Log(title = "校区管理", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(CampusManagement campusManagement)
    {
        campusManagement.setCreateBy(ShiroUtils.getLoginName());
        campusManagement.setUserId(getUserId());
        campusManagement.setDeptId(getSysUser().getDeptId());
        return toAjax(campusManagementService.insertCampusManagement(campusManagement));
    }

    /**
     * 修改校区管理
     */
    @RequiresPermissions("educationalAdministration:management:edit")
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        CampusManagement campusManagement = campusManagementService.selectCampusManagementById(id);
        mmap.put("campusManagement", campusManagement);
        return prefix + "/edit";
    }

    /**
     * 修改保存校区管理
     */
    @RequiresPermissions("educationalAdministration:management:edit")
    @Log(title = "校区管理", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(CampusManagement campusManagement)
    {
        return toAjax(campusManagementService.updateCampusManagement(campusManagement));
    }

    /**
     * 删除校区管理
     */
    @RequiresPermissions("educationalAdministration:management:remove")
    @Log(title = "校区管理", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(campusManagementService.deleteCampusManagementByIds(ids));
    }


    /**
     * 校验是否唯一
     * @param campusManagement *
     * @return *
     */
    @PostMapping("/checkCampusNameUnique")
    @ResponseBody
    public boolean checkCampusNameUnique(CampusManagement campusManagement)
    {
        return campusManagementService.campusNameUnique(campusManagement);
    }

}
