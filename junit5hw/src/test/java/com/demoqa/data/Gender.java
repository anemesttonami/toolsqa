package com.demoqa.data;

public enum Gender {
    MALE("Male"),
    FEMALE("Female"),
    OTHER("Other");

    public final String genderName;

    Gender(String gender) {
        this.genderName = gender;
    }
}
