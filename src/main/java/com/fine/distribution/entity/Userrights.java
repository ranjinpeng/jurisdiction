package com.fine.distribution.entity;

import io.swagger.annotations.ApiModelProperty;
import tk.mybatis.mapper.annotation.KeySql;

import javax.persistence.*;

@Table(name = "`userrights`")
public class Userrights {
    /**
     * 用户id
     */
    @ApiModelProperty(value="用户id")
    @Id
    @KeySql(useGeneratedKeys = true)
    private Integer id;

    /**
     * 姓名
     */
    @ApiModelProperty(value="姓名")
    private String name;

    /**
     * 手机号码
     */
    @ApiModelProperty(value="手机号码")
    private String phone;

    /**
     * 住宅电话
     */
    @ApiModelProperty(value="住宅电话")
    private String telephone;

    /**
     * 联系地址
     */
    @ApiModelProperty(value="联系地址")
    private String address;

    @ApiModelProperty(value="暂无注解")
    private Boolean enabled;

    /**
     * 用户名
     */
    @ApiModelProperty(value="用户名")
    private String username;

    /**
     * 密码
     */
    @ApiModelProperty(value="密码")
    private String password;

    @ApiModelProperty(value="暂无注解")
    private String userface;

    @ApiModelProperty(value="暂无注解")
    private String remark;

    /**
     * 获取hrID
     *
     * @return id - hrID
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置hrID
     *
     * @param id hrID
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取姓名
     *
     * @return name - 姓名
     */
    public String getName() {
        return name;
    }

    /**
     * 设置姓名
     *
     * @param name 姓名
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取手机号码
     *
     * @return phone - 手机号码
     */
    public String getPhone() {
        return phone;
    }

    /**
     * 设置手机号码
     *
     * @param phone 手机号码
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     * 获取住宅电话
     *
     * @return telephone - 住宅电话
     */
    public String getTelephone() {
        return telephone;
    }

    /**
     * 设置住宅电话
     *
     * @param telephone 住宅电话
     */
    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    /**
     * 获取联系地址
     *
     * @return address - 联系地址
     */
    public String getAddress() {
        return address;
    }

    /**
     * 设置联系地址
     *
     * @param address 联系地址
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * @return enabled
     */
    public Boolean getEnabled() {
        return enabled;
    }

    /**
     * @param enabled
     */
    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

    /**
     * 获取用户名
     *
     * @return username - 用户名
     */
    public String getUsername() {
        return username;
    }

    /**
     * 设置用户名
     *
     * @param username 用户名
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * 获取密码
     *
     * @return password - 密码
     */
    public String getPassword() {
        return password;
    }

    /**
     * 设置密码
     *
     * @param password 密码
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * @return userface
     */
    public String getUserface() {
        return userface;
    }

    /**
     * @param userface
     */
    public void setUserface(String userface) {
        this.userface = userface;
    }

    /**
     * @return remark
     */
    public String getRemark() {
        return remark;
    }

    /**
     * @param remark
     */
    public void setRemark(String remark) {
        this.remark = remark;
    }
}