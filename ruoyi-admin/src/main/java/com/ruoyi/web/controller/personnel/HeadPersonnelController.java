package com.ruoyi.web.controller.personnel;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.common.utils.ShiroUtils;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.educationalAdministration.domain.HeadPersonnel;
import com.ruoyi.educationalAdministration.service.IHeadPersonnelService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
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

/**
 * 瓦酷人员管理Controller
 * 
 * @author wakoo
 * @date 2023-09-21
 */
@Controller
@RequestMapping("/educationalAdministration/personnel")
public class HeadPersonnelController extends BaseController
{
    private String prefix = "educationalAdministration/personnel";

    @Resource
    private IHeadPersonnelService headPersonnelService;

    @RequiresPermissions("educationalAdministration:personnel:view")
    @GetMapping()
    public String personnel()
    {
        return prefix + "/personnel";
    }

    /**
     * 查询瓦酷人员管理列表
     */
    @RequiresPermissions("educationalAdministration:personnel:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(HeadPersonnel headPersonnel)
    {
        startPage();
        List<HeadPersonnel> list = headPersonnelService.selectHeadPersonnelList(headPersonnel);
        return getDataTable(list);
    }

    /**
     * 导出瓦酷人员管理列表
     */
    @RequiresPermissions("educationalAdministration:personnel:export")
    @Log(title = "瓦酷人员管理", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(HeadPersonnel headPersonnel)
    {
        List<HeadPersonnel> list = headPersonnelService.selectHeadPersonnelList(headPersonnel);
        ExcelUtil<HeadPersonnel> util = new ExcelUtil<HeadPersonnel>(HeadPersonnel.class);
        return util.exportExcel(list, "瓦酷人员管理数据");
    }

    /**
     * 新增瓦酷人员管理
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存瓦酷人员管理
     */
    @RequiresPermissions("educationalAdministration:personnel:add")
    @Log(title = "瓦酷人员管理", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(@Validated HeadPersonnel headPersonnel, BindingResult result)
    {
        String[] s = headPersonnel.getAddUsers().trim().split("\\s+");
        String lastElement = s[s.length - 1].trim();
        s[s.length - 1] = lastElement;
        List<HeadPersonnel> list=new ArrayList<>();
        for (int i = 0; i < s.length; i += 4) {
            if (i + 3 < s.length) {
                String name = s[i];
                String phone = s[i + 1];
                String sex = s[i + 2];
                String birthday = s[i + 3];
                if (!birthday.matches("\\d{4}-\\d{1,2}-\\d{1,2}")) {
                    return error("输入格式错误，请按照 '用户名 手机号 性别(男/女) 生日(2001-6-25)' 的格式输入数据");
                }
                String[] dateParts = birthday.split("-");
                int day = Integer.parseInt(dateParts[2]);
                // 验证日期是否大于31
                if (day > 31) {
                    return error("生日日期无效，不能大于31");
                }
                HeadPersonnel head = new HeadPersonnel();
                head.setName(name);
                head.setPhone(phone);
                head.setSex(sex);
                head.setBirthday(birthday);
                head.setCampusName(headPersonnel.getCampusName());
                head.setPersonStatus(headPersonnel.getPersonStatus());
                head.setCampusUserRelation(headPersonnel.getCampusUserRelation());
                head.setRemark(headPersonnel.getRemark());
                head.setUserId(getUserId());
                head.setDeptId(getSysUser().getDeptId());
                head.setCreateTime(DateUtils.getNowDate());
                head.setCreateBy(ShiroUtils.getLoginName());
                list.add(head);
            }
        }
        for (int i=0;i<list.size();i++) {
            if (!isValidPhoneNumber(list.get(i).getPhone())){
                return error("新增瓦酷人员'" + list.get(i).getPhone() +"'手机号码格式不正确，请输入有效的手机号码");
            }
            for (int j=i+1;j< list.size(); j++){
                if (list.get(i).getPhone().equals(list.get(j).getPhone())){
                    return error("新增瓦酷人员'" + list.get(j).getPhone() + "'手机号码重复，请检查后再确认");
                }
            }
            if (headPersonnelService.queryMobilePhoneNumberexistenceOrNot(list.get(i).getPhone()))
            {
                return error("新增瓦酷人员'" + list.get(i).getPhone() + "'手机号码已存在");
            }
        }
        return toAjax(headPersonnelService.insertHeadPersonnel(list));
    }

    public boolean isValidPhoneNumber(String phoneNumber) {
        // 定义手机号码的正则表达式
        String regex = "^(?:(?:\\+|00)86)?1[3-9]\\d{9}$";

        // 编译正则表达式
        Pattern pattern = Pattern.compile(regex);

        // 检查手机号码是否匹配正则表达式
        Matcher matcher = pattern.matcher(phoneNumber);

        return matcher.matches() && phoneNumber.length() == 11;
    }

    /**
     * 修改瓦酷人员管理
     */
    @RequiresPermissions("educationalAdministration:personnel:edit")
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        HeadPersonnel headPersonnel = headPersonnelService.selectHeadPersonnelById(id);
        mmap.put("headPersonnel", headPersonnel);
        return prefix + "/edit";
    }

    /**
     * 修改保存瓦酷人员管理
     */
    @RequiresPermissions("educationalAdministration:personnel:edit")
    @Log(title = "瓦酷人员管理", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(HeadPersonnel headPersonnel)
    {
        return toAjax(headPersonnelService.updateHeadPersonnel(headPersonnel));
    }

    /**
     * 删除瓦酷人员管理
     */
    @RequiresPermissions("educationalAdministration:personnel:remove")
    @Log(title = "瓦酷人员管理", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(headPersonnelService.deleteHeadPersonnelByIds(ids));
    }

    /**
     *查询校区 列表
     * @param headPersonnel *
     * @return *
     */
    @GetMapping( "/searchCampus")
    @ResponseBody
    public AjaxResult searchCampus(HeadPersonnel headPersonnel) {
        return AjaxResult.success("查询成功",headPersonnelService.queryPersonnelList(headPersonnel));
    }

    /**
     *查询列表中的校区
     * @param headPersonnel *
     * @return *
     */
    @GetMapping( "/searchCampusSelect")
    @ResponseBody
    public AjaxResult searchCampusSelect(HeadPersonnel headPersonnel) {
        return AjaxResult.success("查询成功",headPersonnelService.queriedSchool(headPersonnel));
    }

    /**
     * 查询所有校区
     * @param headPersonnel *
     * @return *
     */
    @GetMapping( "/acquisitionRelation")
    @ResponseBody
    public AjaxResult acquisitionRelation(HeadPersonnel headPersonnel) {
        return AjaxResult.success("查询成功",headPersonnelService.getTheSchoolUserRelationship(headPersonnel));
    }

    /**
     * 查询所有校区关系
     * @param headPersonnel *
     * @return *
     */
    @GetMapping( "/accessToCampusRelations")
    @ResponseBody
    public AjaxResult accessToCampusRelations(HeadPersonnel headPersonnel) {
        return AjaxResult.success("查询成功",headPersonnelService.queryAllCampusRelationships(headPersonnel));
    }

    /**
     * 查询手机号
     * @param headPersonnel *
     * @return *
     */
    @PostMapping("/checkPhoneUnique")
    @ResponseBody
    public boolean checkPhoneUnique(HeadPersonnel headPersonnel)
    {
        return headPersonnelService.checkPhoneUnique(headPersonnel);
    }
}
