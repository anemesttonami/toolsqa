package model;


import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Details {
    private final Integer peopleCount;
    private final String[] peopleNames;
    private final String location;

    @JsonCreator
    public Details(
            @JsonProperty("peopleCount")
            Integer peopleCount,
            @JsonProperty("peopleNames")
            String[] peopleNames,
            @JsonProperty("location")
            String location) {
        this.peopleCount = peopleCount;
        this.peopleNames = peopleNames;
        this.location = location;
    }

    public Integer getPeopleCount() {
        return peopleCount;
    }

    public String[] getPeopleNames() {
        return peopleNames;
    }

    public String getLocation() {
        return location;
    }
}