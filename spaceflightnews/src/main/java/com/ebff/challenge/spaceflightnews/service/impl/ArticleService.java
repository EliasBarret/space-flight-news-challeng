package com.ebff.challenge.spaceflightnews.service.impl;

import com.ebff.challenge.spaceflightnews.exception.CustomException;
import com.ebff.challenge.spaceflightnews.model.Article;
import com.ebff.challenge.spaceflightnews.model.dto.ArticleDto;
import com.ebff.challenge.spaceflightnews.repository.ArticleRepository;
import com.ebff.challenge.spaceflightnews.service.IArticleService;
import com.ebff.challenge.spaceflightnews.util.Constants;
import com.ebff.challenge.spaceflightnews.util.Response;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ArticleService implements IArticleService {

    private final ArticleRepository articleRepository;

    @Override
    public Page<Article> findAll(Pageable pageable) {
        return articleRepository.findAll(pageable);
    }

    @Override
    public Article findById(Long id) {
        try{
            var article = articleRepository.findById(id);
            return article.get();
        }catch (Exception e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Resource Not Found", e);
        }
    }

    @Override
    public Article update(Article article, Long id) {
        Optional<Article> art = articleRepository.findById(id);

        if(art.isPresent()){
            art.get().setFeatured(article.getFeatured());
            art.get().setTitle(article.getTitle());
            art.get().setUrl(article.getUrl());
            art.get().setImageUrl(article.getImageUrl());
            art.get().setNewsSite(article.getNewsSite());
            art.get().setSummary(article.getSummary());
            art.get().setPublishedAt(article.getPublishedAt());

            return articleRepository.save(art.get());
        }else{
            throw new CustomException(Constants.ARTICLE_NOT_FOUND);
        }
    }

    @Override
    public Response deleteById(Long id) {
       Optional<Article> article = articleRepository.findById(id);

       if(article.isPresent()) {
           articleRepository.deleteById(id);
           return new Response(Constants.SUCESS, Constants.DELETED_SUCCESSFUL);
       }else{
           throw new CustomException(Constants.ARTICLE_NOT_FOUND);
       }
    }

    public Article insert(ArticleDto articleDto) {
        ModelMapper modelMapper = new ModelMapper();
        Article article = modelMapper.map(articleDto, Article.class);

        return articleRepository.save(article);
    }
}
