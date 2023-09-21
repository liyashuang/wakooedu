package com.ruoyi.educationalAdministration.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 校区管理对象 campus_management
 * 
 * @author wakoo
 * @date 2023-09-19
 */
public class CampusManagement extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** ID */
    @Excel(name = "校区ID")
    private Long id;

    @Excel(name = "用户ID")
    private Long userId;

    @Excel(name = "用户ID")
    private Long deptId;

    /** 校区名称 */
    @Excel(name = "校区名称")
    private String campusName;

    /** 省 */
    @Excel(name = "省")
    private String province;
    private String provinces;

    /** 城市 */
    @Excel(name = "城市")
    private String city;
    private String citys;

    /** 区县 */
    @Excel(name = "区县")
    private String district;
    private String districts;

    /** 详细地址 */
    @Excel(name = "详细地址")
    private String address;

    /** 删除标志（0代表存在 2代表删除） */
    private String delFlag;

    /** 状态（0正常 1停用） */
    @Excel(name = "状态", readConverterExp = "0=正常,1=停用")
    private String status;


    public String getProvinces() {
        return provinces;
    }

    public void setProvinces(String provinces) {
        this.provinces = provinces;
    }

    public String getCitys() {
        return citys;
    }

    public void setCitys(String citys) {
        this.citys = citys;
    }

    public String getDistricts() {
        return districts;
    }

    public void setDistricts(String districts) {
        this.districts = districts;
    }

    public String getDelFlag() {
        return delFlag;
    }

    public void setDelFlag(String delFlag) {
        this.delFlag = delFlag;
    }

    public Long getDeptId() {
        return deptId;
    }

    public void setDeptId(Long deptId) {
        this.deptId = deptId;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setCampusId(Long id)
    {
        this.id = id;
    }

    public Long getCampusId()
    {
        return id;
    }
    public void setCampusName(String campusName)
    {
        this.campusName = campusName;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getCampusName()
    {
        return campusName;
    }
    public void setProvince(String province) 
    {
        this.province = province;
    }

    public String getProvince() 
    {
        return province;
    }
    public void setCity(String city) 
    {
        this.city = city;
    }

    public String getCity() 
    {
        return city;
    }
    public void setDistrict(String district) 
    {
        this.district = district;
    }

    public String getDistrict() 
    {
        return district;
    }
    public void setAddress(String address) 
    {
        this.address = address;
    }

    public String getAddress() 
    {
        return address;
    }
    public void setStatus(String status) 
    {
        this.status = status;
    }

    public String getStatus() 
    {
        return status;
    }

    @Override
    public String toString() {
        return "CampusManagement{" +
                "id=" + id +
                ", userId=" + userId +
                ", campusName='" + campusName + '\'' +
                ", province='" + province + '\'' +
                ", city='" + city + '\'' +
                ", district='" + district + '\'' +
                ", address='" + address + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
