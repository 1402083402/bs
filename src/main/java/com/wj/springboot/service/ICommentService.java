package com.wj.springboot.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.wj.springboot.entity.Comment;

import java.util.List;


public interface ICommentService extends IService<Comment> {

    List<Comment> findCommentDetail(Integer articleId);
}
