package com.ruoyi.educationalAdministration.domain;


import java.io.Serializable;


/**
 * @author JCccc
 * 地域表实体 （省市区）
 */
public class District implements Serializable {

    /**
     * 省级编码
     */
    public static final String PROVINCE_CODE = "1";
    /**
     * 地址编码
     */
    private String code;
    /**
     * 地址名称
     */
    private String name;
    /**
     * 地址父级编码
     */
    private String parentCode;
    /**
     * 当前地区对应的全称
     */
    private String fullName;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getParentCode() {
        return parentCode;
    }

    public void setParentCode(String parentCode) {
        this.parentCode = parentCode;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }
}