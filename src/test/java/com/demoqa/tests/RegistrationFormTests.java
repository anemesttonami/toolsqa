package com.demoqa.tests;

import com.codeborne.selenide.Condition;
import com.demoqa.pages.PracticeFormPage;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.*;

public class RegistrationFormTests extends BaseRegistrationTest {

    private static PracticeFormPage formPage = new PracticeFormPage();

    @Test
    void successfulSearchTest() {
        openStartPage();
        $("#firstName").setValue("Виктор");
        $("#lastName").setValue("Степаныч");
        $("#userEmail").setValue("vs@mail.ru");
        $("label[for=gender-radio-1]").click();
        $("#userNumber").setValue("0123456789");
        $("#dateOfBirthInput").shouldBe(Condition.visible).click();
        //  ЭТОТ СЕЛЕКТОР НЕ РАБОТАЕТ НАЙДИ ДРУГОЙ $$("[role='option']").filter(Condition.visible).first().click();
        $("#subjectsContainer input").setValue("12341241");
        $("label[for=hobbies-checkbox-1]").click();
       /* $("label[for=hobbies-checkbox-1]").click();
        $("#uploadPicture").uploadFromClasspath("image.png");
        $("#currentAddress").setValue("Карла Фаберже");
        $("#state").click();
        $("#react-select-3-option-0").click();
        $("#city").click();
        $("#react-select-4-option-1").click();
        $("#submit").click();
        $("#example-modal-sizes-title-lg").shouldBe(Condition.innerText("Thanks for submitting the form"));*/
    }
}