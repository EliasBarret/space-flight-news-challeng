package com.ebff.challenge.spaceflightnews.model;

import lombok.*;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.annotation.Id;

@Document
@Getter
@Setter
public class Articles {

    @Id
    private Long id;
    private Boolean featured;
    private String title;
    private String url;
    private String imageUrl;
    private String newsSite;
    private String summary;
    private String publishedAt;

    @DBRef
    private Events events;
    @DBRef
    private Launches launches;

}
