package com.ruoyi.educationalAdministration.service;

import java.util.List;

import com.ruoyi.common.core.domain.entity.SysRole;
import com.ruoyi.educationalAdministration.domain.CampusManagement;
import com.sun.org.apache.xpath.internal.operations.Bool;

/**
 * 校区管理Service接口
 * 
 * @author wakoo
 * @date 2023-09-19
 */
public interface ICampusManagementService 
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
     * 批量删除校区管理
     * 
     * @param ids 需要删除的校区管理主键集合
     * @return 结果
     */
    public int deleteCampusManagementByIds(String ids);

    /**
     * 删除校区管理信息
     * 
     * @param id 校区管理主键
     * @return 结果
     */
    public int deleteCampusManagementById(Long id);

    /**
     *  校验校区管理名称是否唯一
     * @param campusManagement 校区管理名称
     * @return 校区管理
     */
    public Boolean campusNameUnique(CampusManagement campusManagement);
}
