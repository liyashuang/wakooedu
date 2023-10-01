package com.ruoyi.educationalAdministration.domain;


import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 课件分类对象 courseware_classification_edu
 * 
 * @author wakoo
 * @date 2023-09-26
 */
public class CoursewareClassificationEdu extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 课件ID */
    @Excel(name = "课件ID")
    private Long id;

    /** 父级课件名称 */
    @Excel(name = "父级课件名称")
    private String parentCoursewareName;

    /** 课件名称 */
    @Excel(name = "课件名称")
    private String coursewareName;

    /** 课件描述 */
    @Excel(name = "课件描述")
    private String coursewareDescription;

    /** 图片路径 */
    @Excel(name = "图片路径")
    private String imageUrl;

    /** 排序 */
    @Excel(name = "排序")
    private Integer sort;

    /** 删除标记 */
    private String delFlag;

    /** 部门ID */
    private Long deptId;

    /** 用户id */
    private Long userId;

    private String remark;

    /** 状态（0正常 1停用） */
    @Excel(name = "状态", readConverterExp = "0=正常,1=停用")
    private String status;

    public String getDelFlag() {
        return delFlag;
    }

    public void setDelFlag(String delFlag) {
        this.delFlag = delFlag;
    }

    public Long getDeptId() {
        return deptId;
    }

    public void setDeptId(Long deptId) {
        this.deptId = deptId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    @Override
    public String getRemark() {
        return remark;
    }

    @Override
    public void setRemark(String remark) {
        this.remark = remark;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setParentCoursewareName(String parentCoursewareName)
    {
        this.parentCoursewareName = parentCoursewareName;
    }

    public String getParentCoursewareName()
    {
        return parentCoursewareName;
    }
    public void setCoursewareName(String coursewareName) 
    {
        this.coursewareName = coursewareName;
    }

    public String getCoursewareName() 
    {
        return coursewareName;
    }
    public void setCoursewareDescription(String coursewareDescription) 
    {
        this.coursewareDescription = coursewareDescription;
    }

    public String getCoursewareDescription() 
    {
        return coursewareDescription;
    }
    public void setImageUrl(String imageUrl)
    {
        this.imageUrl = imageUrl;
    }

    public String getImageUrl()
    {
        return imageUrl;
    }
    public void setSort(Integer sort)
    {
        this.sort = sort;
    }

    public Integer getSort()
    {
        return sort;
    }
    public void setStatus(String status) 
    {
        this.status = status;
    }

    public String getStatus() 
    {
        return status;
    }

    @Override
    public String toString() {
        return "CoursewareClassificationEdu{" +
                "id=" + id +
                ", parentCoursewareName=" + parentCoursewareName +
                ", coursewareName='" + coursewareName + '\'' +
                ", coursewareDescription='" + coursewareDescription + '\'' +
                ", imageUrl='" + imageUrl + '\'' +
                ", sort=" + sort +
                ", delFlag='" + delFlag + '\'' +
                ", deptId=" + deptId +
                ", userId=" + userId +
                ", remark='" + remark + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
