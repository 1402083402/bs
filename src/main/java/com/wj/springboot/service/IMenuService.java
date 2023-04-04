package com.wj.springboot.service;

import com.wj.springboot.entity.Menu;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;


public interface IMenuService extends IService<Menu> {

    List<Menu> findMenus(String name);
}
