package com.ebff.challenge.spaceflightnews.scheduling;

import com.ebff.challenge.spaceflightnews.exception.CustomException;
import com.ebff.challenge.spaceflightnews.model.Article;
import com.ebff.challenge.spaceflightnews.repository.ArticleRepository;
import com.ebff.challenge.spaceflightnews.util.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Component
public class CronJobSync {

    @Autowired
    private ArticleRepository articleRepository;

    private List<Article> articlesExternalApi, articlesApplicationCollection;

    @Scheduled(cron = "0 0 9 * * *")
    public void scheduledSync() {
        if(verifyData()){
            updateCollection();
        }
    }

    public Boolean verifyData(){
        try{
            RestTemplate restTemplate = new RestTemplate();
            ResponseEntity<Article[]> response = restTemplate.getForEntity("https://api.spaceflightnewsapi.net/v3/articles/", Article[].class);
            this.articlesExternalApi = Arrays.asList(response.getBody());
            this.articlesApplicationCollection = articleRepository.findAll();

            return articlesExternalApi.size() > articlesApplicationCollection.size();
        }catch (Exception exe){
            throw new CustomException(exe.getMessage());
        }
    }

    private void updateCollection() {
        articleRepository.insert(articlesExternalApi);
    }
}
