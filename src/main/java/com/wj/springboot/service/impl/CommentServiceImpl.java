package com.wj.springboot.service.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wj.springboot.entity.Comment;
import com.wj.springboot.mapper.CommentMapper;
import com.wj.springboot.service.ICommentService;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;


@Service
public class CommentServiceImpl extends ServiceImpl<CommentMapper, Comment> implements ICommentService {

    @Resource
    private CommentMapper commentMapper;

    @Override
    public List<Comment> findCommentDetail(Integer articleId) {

        return commentMapper.findCommentDetail(articleId);
    }
}
