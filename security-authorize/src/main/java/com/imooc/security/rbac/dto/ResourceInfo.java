package com.imooc.security.rbac.dto;

import com.imooc.security.rbac.domain.ResourceType;

import java.util.ArrayList;
import java.util.List;

/**
 * ResourceInfo
 *
 * @author Leslie
 * @email panxiang_work@163.com
 * @create 2019/5/22 10:42
 */
public class ResourceInfo {

    /**
     * 资源ID
     *
     * @since 1.0.0
     */
    private Long id;
    private Long parentId;
    /**
     * 资源名
     *
     * @since 1.0.0
     */
    private String name;
    /**
     * 资源链接
     *
     * @since 1.0.0
     */
    private String link;
    /**
     * 图标
     */
    private String icon;
    /**
     * 资源类型
     */
    private ResourceType type;
    /**
     * 子节点
     */
    private List<ResourceInfo> children = new ArrayList<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public List<ResourceInfo> getChildren() {
        return children;
    }

    public void setChildren(List<ResourceInfo> children) {
        this.children = children;
    }

    public ResourceType getType() {
        return type;
    }

    public void setType(ResourceType type) {
        this.type = type;
    }

}
