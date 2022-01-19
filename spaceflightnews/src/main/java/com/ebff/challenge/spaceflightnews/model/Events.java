package com.ebff.challenge.spaceflightnews.model;

import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.annotation.Id;

@Document
@Getter
@Setter
public class Events {

    @Id
    private String id;
    private String provider;
}
