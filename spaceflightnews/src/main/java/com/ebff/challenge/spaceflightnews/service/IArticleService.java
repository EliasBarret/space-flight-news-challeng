package com.ebff.challenge.spaceflightnews.service;

import com.ebff.challenge.spaceflightnews.model.Article;
import com.ebff.challenge.spaceflightnews.model.dto.ArticleDto;
import com.ebff.challenge.spaceflightnews.util.Response;
import org.springframework.data.domain.Page;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IArticleService {
    /*
    * Method to find the Articles all
    * @return
    */
    Page<Article> findAll(Pageable pageable);

    /*
     * Method to find the Articles all
     * @return
     */
    Article findById(Long id);

    /*
     * Method to find the Articles all
     * @return
     */
    Article update(Article article, Long id);

    /*
     * Method to find the Articles all
     * @return
     */
    Response deleteById(Long id);

    /*
     * Method to find the Articles all
     * @return
     */
    Article insert(ArticleDto articleDto);
}
