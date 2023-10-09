package com.ruoyi.educationalAdministration.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.educationalAdministration.mapper.LessonsMapper;
import com.ruoyi.educationalAdministration.domain.Lessons;
import com.ruoyi.educationalAdministration.service.ILessonsService;
import com.ruoyi.common.core.text.Convert;

import javax.annotation.Resource;

/**
 * 课件管理Service业务层处理
 * 
 * @author wakoo
 * @date 2023-10-07
 */
@Service
public class LessonsServiceImpl implements ILessonsService 
{
    @Resource
    private LessonsMapper lessonsMapper;

    /**
     * 查询课件管理
     * 
     * @param id 课件管理主键
     * @return 课件管理
     */
    @Override
    public Lessons selectLessonsById(Long id)
    {
        return lessonsMapper.selectLessonsById(id);
    }

    /**
     * 查询课件管理列表
     * 
     * @param lessons 课件管理
     * @return 课件管理
     */
    @Override
    public List<Lessons> selectLessonsList(Lessons lessons)
    {
        return lessonsMapper.selectLessonsList(lessons);
    }

    /**
     * 新增课件管理
     * 
     * @param lessons 课件管理
     * @return 结果
     */
    @Override
    public int insertLessons(Lessons lessons)
    {
        lessons.setCreateTime(DateUtils.getNowDate());
        return lessonsMapper.insertLessons(lessons);
    }

    /**
     * 修改课件管理
     * 
     * @param lessons 课件管理
     * @return 结果
     */
    @Override
    public int updateLessons(Lessons lessons)
    {
        lessons.setUpdateTime(DateUtils.getNowDate());
        return lessonsMapper.updateLessons(lessons);
    }

    /**
     * 批量删除课件管理
     * 
     * @param ids 需要删除的课件管理主键
     * @return 结果
     */
    @Override
    public int deleteLessonsByIds(String ids)
    {
        return lessonsMapper.deleteLessonsByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除课件管理信息
     * 
     * @param id 课件管理主键
     * @return 结果
     */
    @Override
    public int deleteLessonsById(Long id)
    {
        return lessonsMapper.deleteLessonsById(id);
    }

    @Override
    public List<Lessons> queryAllParentClasses() {
        return lessonsMapper.queryAllParentClasses();
    }

    @Override
    public List<Lessons> queryAllOrder() {
        return lessonsMapper.queryAllOrder();
    }

    @Override
    public List<Lessons> querySuperclass() {
        return lessonsMapper.querySuperclass();
    }

}
