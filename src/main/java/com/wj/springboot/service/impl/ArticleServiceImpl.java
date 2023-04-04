package com.wj.springboot.service.impl;
import com.wj.springboot.mapper.ArticleMapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wj.springboot.entity.Article;
import com.wj.springboot.service.IArticleService;
import org.springframework.stereotype.Service;


@Service
public class ArticleServiceImpl extends ServiceImpl<ArticleMapper, Article> implements IArticleService {

}
