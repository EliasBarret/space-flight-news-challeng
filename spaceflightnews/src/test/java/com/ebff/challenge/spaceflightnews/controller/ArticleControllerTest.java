package com.ebff.challenge.spaceflightnews.controller;

import com.ebff.challenge.spaceflightnews.model.Article;
import com.ebff.challenge.spaceflightnews.model.Event;
import com.ebff.challenge.spaceflightnews.model.Launch;
import com.ebff.challenge.spaceflightnews.repository.ArticleRepository;
import com.ebff.challenge.spaceflightnews.service.IArticleService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.ArrayList;
import java.util.List;

import static java.util.Optional.of;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@ExtendWith(SpringExtension.class)
@WebMvcTest(controllers = ArticleController.class)
class ArticleControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ArticleRepository articleRepository;

    @MockBean
    private IArticleService iArticleService;

    @Test
    public void findAllArticles() throws Exception{
        List<Article> articles = new ArrayList<>();
        List<Event> events = new ArrayList<>();
        List<Launch> launches = new ArrayList<>();

        articles.add(new Article(10L,
                            true,
                            "title",
                            "url",
                            "imageUrl",
                            "newsSite",
                            "summary",
                            "publishedAt",
                            events,
                            launches));

        when(articleRepository.findAll()).thenReturn(articles);

        this.mockMvc.perform(get("/articles"))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    public void findById() throws Exception{
        List<Event> events = new ArrayList<>();
        List<Launch> launches = new ArrayList<>();

        Article article = new Article(10L,
                                true,
                                "title",
                                "url",
                                "imageUrl",
                                "newsSite",
                                "summary",
                                "publishedAt",
                                events,
                                launches);

        when(articleRepository.findById(10l)).thenReturn(of(article));

        this.mockMvc.perform(get("/articles/10"))
                .andExpect(status().isOk());
    }

    @Test
    public void alter() throws Exception {
        List<Event> events = new ArrayList<>();
        List<Launch> launches = new ArrayList<>();

        Article article = new Article(10L,
                true,
                "title",
                "url",
                "imageUrl",
                "newsSite",
                "summary",
                "publishedAt",
                events,
                launches);

        when(articleRepository.save(article)).thenReturn(article);

        this.mockMvc.perform(get("/articles/10"))
                .andExpect(status().isOk());

    }

    @Test
    public void create() throws Exception{
        List<Event> events = new ArrayList<>();
        List<Launch> launches = new ArrayList<>();

        Article article = new Article(10L,
                                true,
                                "title",
                                "url",
                                "imageUrl",
                                "newsSite",
                                "summary",
                                "publishedAt",
                                events,
                                launches);

        when(articleRepository.save(article)).thenReturn(article);
        this.mockMvc.perform(get("/articles"))
                                .andExpect(status().isOk());
    }

    @Test
    public void delete() throws Exception{
        List<Event> events = new ArrayList<>();
        List<Launch> launches = new ArrayList<>();

        Article article = new Article(10L,
                true,
                "title",
                "url",
                "imageUrl",
                "newsSite",
                "summary",
                "publishedAt",
                events,
                launches);

        when(articleRepository.findById(10l)).thenReturn(of(article));

        articleRepository.deleteById(10l);
        verify(articleRepository).deleteById(10l);
    }
}
