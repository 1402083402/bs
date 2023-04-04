package com.wj.springboot.mapper;

import com.wj.springboot.controller.dto.UserPasswordDTO;
import com.wj.springboot.entity.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Update;


public interface UserMapper extends BaseMapper<User> {

    @Update("update sys_user set password = #{newPassword} where username = #{username} and password = #{password}")
    int updatePassword(UserPasswordDTO userPasswordDTO);

}
