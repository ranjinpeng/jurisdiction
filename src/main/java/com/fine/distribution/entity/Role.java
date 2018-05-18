package com.fine.distribution.entity;

import io.swagger.annotations.ApiModelProperty;
import tk.mybatis.mapper.annotation.KeySql;

import javax.persistence.*;

@Table(name = "`role`")
public class Role {
    @ApiModelProperty(value="暂无注解")
    @Id
    @KeySql(useGeneratedKeys = true)
    private Integer id;

    @ApiModelProperty(value="暂无注解")
    private String name;

    /**
     * 角色名称
     */
    @ApiModelProperty(value="角色名称")
    @Column(name = "nameZh")
    private String namezh;

    /**
     * @return id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Integer id) {
        this.id = id;
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
     * 获取角色名称
     *
     * @return nameZh - 角色名称
     */
    public String getNamezh() {
        return namezh;
    }

    /**
     * 设置角色名称
     *
     * @param namezh 角色名称
     */
    public void setNamezh(String namezh) {
        this.namezh = namezh;
    }
}