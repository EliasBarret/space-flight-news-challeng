package com.ebff.challenge.spaceflightnews.model;

import lombok.*;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;


import java.util.List;

@Document(collection = "spaceflightCL")
@Data
@Getter
@Setter
public class Article {

    @Id
    private ObjectId _id;
    private Long id;
    private Boolean featured;
    private String title;
    private String url;
    private String imageUrl;
    private String newsSite;
    private String summary;
    private String publishedAt;

    @DBRef
    private List<Event> events;
    @DBRef
    private List<Launch> launches;

}
