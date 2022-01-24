package com.ebff.challenge.spaceflightnews.repository;

import com.ebff.challenge.spaceflightnews.model.Article;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ArticleRepository extends MongoRepository<Article, Long> {
    Page<Article> findAll(Pageable pageable);
}
