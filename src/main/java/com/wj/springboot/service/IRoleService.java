package com.wj.springboot.service;

import com.wj.springboot.entity.Role;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;


public interface IRoleService extends IService<Role> {

    void setRoleMenu(Integer roleId, List<Integer> menuIds);

    List<Integer> getRoleMenu(Integer roleId);
}
