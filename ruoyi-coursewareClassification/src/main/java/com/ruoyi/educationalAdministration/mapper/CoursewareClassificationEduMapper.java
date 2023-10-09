package com.ruoyi.educationalAdministration.mapper;

import java.util.List;
import com.ruoyi.educationalAdministration.domain.CoursewareClassificationEdu;

/**
 * 课件分类Mapper接口
 * 
 * @author wakoo
 * @date 2023-09-26
 */
public interface CoursewareClassificationEduMapper 
{
    /**
     * 查询课件分类
     * 
     * @param id 课件分类主键
     * @return 课件分类
     */
    public CoursewareClassificationEdu selectCoursewareClassificationEduById(Long id);

    /**
     * 查询课件分类列表
     * 
     * @param coursewareClassificationEdu 课件分类
     * @return 课件分类集合
     */
    public List<CoursewareClassificationEdu> selectCoursewareClassificationEduList(CoursewareClassificationEdu coursewareClassificationEdu);

    /**
     * 新增课件分类
     * 
     * @param coursewareClassificationEdu 课件分类
     * @return 结果
     */
    public int insertCoursewareClassificationEdu(CoursewareClassificationEdu coursewareClassificationEdu);

    /**
     * 修改课件分类
     * 
     * @param coursewareClassificationEdu 课件分类
     * @return 结果
     */
    public int updateCoursewareClassificationEdu(CoursewareClassificationEdu coursewareClassificationEdu);

    /**
     * 删除课件分类
     * 
     * @param id 课件分类主键
     * @return 结果
     */
    public int deleteCoursewareClassificationEduById(Long id);

    /**
     * 批量删除课件分类
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteCoursewareClassificationEduByIds(String[] ids);

    /**
     * 获取所有父分类
     * @return 下级分类ID列表
     */
    public List<CoursewareClassificationEdu> getsAllParentCategories();

    /**
     *  获取所有子分类
     * @return 全部分类ID列表
     */
    public List<CoursewareClassificationEdu> getsAllSubclassCourseNames();

    /**
     * 获取所有顺序
     * @return 顺序
     */
    public List<CoursewareClassificationEdu> getAllOrder();

    /**
     * 查询是否重复课件名称
     * @param name
     * @return
     */
    public CoursewareClassificationEdu checkCampusNameUnique(String name);

    /**
     * 获取所有父分类
     * @return 下级分类ID列表
     */
    public List<CoursewareClassificationEdu> getsAllTheSuperclassesExceptTheTopLevel();
}
