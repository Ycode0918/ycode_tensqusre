package com.tensquare.article.service.impl;

import com.tensquare.article.dao.ArticleMapper;
import com.tensquare.article.pojo.Article;
import com.tensquare.article.service.ArticleService;
import com.tensquare.util.IdWorker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service
public class ArticleServiceImpl implements ArticleService {

    @Autowired
    private ArticleMapper articleMapper;

    @Autowired
    private IdWorker idWorker;

    @Override
    public List<Article> findAll() {
        return articleMapper.selectList(null);
    }

    @Override
    public Article findById(String articleId) {
        return articleMapper.selectById(articleId);
    }

    @Override
    public void add(Article article) {
        //新增文章
        String authorId = "1";
        article.setId(idWorker.nextId()+"");
        article.setVisits(0);//浏览量
        article.setThumbup(0);//点赞数
        article.setComment(0);//评论数
        article.setUserid(authorId);
        articleMapper.insert(article);
    }

    @Override
    public void update(Article article) {
        articleMapper.updateById(article);
    }

    @Override
    public void delete(String id) {
        articleMapper.deleteById(id);
    }
}
