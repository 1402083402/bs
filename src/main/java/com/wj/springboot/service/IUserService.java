package com.wj.springboot.service;

import com.wj.springboot.controller.dto.UserDTO;
import com.wj.springboot.controller.dto.UserPasswordDTO;
import com.wj.springboot.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;


public interface IUserService extends IService<User> {

    UserDTO login(UserDTO userDTO);

    User register(UserDTO userDTO);

    void updatePassword(UserPasswordDTO userPasswordDTO);
}
