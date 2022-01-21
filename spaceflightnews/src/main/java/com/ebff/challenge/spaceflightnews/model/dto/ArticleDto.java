package com.ebff.challenge.spaceflightnews.model.dto;

import com.ebff.challenge.spaceflightnews.model.Event;
import com.ebff.challenge.spaceflightnews.model.Launch;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ArticleDto {

    @JsonProperty
    private Long id;
    @JsonProperty("title")
    private String title;
    @JsonProperty("url")
    private String url;
    @JsonProperty("imageUrl")
    private String imageUrl;
    @JsonProperty("newsSite")
    private String newsSite;
    @JsonProperty("summary")
    private String summary;
    @JsonProperty("publishedAt")
    private String publishedAt;
    @JsonProperty("featured")
    private Boolean featured;

    @JsonProperty("launches")
    private List<Launch> launches;
    @JsonProperty("events")
    private List<Event> events;
}
