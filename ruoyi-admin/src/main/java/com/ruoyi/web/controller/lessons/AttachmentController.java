package com.ruoyi.web.controller.lessons;

import java.util.Arrays;
import java.util.List;

import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.common.utils.ShiroUtils;
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
import com.ruoyi.educationalAdministration.domain.Attachment;
import com.ruoyi.educationalAdministration.service.IAttachmentService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * 附件管理Controller
 * 
 * @author wakoo
 * @date 2023-10-10
 */
@Controller
@RequestMapping("/educationalAdministration/attachment")
public class AttachmentController extends BaseController
{
    private String prefix = "educationalAdministration/attachment";

    @Resource
    private IAttachmentService attachmentService;

    @RequiresPermissions("educationalAdministration:attachment:view")
    @GetMapping()
    public String attachment()
    {
        return prefix + "/attachment";
    }

    /**
     * 查询附件管理列表
     */
    @RequiresPermissions("educationalAdministration:attachment:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(Attachment attachment)
    {
        attachment.setLessonsId(attachment.getId());
        attachment.setId(null);
        startPage();
        List<Attachment> list = attachmentService.selectAttachmentList(attachment);
        return getDataTable(list);
    }

    /**
     * 导出附件管理列表
     */
    @RequiresPermissions("educationalAdministration:attachment:export")
    @Log(title = "附件管理", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(Attachment attachment)
    {
        List<Attachment> list = attachmentService.selectAttachmentList(attachment);
        ExcelUtil<Attachment> util = new ExcelUtil<Attachment>(Attachment.class);
        return util.exportExcel(list, "附件管理数据");
    }

    /**
     * 新增附件管理
     */
    @GetMapping("/add")
    public String add(Integer id,ModelMap mmap)
    {
        mmap.put("id", id);
        return prefix + "/add";
    }

    /**
     * 新增保存附件管理
     */
    @RequiresPermissions("educationalAdministration:attachment:add")
    @Log(title = "附件管理", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(Attachment attachment)
    {
        attachment.setCreateBy(ShiroUtils.getLoginName());
        attachment.setUserId(getUserId());
        attachment.setDeptId(getSysUser().getDeptId());
        int i = 0;
        String[] split = attachment.getImage().split(",");
        for (String s : split) {
            attachment.setImage(s);
            String[] fileInfo = s.split("\\.");
            if (fileInfo.length >= 2) {
                attachment.setType(fileInfo[fileInfo.length - 1]);
                i = attachmentService.insertAttachment(attachment);
            }
        }
        return toAjax(i);
    }

    /**
     * 修改附件管理
     */
    @RequiresPermissions("educationalAdministration:attachment:edit")
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        Attachment attachment = attachmentService.selectAttachmentById(id);
        mmap.put("attachment", attachment);
        return prefix + "/edit";
    }

    /**
     * 修改保存附件管理
     */
    @RequiresPermissions("educationalAdministration:attachment:edit")
    @Log(title = "附件管理", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(Attachment attachment)
    {
        attachment.setUpdateBy(ShiroUtils.getLoginName());
        attachment.setUpdateTime(DateUtils.getNowDate());
        int i=0;
        String[] fileInfo = attachment.getImage().split("\\.");
        if (fileInfo.length >= 2) {
            attachment.setType(fileInfo[fileInfo.length - 1]);
            i = attachmentService.updateAttachment(attachment);
        }
        return toAjax(i);
    }

    /**
     * 删除附件管理
     */
    @RequiresPermissions("educationalAdministration:attachment:remove")
    @Log(title = "附件管理", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(attachmentService.deleteAttachmentByIds(ids));
    }


    @RequestMapping("/att")
    public String att(Integer id,ModelMap mmap){
        mmap.put("id", id);
        return prefix + "/attachment";
    }
}
