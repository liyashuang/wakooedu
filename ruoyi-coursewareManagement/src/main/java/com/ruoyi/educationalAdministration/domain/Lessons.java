package com.ruoyi.educationalAdministration.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 课件管理对象 lessons
 * 
 * @author wakoo
 * @date 2023-10-07
 */
public class Lessons extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 分类管理ID */
    @Excel(name = "分类管理ID")
    private Long id;

    /** 排序 */
    @Excel(name = "排序")
    private Integer sort;

    /** 标题 */
    @Excel(name = "标题")
    private String title;

    /** 教学目标 */
    @Excel(name = "教学目标")
    private String teachingObjectives;

    /** 教学过程 */
    @Excel(name = "教学过程")
    private String teachingProcess;

    /** 分类 */
    @Excel(name = "分类")
    private String classify;

    /** 父类课件 */
    @Excel(name = "父类课件")
    private String parentLessonId;

    /** 状态（0正常 1停用） */
    @Excel(name = "状态", readConverterExp = "0=正常,1=停用")
    private String status;

    /** 用户id */
    @Excel(name = "用户id")
    private Long userId;

    /** 部门id */
    @Excel(name = "部门id")
    private Long deptId;

    @Excel(name = "附件数量")
    private Integer attCount;

    public Integer getAttCount() {
        return attCount;
    }

    public void setAttCount(Integer attCount) {
        this.attCount = attCount;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setSort(Integer sort)
    {
        this.sort = sort;
    }

    public Integer getSort()
    {
        return sort;
    }
    public void setTitle(String title) 
    {
        this.title = title;
    }

    public String getTitle() 
    {
        return title;
    }
    public void setTeachingObjectives(String teachingObjectives) 
    {
        this.teachingObjectives = teachingObjectives;
    }

    public String getTeachingObjectives() 
    {
        return teachingObjectives;
    }
    public void setTeachingProcess(String teachingProcess) 
    {
        this.teachingProcess = teachingProcess;
    }

    public String getTeachingProcess() 
    {
        return teachingProcess;
    }
    public void setClassify(String classify) 
    {
        this.classify = classify;
    }

    public String getClassify() 
    {
        return classify;
    }
    public void setParentLessonId(String parentLessonId)
    {
        this.parentLessonId = parentLessonId;
    }

    public String getParentLessonId()
    {
        return parentLessonId;
    }
    public void setStatus(String status) 
    {
        this.status = status;
    }

    public String getStatus() 
    {
        return status;
    }
    public void setUserId(Long userId) 
    {
        this.userId = userId;
    }

    public Long getUserId() 
    {
        return userId;
    }
    public void setDeptId(Long deptId) 
    {
        this.deptId = deptId;
    }

    public Long getDeptId() 
    {
        return deptId;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("sort", getSort())
            .append("title", getTitle())
            .append("teachingObjectives", getTeachingObjectives())
            .append("teachingProcess", getTeachingProcess())
            .append("classify", getClassify())
            .append("parentLessonId", getParentLessonId())
            .append("status", getStatus())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .append("remark", getRemark())
            .append("userId", getUserId())
            .append("deptId", getDeptId())
            .toString();
    }
}
