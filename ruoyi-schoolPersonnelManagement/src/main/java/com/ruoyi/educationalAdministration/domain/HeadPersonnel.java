package com.ruoyi.educationalAdministration.domain;

import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;


/**
 * 瓦酷人员管理对象 head_personnel
 * 
 * @author wakoo
 * @date 2023-09-21
 */
public class HeadPersonnel extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** ID */
    @Excel(name = "人员ID")
    private Long id;

    /** 姓名 */
    @Excel(name = "姓名")
    private String name;

    /** 手机号 */
    @Excel(name = "手机号")
    private String phone;

    /** 所属校区 */
    @Excel(name = "所属校区")
    private String campusName;

    /** 校区用户关系 */
    @Excel(name = "校区用户关系")
    private String campusUserRelation;

    /** 学员消课概要 */
    @Excel(name = "学员消课概要")
    private String courseSummary;

    /** 状态（0正常 1停用） */
    @Excel(name = "状态", readConverterExp = "0=正常,1=停用")
    private String personStatus;

    /** 删除标记 */
    private String delFlag;

    /** 部门ID */
    private Long deptId;

    /** 用户id */
    private Long userId;

    /**性别*/
    private String sex;

    /**生日*/
    private String birthday;

    /**接收用户信息*/
    private String addUsers;

    private String remark;

    @Override
    public String getRemark() {
        return remark;
    }

    @Override
    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getAddUsers() {
        return addUsers;
    }

    public void setAddUsers(String addUsers) {
        this.addUsers = addUsers;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setName(String name) 
    {
        this.name = name;
    }

    public String getName() 
    {
        return name;
    }
    public void setPhone(String phone) 
    {
        this.phone = phone;
    }

    public String getPhone() 
    {
        return phone;
    }
    public void setCampusName(String campusName)
    {
        this.campusName = campusName;
    }

    public void setCampusUserRelation(String campusUserRelation) {
        this.campusUserRelation = campusUserRelation;
    }

    public void setCourseSummary(String courseSummary) {
        this.courseSummary = courseSummary;
    }

    public String getCampusName()
    {
        return campusName;
    }

    public String getCampusUserRelation()
    {
        return campusUserRelation;
    }

    public String getCourseSummary() 
    {
        return courseSummary;
    }
    public void setPersonStatus(String personStatus) 
    {
        this.personStatus = personStatus;
    }

    public String getPersonStatus() 
    {
        return personStatus;
    }
    public void setDelFlag(String delFlag) 
    {
        this.delFlag = delFlag;
    }

    public String getDelFlag() 
    {
        return delFlag;
    }
    public void setDeptId(Long deptId) 
    {
        this.deptId = deptId;
    }

    public Long getDeptId() 
    {
        return deptId;
    }
    public void setUserId(Long userId) 
    {
        this.userId = userId;
    }

    public Long getUserId() 
    {
        return userId;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("name", getName())
            .append("phone", getPhone())
            .append("campusName", getCampusName())
            .append("campusUserRelation", getCampusUserRelation())
            .append("courseSummary", getCourseSummary())
            .append("personStatus", getPersonStatus())
            .append("delFlag", getDelFlag())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .append("remark", getRemark())
            .append("deptId", getDeptId())
            .append("userId", getUserId())
            .toString();
    }
}
