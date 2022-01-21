package com.ebff.challenge.spaceflightnews.scheduling;

import com.ebff.challenge.spaceflightnews.model.Article;
import com.ebff.challenge.spaceflightnews.repository.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Component
public class ScheduledCronSync {

    @Autowired
    private ArticleRepository articleRepository;

    private List<Article> articlesApi, articlesDb;

    @Scheduled(cron = "0 18 18 * * *")
    public void scheduledSync() {
        if(verifyData()){
            //sychronizeDatas();
        }
    }

    public Boolean verifyData(){
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Article[]> response = restTemplate.getForEntity("https://api.spaceflightnewsapi.net/v3/articles/", Article[].class);
        this.articlesApi = Arrays.asList(response.getBody());
        this.articlesDb = articleRepository.findAll();

        return articlesApi.size() > articlesDb.size();
    }
}
