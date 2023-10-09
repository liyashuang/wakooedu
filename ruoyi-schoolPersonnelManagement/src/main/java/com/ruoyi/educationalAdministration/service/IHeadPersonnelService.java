package com.ruoyi.educationalAdministration.service;

import java.util.List;
import com.ruoyi.educationalAdministration.domain.HeadPersonnel;

/**
 * 瓦酷人员管理Service接口
 *
 * @author wakoo
 * @date 2023-09-21
 */
public interface IHeadPersonnelService
{
    /**
     * 查询瓦酷人员管理
     *
     * @param id 瓦酷人员管理主键
     * @return 瓦酷人员管理
     */
    public HeadPersonnel selectHeadPersonnelById(Long id);

    /**
     * 查询瓦酷人员管理列表
     *
     * @param headPersonnel 瓦酷人员管理
     * @return 瓦酷人员管理集合
     */
    public List<HeadPersonnel> selectHeadPersonnelList(HeadPersonnel headPersonnel);

    /**
     * 新增瓦酷人员管理
     *
     * @param headPersonnel 瓦酷人员管理
     * @return 结果
     */
    public int insertHeadPersonnel(List<HeadPersonnel> headPersonnel);

    /**
     * 修改瓦酷人员管理
     *
     * @param headPersonnel 瓦酷人员管理
     * @return 结果
     */
    public int updateHeadPersonnel(HeadPersonnel headPersonnel);

    /**
     * 批量删除瓦酷人员管理
     *
     * @param ids 需要删除的瓦酷人员管理主键集合
     * @return 结果
     */
    public int deleteHeadPersonnelByIds(String ids);

    /**
     * 删除瓦酷人员管理信息
     *
     * @param id 瓦酷人员管理主键
     * @return 结果
     */
    public int deleteHeadPersonnelById(Long id);

    /**
     * 查询校区
     * @param headPersonnel 人员管理
     * @return 校区
     **/
    public List<HeadPersonnel> queryPersonnelList(HeadPersonnel headPersonnel);

    /**
     *  选择校区
     * @param headPersonnel 人员管理
     * @return 校区
     */
    public List<HeadPersonnel> getTheSchoolUserRelationship(HeadPersonnel headPersonnel);

    /**
     *  查询所有校区
     * @param headPersonnel 人员管理
     * @return 校区
     */
    public List<HeadPersonnel> queryAllCampusRelationships(HeadPersonnel headPersonnel);

    /**
     * 校验手机号码是否唯一
     *
     * @param headPersonnel 人员实体类
     * @return 结果
     */
    public boolean checkPhoneUnique(HeadPersonnel headPersonnel);

    /**
     *  查询学校关联的所有校区
     * @param headPersonnel 人员管理
     * @return 校区
     */
    public List<HeadPersonnel> queriedSchool(HeadPersonnel headPersonnel);

    /**
     *  校验手机号码是否唯一
     * @param iphone 手机号码
     * @return 是否唯一
     */
    public Boolean queryMobilePhoneNumberexistenceOrNot(String iphone);
}
