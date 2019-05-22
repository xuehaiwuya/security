package com.imooc.security.rbac.domain;

import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * 角色信息
 *
 * @author Leslie
 * @email panxiang_work@163.com
 * @create 2019/5/22 10:40
 */
@Entity
public class Role {

    /**
     * 数据库表主键
     */
    @Id
    @GeneratedValue
    private Long id;
    /**
     * 审计日志，记录条目创建时间，自动赋值，不需要程序员手工赋值
     */
    @Temporal(TemporalType.TIMESTAMP)
    @CreatedDate
    private Date createdTime;
    /**
     * 角色名称
     */
    @Column(length = 20, nullable = false)
    private String name;
    /**
     * 角色拥有权限的资源集合
     */
    @OneToMany(mappedBy = "role", cascade = CascadeType.REMOVE)
    private Set<RoleResource> resources = new HashSet<>();
    /**
     * 角色的用户集合
     */
    @OneToMany(mappedBy = "role", cascade = CascadeType.REMOVE)
    private Set<RoleAdmin> admins = new HashSet<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<RoleResource> getResources() {
        return resources;
    }

    public void setResources(Set<RoleResource> resources) {
        this.resources = resources;
    }

    public Set<RoleAdmin> getAdmins() {
        return admins;
    }

    public void setAdmins(Set<RoleAdmin> admins) {
        this.admins = admins;
    }

}
