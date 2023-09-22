package com.ruoyi.educationalAdministration.mapper;

import java.util.List;

import com.ruoyi.common.core.domain.entity.SysRole;
import com.ruoyi.educationalAdministration.domain.CampusManagement;

/**
 * 校区管理Mapper接口
 * 
 * @author wakoo
 * @date 2023-09-19
 */
public interface CampusManagementMapper 
{
    /**
     * 查询校区管理
     * 
     * @param id 校区管理主键
     * @return 校区管理
     */
    public CampusManagement selectCampusManagementById(Long id);

    /**
     * 查询校区管理列表
     * 
     * @param campusManagement 校区管理
     * @return 校区管理集合
     */
    public List<CampusManagement> selectCampusManagementList(CampusManagement campusManagement);

    /**
     * 新增校区管理
     * 
     * @param campusManagement 校区管理
     * @return 结果
     */
    public int insertCampusManagement(CampusManagement campusManagement);

    /**
     * 修改校区管理
     * 
     * @param campusManagement 校区管理
     * @return 结果
     */
    public int updateCampusManagement(CampusManagement campusManagement);

    /**
     * 删除校区管理
     * 
     * @param id 校区管理主键
     * @return 结果
     */
    public int deleteCampusManagementById(Long id);

    /**
     * 批量删除校区管理
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteCampusManagementByIds(String[] ids);

    /**
     *  校验校区管理名称是否唯一
     * @param campusName 校区管理名称
     * @return 校区管理
     */
    public CampusManagement campusNameUnique(String campusName);
}
