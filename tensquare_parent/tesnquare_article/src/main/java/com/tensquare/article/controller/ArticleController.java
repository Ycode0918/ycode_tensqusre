package com.tensquare.article.controller;

import com.tensquare.article.pojo.Article;
import com.tensquare.article.service.ArticleService;
import com.tensquare.entity.Result;
import com.tensquare.entity.StatusCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/article")
public class ArticleController {

    @Autowired
    private ArticleService articleService;

    @GetMapping
    public Result findAll(){
        List<Article> list =articleService.findAll();
        return new Result(true, StatusCode.OK,"文章查询成功",list);
    }

    @GetMapping("/{articleId}")
    public Result findById(@PathVariable("articleId") String articleId){
        Article article = articleService.findById(articleId);
        return new Result(true,StatusCode.OK,"文章查询成功",article);
    }

    @PostMapping
    public Result add(@RequestBody  Article article){
        articleService.add(article);
        return new Result(true,StatusCode.OK,"添加成功");
    }

    @PutMapping("/{id}")
    public Result update(@PathVariable String id,@RequestBody Article article){

        article.setId(id);
        articleService.update(article);
        return new Result(true,StatusCode.OK,"修改成功");
    }

    @DeleteMapping("/{id}")
    public Result delete(@PathVariable String id){

        articleService.delete(id);
        return new Result(true,StatusCode.OK,"删除成功");
    }
}
