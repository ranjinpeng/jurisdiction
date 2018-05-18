package com.fine.distribution.entity;

import io.swagger.annotations.ApiModelProperty;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import tk.mybatis.mapper.annotation.KeySql;

import java.util.Collection;
import java.util.Date;
import javax.persistence.*;

@Table(name = "`user`")
public class User implements UserDetails{
    @ApiModelProperty(value="暂无注解")
    @Id
    @KeySql(useGeneratedKeys = true)
    private Integer userid;

    @ApiModelProperty(value="暂无注解")
    private String name;

    @ApiModelProperty(value="暂无注解")
    private String password;

    @ApiModelProperty(value="暂无注解")
    private String phone;

    @ApiModelProperty(value="暂无注解")
    private String role;

    @ApiModelProperty(value="暂无注解")
    @Column(name = "bankName")
    private String bankname;

    @ApiModelProperty(value="暂无注解")
    @Column(name = "cardNo")
    private String cardno;

    @ApiModelProperty(value="暂无注解")
    @Column(name = "realName")
    private String realname;

    @ApiModelProperty(value="暂无注解")
    private Integer rightsid;

    @ApiModelProperty(value="暂无注解")
    @Column(name = "idCard")
    private String idcard;

    @ApiModelProperty(value="暂无注解")
    @Column(name = "isPass")
    private Integer ispass;

    @ApiModelProperty(value="暂无注解")
    private Date creattime;

    /**
     * @return userid
     */
    public Integer getUserid() {
        return userid;
    }

    /**
     * @param userid
     */
    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    /**
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * @return phone
     */
    public String getPhone() {
        return phone;
    }

    /**
     * @param phone
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     * @return role
     */
    public String getRole() {
        return role;
    }

    /**
     * @param role
     */
    public void setRole(String role) {
        this.role = role;
    }

    /**
     * @return bankName
     */
    public String getBankname() {
        return bankname;
    }

    /**
     * @param bankname
     */
    public void setBankname(String bankname) {
        this.bankname = bankname;
    }

    /**
     * @return cardNo
     */
    public String getCardno() {
        return cardno;
    }

    /**
     * @param cardno
     */
    public void setCardno(String cardno) {
        this.cardno = cardno;
    }

    /**
     * @return realName
     */
    public String getRealname() {
        return realname;
    }

    /**
     * @param realname
     */
    public void setRealname(String realname) {
        this.realname = realname;
    }

    /**
     * @return rightsid
     */
    public Integer getRightsid() {
        return rightsid;
    }

    /**
     * @param rightsid
     */
    public void setRightsid(Integer rightsid) {
        this.rightsid = rightsid;
    }

    /**
     * @return idCard
     */
    public String getIdcard() {
        return idcard;
    }

    /**
     * @param idcard
     */
    public void setIdcard(String idcard) {
        this.idcard = idcard;
    }

    /**
     * @return isPass
     */
    public Integer getIspass() {
        return ispass;
    }

    /**
     * @param ispass
     */
    public void setIspass(Integer ispass) {
        this.ispass = ispass;
    }

    /**
     * @return creattime
     */
    public Date getCreattime() {
        return creattime;
    }

    /**
     * @param creattime
     */
    public void setCreattime(Date creattime) {
        this.creattime = creattime;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getUsername() {
        return name;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}