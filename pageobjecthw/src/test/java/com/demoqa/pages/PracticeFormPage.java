package com.demoqa.pages;

import com.codeborne.selenide.SelenideElement;
import com.demoqa.pages.components.CalendarComponent;
import org.openqa.selenium.Keys;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.executeJavaScript;
import static com.codeborne.selenide.Selenide.open;


public class PracticeFormPage {
    public SelenideElement
            firstName = $("#firstName"),
            lastName = $("#lastName"),
            userEmail = $("#userEmail"),
            genderMaleRadio = $("label[for=gender-radio-1]"),
            genderFemaleRadio = $("label[for=gender-radio-2]"),
            genderOtherRadio = $("label[for=gender-radio-3]"),
            userNumber = $("#userNumber"),
            dateOfBirthInput = $("#dateOfBirthInput"),
            subjects = $("#subjectsContainer input"),
            hobbiesSports = $("label[for=hobbies-checkbox-1]"),
            hobbiesReading = $("label[for=hobbies-checkbox-2]"),
            hobbiesMusic = $("label[for=hobbies-checkbox-3]"),
            uploadPicture = $("#uploadPicture"),
            currentAddress = $("#currentAddress"),
            state = $("#state"),
            city = $("#city"),
            submit = $("#submit"),
            thanksTitle = $("#example-modal-sizes-title-lg");

    CalendarComponent calendar = new CalendarComponent();

    public PracticeFormPage openStartPage() {
        open("/automation-practice-form");
        $(".practice-form-wrapper").shouldHave(text("Student Registration Form"));
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");
        return this;
    }

    public PracticeFormPage setFirstName(String name) {
        firstName.setValue(name);
        return this;
    }

    public PracticeFormPage setLastName(String name) {
        lastName.setValue(name);
        return this;
    }

    public PracticeFormPage setUserEmail(String email) {
        userEmail.setValue(email);
        return this;
    }

    public PracticeFormPage setGender(String gender) {

        switch (gender) {
            case "Male":
                genderMaleRadio.click();
                break;
            case "Female":
                genderFemaleRadio.click();
                break;
            case "Other":
                genderOtherRadio.click();
                break;
        }

        return this;
    }

    public PracticeFormPage setMobileNumber(String number) {
        userNumber.setValue(number);
        return this;
    }

    public PracticeFormPage setDateOfBirth(String day, String month, String year) {
        dateOfBirthInput.click();
        calendar.setDateToCalendar(Integer.valueOf(day), month, year);
        return this;
    }

    public PracticeFormPage setSubjects(String subject) {
        subjects.setValue(subject).sendKeys(Keys.ENTER);
        return this;
    }

    public PracticeFormPage setHobbies(String hobby) {
        if (hobby.equals("Sports")) {
            hobbiesSports.click();
        } else if (hobby.equals("Reading")) {
            hobbiesReading.click();
        } else if (hobby.equals("Music")) {
            hobbiesMusic.click();
        }
        return this;
    }

    public PracticeFormPage uploadTestPicture() {
        uploadPicture.uploadFromClasspath("image.png");
        return this;
    }

    public PracticeFormPage setCurrentAddress(String address) {
        currentAddress.setValue(address);
        return this;
    }

    public PracticeFormPage setStateAndCity(String state, String city) {
        this.state.click();

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

        this.city.click();

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
        submit.click();
        return this;
    }

    public PracticeFormPage checkThanksTitle() {
        thanksTitle.shouldHave(exactText("Thanks for submitting the form"));
        return this;
    }
}
