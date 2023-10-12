package com.ruoyi.educationalAdministration.service;

import java.util.List;

import com.ruoyi.educationalAdministration.domain.CoursewareClassificationEdu;
import com.ruoyi.educationalAdministration.domain.Lessons;

/**
 * 课件管理Service接口
 * 
 * @author wakoo
 * @date 2023-10-07
 */
public interface ILessonsService 
{
    /**
     * 查询课件管理
     * 
     * @param id 课件管理主键
     * @return 课件管理
     */
    public Lessons selectLessonsById(Long id);

    /**
     * 查询课件管理列表
     * 
     * @param lessons 课件管理
     * @return 课件管理集合
     */
    public List<Lessons> selectLessonsList(Lessons lessons);

    /**
     * 新增课件管理
     * 
     * @param lessons 课件管理
     * @return 结果
     */
    public int insertLessons(Lessons lessons);

    /**
     * 修改课件管理
     * 
     * @param lessons 课件管理
     * @return 结果
     */
    public int updateLessons(Lessons lessons);

    /**
     * 批量删除课件管理
     * 
     * @param ids 需要删除的课件管理主键集合
     * @return 结果
     */
    public int deleteLessonsByIds(String ids);

    /**
     * 删除课件管理信息
     * 
     * @param id 课件管理主键
     * @return 结果
     */
    public int deleteLessonsById(Long id);

    /**
     *  根据父类课程id查询所有子类
     * @return
     */
    public List<Lessons> queryAllParentClasses();

    /**
     * 查询所有顺序
     * @return 所有顺序集合
     */
    public List<Lessons> queryAllOrder();

    /**
     * 查询父类
     * @return 父类集合
     */
    public List<Lessons> querySuperclass();

    /**
     * 校验名称是否唯一
     *
     * @param lessons 课件
     * @return 结果
     */
    public boolean checkPhoneUnique(Lessons lessons);
}
