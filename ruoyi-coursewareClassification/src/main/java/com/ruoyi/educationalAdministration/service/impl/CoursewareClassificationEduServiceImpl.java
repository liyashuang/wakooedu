package com.ruoyi.educationalAdministration.service.impl;

import java.util.List;

import com.ruoyi.common.constant.UserConstants;
import com.ruoyi.common.core.domain.entity.SysUser;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.common.utils.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.educationalAdministration.mapper.CoursewareClassificationEduMapper;
import com.ruoyi.educationalAdministration.domain.CoursewareClassificationEdu;
import com.ruoyi.educationalAdministration.service.ICoursewareClassificationEduService;
import com.ruoyi.common.core.text.Convert;

import javax.annotation.Resource;

/**
 * 课件分类Service业务层处理
 * 
 * @author wakoo
 * @date 2023-09-26
 */
@Service
public class CoursewareClassificationEduServiceImpl implements ICoursewareClassificationEduService 
{
    @Resource
    private CoursewareClassificationEduMapper coursewareClassificationEduMapper;

    /**
     * 查询课件分类
     * 
     * @param id 课件分类主键
     * @return 课件分类
     */
    @Override
    public CoursewareClassificationEdu selectCoursewareClassificationEduById(Long id)
    {
        return coursewareClassificationEduMapper.selectCoursewareClassificationEduById(id);
    }

    /**
     * 查询课件分类列表
     * 
     * @param coursewareClassificationEdu 课件分类
     * @return 课件分类
     */
    @Override
    public List<CoursewareClassificationEdu> selectCoursewareClassificationEduList(CoursewareClassificationEdu coursewareClassificationEdu)
    {
        return coursewareClassificationEduMapper.selectCoursewareClassificationEduList(coursewareClassificationEdu);
    }

    /**
     * 新增课件分类
     * 
     * @param coursewareClassificationEdu 课件分类
     * @return 结果
     */
    @Override
    public int insertCoursewareClassificationEdu(CoursewareClassificationEdu coursewareClassificationEdu)
    {
        coursewareClassificationEdu.setCreateTime(DateUtils.getNowDate());
        return coursewareClassificationEduMapper.insertCoursewareClassificationEdu(coursewareClassificationEdu);
    }

    /**
     * 修改课件分类
     * 
     * @param coursewareClassificationEdu 课件分类
     * @return 结果
     */
    @Override
    public int updateCoursewareClassificationEdu(CoursewareClassificationEdu coursewareClassificationEdu)
    {
        coursewareClassificationEdu.setUpdateTime(DateUtils.getNowDate());
        return coursewareClassificationEduMapper.updateCoursewareClassificationEdu(coursewareClassificationEdu);
    }

    /**
     * 批量删除课件分类
     * 
     * @param ids 需要删除的课件分类主键
     * @return 结果
     */
    @Override
    public int deleteCoursewareClassificationEduByIds(String ids)
    {
        return coursewareClassificationEduMapper.deleteCoursewareClassificationEduByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除课件分类信息
     * 
     * @param id 课件分类主键
     * @return 结果
     */
    @Override
    public int deleteCoursewareClassificationEduById(Long id)
    {
        return coursewareClassificationEduMapper.deleteCoursewareClassificationEduById(id);
    }

    @Override
    public List<CoursewareClassificationEdu> getsAllParentCategories() {
        return coursewareClassificationEduMapper.getsAllParentCategories();
    }

    @Override
    public List<CoursewareClassificationEdu> getsAllSubclassCourseNames() {
        return coursewareClassificationEduMapper.getsAllSubclassCourseNames();
    }

    @Override
    public List<CoursewareClassificationEdu> getAllOrder() {
        return coursewareClassificationEduMapper.getAllOrder();
    }

    @Override
    public Boolean checkCampusNameUnique(CoursewareClassificationEdu coursewareClassificationEdu) {
        return coursewareClassificationEduMapper.checkCampusNameUnique(coursewareClassificationEdu.getCoursewareName())!=null;
    }

    @Override
    public boolean checkLoginNameUnique(CoursewareClassificationEdu coursewareClassificationEdu) {
        Long userId = StringUtils.isNull(coursewareClassificationEdu.getId()) ? -1L : coursewareClassificationEdu.getId();
        CoursewareClassificationEdu info = coursewareClassificationEduMapper.checkCampusNameUnique(coursewareClassificationEdu.getCoursewareName());
        if (StringUtils.isNotNull(info) && info.getId().longValue() != userId.longValue())
        {
            return UserConstants.NOT_UNIQUE;
        }
        return UserConstants.UNIQUE;
    }

    @Override
    public List<CoursewareClassificationEdu> getsAllTheSuperclassesExceptTheTopLevel() {
        return coursewareClassificationEduMapper.getsAllTheSuperclassesExceptTheTopLevel();
    }


}
