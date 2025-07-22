package com.demoqa.pages;

import com.codeborne.selenide.SelenideElement;
import com.demoqa.pages.components.CalendarComponent;
import org.openqa.selenium.Keys;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;


public class PracticeFormPage {
    private static final SelenideElement
            FIRST_NAME_INPUT = $("#firstName"),
            LAST_NAME_INPUT = $("#lastName"),
            USER_EMAIL_INPUT = $("#userEmail"),
            GENDER_MALE_RADIO = $("label[for=gender-radio-1]"),
            GENDER_FEMALE_RADIO = $("label[for=gender-radio-2]"),
            GENDER_OTHER_RADIO = $("label[for=gender-radio-3]"),
            USER_NUMBER_INPUT = $("#userNumber"),
            DATE_OF_BIRTH_INPUT = $("#dateOfBirthInput"),
            SUBJECTS_INPUT = $("#subjectsContainer input"),
            HOBBIES_SPORTS = $("label[for=hobbies-checkbox-1]"),
            HOBBIES_READING = $("label[for=hobbies-checkbox-2]"),
            HOBBIES_MUSIC = $("label[for=hobbies-checkbox-3]"),
            UPLOAD_PICTURE = $("#uploadPicture"),
            CURRENT_ADDRESS_INPUT = $("#currentAddress"),
            STATE = $("#state"),
            CITY = $("#city"),
            SUBMIT = $("#submit"),
            THANKS_TITLE = $("#example-modal-sizes-title-lg");

    CalendarComponent calendar = new CalendarComponent();

    public PracticeFormPage openStartPage() {
        open("/automation-practice-form");
        $(".practice-form-wrapper").shouldHave(text("Student Registration Form"));
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");
        return this;
    }

    public PracticeFormPage setFirstName(String name) {
        FIRST_NAME_INPUT.setValue(name);
        return this;
    }

    public PracticeFormPage setLastName(String name) {
        LAST_NAME_INPUT.setValue(name);
        return this;
    }

    public PracticeFormPage setUserEmail(String email) {
        USER_EMAIL_INPUT.setValue(email);
        return this;
    }

    public PracticeFormPage setGender(String gender) {

        switch (gender) {
            case "Male":
                GENDER_MALE_RADIO.click();
                break;
            case "Female":
                GENDER_FEMALE_RADIO.click();
                break;
            case "Other":
                GENDER_OTHER_RADIO.click();
                break;
        }

        return this;
    }

    public PracticeFormPage setMobileNumber(String number) {
        USER_NUMBER_INPUT.setValue(number);
        return this;
    }

    public PracticeFormPage setDateOfBirth(String day, String month, String year) {
        DATE_OF_BIRTH_INPUT.click();
        calendar.setDateToCalendar(Integer.valueOf(day), month, year);
        return this;
    }

    public PracticeFormPage setSubjects(String subject) {
        SUBJECTS_INPUT.setValue(subject).sendKeys(Keys.ENTER);
        return this;
    }

    public PracticeFormPage setHobbies(String hobby) {
        if (hobby.equals("Sports")) {
            HOBBIES_SPORTS.click();
        } else if (hobby.equals("Reading")) {
            HOBBIES_READING.click();
        } else if (hobby.equals("Music")) {
            HOBBIES_MUSIC.click();
        }
        return this;
    }

    public PracticeFormPage uploadTestPicture() {
        UPLOAD_PICTURE.uploadFromClasspath("image.png");
        return this;
    }

    public PracticeFormPage setCurrentAddress(String address) {
        CURRENT_ADDRESS_INPUT.setValue(address);
        return this;
    }

    public PracticeFormPage setStateAndCity(String state, String city) {
        this.STATE.click();

        switch (state) {
            case "NCR":
                $("#react-select-3-option-0").click();
                break;
            case "Uttar Pradesh":
                $("#react-select-3-option-1").click();
                break;
            case "Haryana":
                $("#react-select-3-option-2").click();
                break;
            case "Rajasthan":
                $("#react-select-3-option-3").click();
                break;
        }

        this.CITY.click();

        switch (city) {
            case "Agra":
                $("#react-select-4-option-0").click();
                break;
            case "Lucknow":
                $("#react-select-4-option-1").click();
                break;
            case "Merrut":
                $("#react-select-4-option-2").click();
                break;
        }

        return this;
    }

    public PracticeFormPage submitForm() {
        SUBMIT.click();
        return this;
    }

    public PracticeFormPage checkThanksTitle() {
        THANKS_TITLE.shouldHave(exactText("Thanks for submitting the form"));
        return this;
    }
}
