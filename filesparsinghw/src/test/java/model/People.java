package model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class People {
    private final String group;
    private final Integer id;
    private final Details details;

    @JsonCreator
    public People(
            @JsonProperty("Group")
            String group,
            @JsonProperty("id")
            Integer id,
            @JsonProperty("Details")
            Details details) {
        this.group = group;
        this.id = id;
        this.details = details;
    }

    public Integer getId() {
        return id;
    }

    public Details getDetails() {
        return details;
    }
}