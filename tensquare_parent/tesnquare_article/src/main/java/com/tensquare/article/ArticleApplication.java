package com.tensquare.article;

import com.tensquare.util.IdWorker;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

/**
 * 文章微服启动类
 */
@SpringBootApplication
public class ArticleApplication {

    public static void main(String[] args) {
        SpringApplication.run(ArticleApplication.class,args);
    }
    
    @Bean
    public IdWorker idWorker(){
        return new IdWorker(1,1);
    }

}