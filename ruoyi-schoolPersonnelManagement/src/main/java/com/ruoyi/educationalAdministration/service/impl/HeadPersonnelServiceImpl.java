package com.ruoyi.educationalAdministration.service.impl;

import java.util.List;

import com.ruoyi.common.annotation.DataScope;
import com.ruoyi.common.constant.UserConstants;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.educationalAdministration.domain.HeadPersonnel;
import com.ruoyi.educationalAdministration.service.IHeadPersonnelService;
import org.springframework.stereotype.Service;
import com.ruoyi.educationalAdministration.mapper.HeadPersonnelMapper;
import com.ruoyi.common.core.text.Convert;

import javax.annotation.Resource;

/**
 * 瓦酷人员管理Service业务层处理
 * 
 * @author wakoo
 * @date 2023-09-21
 */
@Service
public class HeadPersonnelServiceImpl implements IHeadPersonnelService
{
    @Resource
    private HeadPersonnelMapper headPersonnelMapper;

    /**
     * 查询瓦酷人员管理
     * 
     * @param id 瓦酷人员管理主键
     * @return 瓦酷人员管理
     */
    @Override
    public HeadPersonnel selectHeadPersonnelById(Long id)
    {
        return headPersonnelMapper.selectHeadPersonnelById(id);
    }

    /**
     * 查询瓦酷人员管理列表
     * 
     * @param headPersonnel 瓦酷人员管理
     * @return 瓦酷人员管理
     */
    @Override
    @DataScope(userAlias = "hl")
    public List<HeadPersonnel> selectHeadPersonnelList(HeadPersonnel headPersonnel)
    {
        return headPersonnelMapper.selectHeadPersonnelList(headPersonnel);
    }

    /**
     * 新增瓦酷人员管理
     * 
     * @param headPersonnel 瓦酷人员管理
     * @return 结果
     */
    @Override
    public int insertHeadPersonnel(List<HeadPersonnel> headPersonnel)
    {
        return headPersonnelMapper.insertHeadPersonnel(headPersonnel);
    }

    /**
     * 修改瓦酷人员管理
     * 
     * @param headPersonnel 瓦酷人员管理
     * @return 结果
     */
    @Override
    public int updateHeadPersonnel(HeadPersonnel headPersonnel)
    {
        headPersonnel.setUpdateTime(DateUtils.getNowDate());
        return headPersonnelMapper.updateHeadPersonnel(headPersonnel);
    }

    /**
     * 批量删除瓦酷人员管理
     * 
     * @param ids 需要删除的瓦酷人员管理主键
     * @return 结果
     */
    @Override
    public int deleteHeadPersonnelByIds(String ids)
    {
        return headPersonnelMapper.deleteHeadPersonnelByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除瓦酷人员管理信息
     * 
     * @param id 瓦酷人员管理主键
     * @return 结果
     */
    @Override
    public int deleteHeadPersonnelById(Long id)
    {
        return headPersonnelMapper.deleteHeadPersonnelById(id);
    }

    /**
    * 查询校区
    * @return 校区
     **/
    @Override
    @DataScope(userAlias = "cm")
    public List<HeadPersonnel> queryPersonnelList(HeadPersonnel headPersonnel) {
        return headPersonnelMapper.queryPersonnelList(headPersonnel);
    }

    /**
     * 查询校区
     * @param headPersonnel 人员管理
     * @return 校区
     */
    @Override
    @DataScope(userAlias = "ps")
    public List<HeadPersonnel> getTheSchoolUserRelationship(HeadPersonnel headPersonnel) {
        return headPersonnelMapper.getTheSchoolUserRelationship(headPersonnel);
    }

    /**
     *  查询所有校园关系
     * @param headPersonnel 人员管理
     * @return 所有校园关系
     */
    @Override
    public List<HeadPersonnel> queryAllCampusRelationships(HeadPersonnel headPersonnel) {
        return headPersonnelMapper.queryAllCampusRelationships(headPersonnel);
    }

    /**
     * 验证手机号是否唯一
     * @param headPersonnel 人员实体类
     * @return 结果
     */
    @Override
    public boolean checkPhoneUnique(HeadPersonnel headPersonnel) {
        Long userId = StringUtils.isNull(headPersonnel.getId()) ? -1L : headPersonnel.getId();
        HeadPersonnel info = headPersonnelMapper.checkPhoneUnique(headPersonnel.getPhone());
        if (StringUtils.isNotNull(info) && info.getId().longValue() != userId.longValue())
        {
            return UserConstants.NOT_UNIQUE;
        }
        return UserConstants.UNIQUE;
    }

    /**
     * 根据部门地址码判断此人员是否有对应部门信息
     * @param headPersonnel 人员管理
     * @return 部门列表
     */
    @Override
    public List<HeadPersonnel> queriedSchool(HeadPersonnel headPersonnel) {
        return headPersonnelMapper.queriedSchool(headPersonnel);
    }

    @Override
    public Boolean queryMobilePhoneNumberexistenceOrNot(String iphone) {
        return headPersonnelMapper.checkPhoneUnique(iphone)!=null;
    }
}
