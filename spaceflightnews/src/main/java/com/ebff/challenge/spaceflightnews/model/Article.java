package com.ebff.challenge.spaceflightnews.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "spaceflightCL")
@Data
@Getter
@Setter
public class Article {

    @Id
    @JsonProperty
    private Long id;
    private Boolean featured;
    private String title;
    private String url;
    private String imageUrl;
    private String newsSite;
    private String summary;
    private String publishedAt;

    private List<Event> events;

    private List<Launch> launches;

}
