package com.ebff.challenge.spaceflightnews.service;

import com.ebff.challenge.spaceflightnews.model.Article;
import com.ebff.challenge.spaceflightnews.util.Response;
import org.springframework.data.domain.Page;

import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IArticleService {
    /*
    * Method to find the Articles all
    * @return
    */
    Page<Article> findAll(Pageable pageable);

    /*
     * Method to find by id the Articles
     * @return
     */
    Article findById(Long id);

    /*
     * Method to Update register the Articles
     * @return
     */
    Article update(Article article, Long id);

    /*
     * Method to delete register the Articles all
     * @return
     */
    Response deleteById(Long id);

    /*
     * Method to Save new register Articles
     * @return
     */
    List<Article> insert(List<Article> articles);
}
