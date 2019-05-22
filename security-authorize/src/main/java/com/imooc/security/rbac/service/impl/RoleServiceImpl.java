package com.imooc.security.rbac.service.impl;


import com.google.common.collect.Sets;
import com.imooc.security.rbac.domain.Role;
import com.imooc.security.rbac.domain.RoleResource;
import com.imooc.security.rbac.dto.RoleInfo;
import com.imooc.security.rbac.repository.ResourceRepository;
import com.imooc.security.rbac.repository.RoleRepository;
import com.imooc.security.rbac.repository.RoleResourceRepository;
import com.imooc.security.rbac.repository.support.QueryResultConverter;
import com.imooc.security.rbac.service.RoleService;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Set;

/**
 * RoleServiceImpl
 *
 * @author Leslie
 * @email panxiang_work@163.com
 * @create 2019/5/22 11:37
 */
@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private ResourceRepository resourceRepository;

    @Autowired
    private RoleResourceRepository roleResourceRepository;

    @Override
    @Transactional(rollbackFor = {RuntimeException.class, Exception.class})
    public RoleInfo create(RoleInfo info) {
        Role role = new Role();
        BeanUtils.copyProperties(info, role);
        info.setId(roleRepository.save(role).getId());
        return info;
    }

    @Override
    public RoleInfo update(RoleInfo info) {
        Role role = roleRepository.findOne(info.getId());
        BeanUtils.copyProperties(info, role);
        return info;
    }

    @Override
    public void delete(Long id) {
        Role role = roleRepository.findOne(id);
        if (CollectionUtils.isNotEmpty(role.getAdmins())) {
            throw new RuntimeException("不能删除有下挂用户的角色");
        }
        roleRepository.delete(id);
    }

//	@Override
//	public String[] getRoleMenus(Long id) {
//		return StringUtils.split(roleRepository.findOne(id).getMenus(), ",");
//	}
//
//	@Override
//	public void setRoleMenu(Long roleId, String menuIds) {
//		Role role = roleRepository.findOne(roleId);
//		role.setMenus(menuIds);
//	}

    @Override
    public RoleInfo getInfo(Long id) {
        Role role = roleRepository.findOne(id);
        RoleInfo info = new RoleInfo();
        BeanUtils.copyProperties(role, info);
        return info;
    }

    @Override
    public List<RoleInfo> findAll() {
        return QueryResultConverter.convert(roleRepository.findAll(), RoleInfo.class);
    }

    @Override
    public String[] getRoleResources(Long id) {
        Role role = roleRepository.findOne(id);
        Set<String> resourceIds = Sets.newHashSet();
        for (RoleResource resource : role.getResources()) {
            resourceIds.add(resource.getResource().getId().toString());
        }
        int length = resourceIds.size();
        return resourceIds.toArray(new String[length]);
    }

    @Override
    public void setRoleResources(Long roleId, String resourceIds) {
        resourceIds = StringUtils.removeEnd(resourceIds, ",");
        Role role = roleRepository.findOne(roleId);
        roleResourceRepository.delete(role.getResources());
        String[] resourceIdArray = StringUtils.splitByWholeSeparatorPreserveAllTokens(resourceIds, ",");
        for (String resourceId : resourceIdArray) {
            RoleResource roleResource = new RoleResource();
            roleResource.setRole(role);
            roleResource.setResource(resourceRepository.getOne(new Long(resourceId)));
            roleResourceRepository.save(roleResource);
        }
    }

    public static void main(String[] args) {

    }

}
