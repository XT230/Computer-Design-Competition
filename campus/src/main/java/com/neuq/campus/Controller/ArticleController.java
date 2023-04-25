package com.neuq.campus.Controller;

import com.neuq.campus.Model.Article;
import com.neuq.campus.Repository.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;

@RestController
@RequestMapping("/article")
public class ArticleController
{
    @Autowired
    ArticleRepository articleRepository;

    @GetMapping("/getAll")
    public List<Article> getAll()
    {
        return articleRepository.findAll();
    }

    @PostMapping("/addArticle")
    public Article addArticle(@RequestBody Article article)
    {
        article.setTimestamp(System.currentTimeMillis());
        article.setAid(articleRepository.count() + 1);
        return articleRepository.save(article);
    }

    @GetMapping("/getArticlesByType")
    public List<Article> getArticlesByType(@PathParam("type") Integer type)
    {
        return articleRepository.getArticlesByType(type);
    }

    @GetMapping("/getArticleByAid")
    public Article getArticleByAid(@PathParam("aid") long aid)
    {
        return articleRepository.getArticleByAid(aid);
    }
}
