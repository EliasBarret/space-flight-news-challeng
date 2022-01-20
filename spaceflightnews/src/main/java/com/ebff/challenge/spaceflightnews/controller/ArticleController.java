package com.ebff.challenge.spaceflightnews.controller;

import com.ebff.challenge.spaceflightnews.model.Article;
import com.ebff.challenge.spaceflightnews.model.dto.ArticleAlterDto;
import com.ebff.challenge.spaceflightnews.model.dto.ArticleDto;
import com.ebff.challenge.spaceflightnews.service.IArticleService;

import com.ebff.challenge.spaceflightnews.util.Constants;
import com.ebff.challenge.spaceflightnews.util.Response;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import org.modelmapper.ModelMapper;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import javax.validation.Valid;
import java.net.URI;

@Slf4j
@RestController
@RequestMapping
@RequiredArgsConstructor
public class ArticleController {

    private static final Logger LOGGER = LoggerFactory.getLogger(ArticleController.class);
    private final IArticleService iArticleService;

    @GetMapping("/")
    public String message(){
        return Constants.MESSAGE_TITLE;
    }

    @GetMapping("/articles")
    public ResponseEntity<Page<Article>> findAll(Pageable pageable){
        try{
            var allArticles = iArticleService.findAll(pageable);
            return ResponseEntity.ok(allArticles);
        }catch (RuntimeException exc){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Resource Not Found", exc);
        }
    }

    @GetMapping("/articles/{id}")
    public ResponseEntity<Article> findById(@PathVariable("id") Long id){
        return new ResponseEntity<>(iArticleService.findById(id), HttpStatus.OK);
    }

    @PutMapping("/articles/{id}")
    public ResponseEntity<Article> alter(@RequestBody ArticleAlterDto articleAlterDto, @PathVariable Long id){
        Article article = new ModelMapper().map(articleAlterDto, Article.class);
        return new ResponseEntity<>(iArticleService.update(article, id), HttpStatus.OK);
    }

    @DeleteMapping("/articles/{id}")
    public ResponseEntity<Response> delete(@PathVariable Long id){
        return new ResponseEntity(iArticleService.deleteById(id), HttpStatus.OK);
    }

    @PostMapping("/articles")
    public ResponseEntity<Article> create(@RequestBody @Valid ArticleDto articleDto){
        Article article = new ModelMapper().map(articleDto, Article.class);
        URI location = ServletUriComponentsBuilder
                    .fromCurrentRequest().path("/articles/")
                    .buildAndExpand(iArticleService.insert(articleDto).getId()).toUri();
        return ResponseEntity.created(location).build();
    }
}
