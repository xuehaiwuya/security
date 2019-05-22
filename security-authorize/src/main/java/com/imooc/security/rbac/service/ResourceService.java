package com.imooc.security.rbac.service;

import com.imooc.security.rbac.dto.ResourceInfo;

/**
 * 资源服务
 *
 * @author Leslie
 * @email panxiang_work@163.com
 * @create 2019/5/22 13:54
 */
public interface ResourceService {

    /**
     * 获取资源树
     *
     * @param userId 用户ID
     * @return ResourceInfo
     * @since 1.0.0
     */
    ResourceInfo getTree(Long userId);

    /**
     * 根据资源ID获取资源信息
     *
     * @param id 资源ID
     * @return ResourceInfo 资源信息
     * @since 1.0.0
     */
    ResourceInfo getInfo(Long id);

    /**
     * 新增资源
     *
     * @param info 页面传入的资源信息
     * @return ResourceInfo 资源信息
     * @since 1.0.0
     */
    ResourceInfo create(ResourceInfo info);

    /**
     * 更新资源
     *
     * @param info 页面传入的资源信息
     * @return ResourceInfo 资源信息
     * @since 1.0.0
     */
    ResourceInfo update(ResourceInfo info);

    /**
     * 根据指定ID删除资源信息
     *
     * @param id 资源ID
     * @since 1.0.0
     */
    void delete(Long id);

    /**
     * 上移/下移资源
     *
     * @param id
     * @param up
     */
    Long move(Long id, boolean up);

}
