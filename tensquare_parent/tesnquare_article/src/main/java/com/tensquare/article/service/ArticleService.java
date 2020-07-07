package com.tensquare.article.service;

import com.tensquare.article.pojo.Article;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


public interface ArticleService {

    List<Article> findAll();

    Article findById(String articleId);

    void add(Article article);

    void update(Article article);

    void delete(String id);
}
