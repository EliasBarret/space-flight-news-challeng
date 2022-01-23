package com.ebff.challenge.spaceflightnews.controller;

import com.ebff.challenge.spaceflightnews.model.Article;
import com.ebff.challenge.spaceflightnews.model.dto.ArticleAlterDto;
import com.ebff.challenge.spaceflightnews.service.IArticleService;

import com.ebff.challenge.spaceflightnews.util.Constants;
import com.ebff.challenge.spaceflightnews.util.Response;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import org.modelmapper.ModelMapper;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import org.springframework.data.domain.Pageable;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping
@RequiredArgsConstructor
@Api(value = "Article")
public class ArticleController {

    private static final Logger LOGGER = LoggerFactory.getLogger(ArticleController.class);
    private final IArticleService iArticleService;

    @ApiOperation(value = "Show all Articles")
    @GetMapping("/articles")
    public ResponseEntity<Page<Article>> findAll(@PageableDefault(sort = "id", direction = Sort.Direction.ASC) Pageable pageable){
        try{
            var allArticles = iArticleService.findAll(pageable);
            return ResponseEntity.ok(allArticles);
        }catch (RuntimeException exc){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Resource Not Found", exc);
        }
    }

    @ApiOperation(value = "Show Article by Id")
    @GetMapping("/articles/{id}")
    public ResponseEntity<Article> findById(@PathVariable("id") Long id, Pageable pageable){
        return new ResponseEntity(iArticleService.findById(id), HttpStatus.OK);
    }

    @ApiOperation(value = "Alter Article by Id")
    @PutMapping("/articles/{id}")
    public ResponseEntity<Article> alter(@RequestBody ArticleAlterDto articleAlterDto, @PathVariable Long id){
        Article article = new ModelMapper().map(articleAlterDto, Article.class);
        return new ResponseEntity<>(iArticleService.update(article, id), HttpStatus.OK);
    }

    @ApiOperation(value = "Delete Article by Id")
    @DeleteMapping("/articles/{id}")
    public ResponseEntity<Response> delete(@PathVariable Long id){
        return new ResponseEntity(iArticleService.deleteById(id), HttpStatus.OK);
    }

    @ApiOperation(value = "Added New Article")
    @PostMapping("/articles")
    public ResponseEntity<List<Article>> create(@RequestBody @Valid List<Article> articles){
        URI location = ServletUriComponentsBuilder
                    .fromCurrentRequest().path("/articles/")
                    .buildAndExpand(iArticleService.insert(articles)).toUri();
        return ResponseEntity.created(location).build();
    }
}
