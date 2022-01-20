package com.ebff.challenge.spaceflightnews.model;

import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "spaceflightCL")
@Data
@Getter
@Setter
public class Event {

    private String id;
    private String provider;
}
