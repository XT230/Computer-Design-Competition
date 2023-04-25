package com.neuq.campus.Repository;

import com.neuq.campus.Model.Article;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface ArticleRepository extends MongoRepository<Article, String>
{
    public List<Article> getArticlesByType(int type);
    public Article getArticleByAid(long aid);
}
