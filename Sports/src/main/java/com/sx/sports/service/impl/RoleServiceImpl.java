package com.sx.sports.service.impl;
import com.sx.sports.entity.Role;
import com.sx.sports.mapper.RoleMapper;
import com.sx.sports.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {
    @Autowired

    private RoleMapper roleMapper;
    @Override
    public List<Role> findRoleList() {
        return roleMapper.findRoleList();
    }
    @Override
    public Role findRoleByCode(String userName) {
        return roleMapper.findRoleByCode(userName);
    }
    @Override
    public int insertRole(Role role) {
        return roleMapper.insertRole(role);
    }
    @Override
    public int updateRole(Role role) {
        return roleMapper.updateRole(role);
    }
    @Override
    public int deleteRole(int roleId) {
        return roleMapper.deleteRole(roleId);
    }
}