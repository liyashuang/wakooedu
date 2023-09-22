package com.ruoyi.educationalAdministration.service.impl;

import java.util.List;

import com.ruoyi.common.annotation.DataScope;
import com.ruoyi.common.constant.UserConstants;
import com.ruoyi.common.core.domain.entity.SysRole;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.common.utils.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.educationalAdministration.mapper.CampusManagementMapper;
import com.ruoyi.educationalAdministration.domain.CampusManagement;
import com.ruoyi.educationalAdministration.service.ICampusManagementService;
import com.ruoyi.common.core.text.Convert;

import javax.annotation.Resource;

/**
 * 校区管理Service业务层处理
 * 
 * @author wakoo
 * @date 2023-09-19
 */
@Service
public class CampusManagementServiceImpl implements ICampusManagementService 
{
    @Resource
    private CampusManagementMapper campusManagementMapper;

    /**
     * 查询校区管理
     * 
     * @param id 校区管理主键
     * @return 校区管理
     */
    @Override
    public CampusManagement selectCampusManagementById(Long id)
    {
        return campusManagementMapper.selectCampusManagementById(id);
    }

    /**
     * 查询校区管理列表
     * 
     * @param campusManagement 校区管理
     * @return 校区管理
     */
    @Override
    @DataScope(userAlias = "ct")
    public List<CampusManagement> selectCampusManagementList(CampusManagement campusManagement)
    {
        return campusManagementMapper.selectCampusManagementList(campusManagement);
    }

    /**
     * 新增校区管理
     * 
     * @param campusManagement 校区管理
     * @return 结果
     */
    @Override
    public int insertCampusManagement(CampusManagement campusManagement)
    {
        campusManagement.setCreateTime(DateUtils.getNowDate());
        return campusManagementMapper.insertCampusManagement(campusManagement);
    }

    /**
     * 修改校区管理
     * 
     * @param campusManagement 校区管理
     * @return 结果
     */
    @Override
    public int updateCampusManagement(CampusManagement campusManagement)
    {
        campusManagement.setUpdateTime(DateUtils.getNowDate());
        return campusManagementMapper.updateCampusManagement(campusManagement);
    }

    /**
     * 批量删除校区管理
     * 
     * @param ids 需要删除的校区管理主键
     * @return 结果
     */
    @Override
    public int deleteCampusManagementByIds(String ids)
    {
        return campusManagementMapper.deleteCampusManagementByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除校区管理信息
     * 
     * @param id 校区管理主键
     * @return 结果
     */
    @Override
    public int deleteCampusManagementById(Long id)
    {
        return campusManagementMapper.deleteCampusManagementById(id);
    }

    /**
     *  校验校区管理名称是否唯一
     * @param campusManagement 校区管理名称
     * @return 校区管理
     */
    @Override
    public Boolean campusNameUnique(CampusManagement campusManagement) {

        {
            Long roleId = StringUtils.isNull(campusManagement.getId()) ? -1L : campusManagement.getId();
            CampusManagement info = campusManagementMapper.campusNameUnique(campusManagement.getCampusName());
            if (StringUtils.isNotNull(info) && info.getId().longValue() != roleId.longValue())
            {
                return UserConstants.NOT_UNIQUE;
            }
            return UserConstants.UNIQUE;
        }
    }
}
