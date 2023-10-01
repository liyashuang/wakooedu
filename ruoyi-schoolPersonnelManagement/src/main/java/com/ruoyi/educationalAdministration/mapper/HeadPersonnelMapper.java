package com.ruoyi.educationalAdministration.mapper;


import com.ruoyi.educationalAdministration.domain.HeadPersonnel;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 瓦酷人员管理Mapper接口
 * 
 * @author wakoo
 * @date 2023-09-21
 */
public interface HeadPersonnelMapper 
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
    public int insertHeadPersonnel(@Param("headPersonnel") List<HeadPersonnel> headPersonnel);

    /**
     * 修改瓦酷人员管理
     * 
     * @param headPersonnel 瓦酷人员管理
     * @return 结果
     */
    public int updateHeadPersonnel(HeadPersonnel headPersonnel);

    /**
     * 删除瓦酷人员管理
     * 
     * @param id 瓦酷人员管理主键
     * @return 结果
     */
    public int deleteHeadPersonnelById(Long id);

    /**
     * 批量删除瓦酷人员管理
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteHeadPersonnelByIds(String[] ids);

    /**
     * 查询校区
     * @param headPersonnel  人员管理
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
     * @param phoneNumber 手机号码
     * @return 结果
     */
    public HeadPersonnel checkPhoneUnique(String phoneNumber);

    /**
     *  查询学校关联的所有校区
     * @param headPersonnel 人员管理
     * @return 校区
     */
    public List<HeadPersonnel> queriedSchool(HeadPersonnel headPersonnel);
}
