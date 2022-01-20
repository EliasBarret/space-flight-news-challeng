package com.ebff.challenge.spaceflightnews.model;

import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "spaceflightCL")
@Data
@Getter
@Setter
public class Launch {

    private String id;
    private String provider;
}
