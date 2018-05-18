package com.fine.distribution.entity;

import io.swagger.annotations.ApiModelProperty;
import tk.mybatis.mapper.annotation.KeySql;

import javax.persistence.*;
import java.util.List;

@Table(name = "`menu`")
public class Menu {
    @ApiModelProperty(value="暂无注解")
    @Id
    @KeySql(useGeneratedKeys = true)
    private Integer id;

    @ApiModelProperty(value="暂无注解")
    private String url;

    @ApiModelProperty(value="暂无注解")
    private String path;

    @ApiModelProperty(value="暂无注解")
    private String component;

    @ApiModelProperty(value="暂无注解")
    private String name;

    @ApiModelProperty(value="暂无注解")
    @Column(name = "iconCls")
    private String iconcls;

    @ApiModelProperty(value="暂无注解")
    @Column(name = "keepAlive")
    private Boolean keepalive;

    @ApiModelProperty(value="暂无注解")
    @Column(name = "requireAuth")
    private Boolean requireauth;

    @ApiModelProperty(value="暂无注解")
    @Column(name = "parentId")
    private Integer parentid;

    @ApiModelProperty(value="暂无注解")
    private Boolean enabled;



    /*
  自定义 子列表
   */
    @Transient
    public List<Menu> childslist;

    public List<Menu> getChildslist() {
        return childslist;
    }

    public void setChildslist(List<Menu> childslist) {
        this.childslist = childslist;
    }

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
     * @return url
     */
    public String getUrl() {
        return url;
    }

    /**
     * @param url
     */
    public void setUrl(String url) {
        this.url = url;
    }

    /**
     * @return path
     */
    public String getPath() {
        return path;
    }

    /**
     * @param path
     */
    public void setPath(String path) {
        this.path = path;
    }

    /**
     * @return component
     */
    public String getComponent() {
        return component;
    }

    /**
     * @param component
     */
    public void setComponent(String component) {
        this.component = component;
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
     * @return iconCls
     */
    public String getIconcls() {
        return iconcls;
    }

    /**
     * @param iconcls
     */
    public void setIconcls(String iconcls) {
        this.iconcls = iconcls;
    }

    /**
     * @return keepAlive
     */
    public Boolean getKeepalive() {
        return keepalive;
    }

    /**
     * @param keepalive
     */
    public void setKeepalive(Boolean keepalive) {
        this.keepalive = keepalive;
    }

    /**
     * @return requireAuth
     */
    public Boolean getRequireauth() {
        return requireauth;
    }

    /**
     * @param requireauth
     */
    public void setRequireauth(Boolean requireauth) {
        this.requireauth = requireauth;
    }

    /**
     * @return parentId
     */
    public Integer getParentid() {
        return parentid;
    }

    /**
     * @param parentid
     */
    public void setParentid(Integer parentid) {
        this.parentid = parentid;
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
}