package com.demoqa.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class PracticeFormPage {
    public SelenideElement firstName = $("#firstName"),
            lastName = $("#lastName"),
            userEmail = $("#userEmail"),
            genderMaleRadio = $("label[for=gender-radio-1]"),
            userNumber = $("#userNumber"),
            dateOfBirthInput = $("#dateOfBirthInput");

    /*
        $("#firstName").setValue("Виктор");
        $("#lastName").setValue("Степаныч");
        $("#userEmail").setValue("vs@mail.ru");
        $("label[for=gender-radio-1]").click();
        $("#userNumber").setValue("0123456789");
        $("#dateOfBirthInput").shouldBe(Condition.visible).click();
        $$("[role='option']").filter(Condition.visible).first().click();

        $("#subjectsContainer input").setValue("12341241");
        $("label[for=hobbies-checkbox-1]").click();
        $("#uploadPicture").uploadFromClasspath("image.png");
        $("#currentAddress").setValue("Карла Фаберже");
        $("#state").click();
        $("#react-select-3-option-0").click();
        $("#city").click();
        $("#react-select-4-option-1").click();
        $("#submit").click();
        $("#example-modal-sizes-title-lg").shouldBe(Condition.innerText("Thanks for submitting the form"));
    }
     */
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

    public PracticeFormPage clickMaleGender() {
        genderMaleRadio.click();
        return this;
    }

    public PracticeFormPage setUserNumber(String number) {
        userNumber.setValue(number);
        return this;
    }
}
