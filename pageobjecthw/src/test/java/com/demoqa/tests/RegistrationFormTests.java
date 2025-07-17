package com.demoqa.tests;

import com.demoqa.pages.PracticeFormPage;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static com.codeborne.selenide.Condition.cssValue;


public class RegistrationFormTests extends BaseRegistrationTest {

    private static PracticeFormPage formPage = new PracticeFormPage();

    @Test
    public void successfulRegistrationTest() {
        formPage.openStartPage()
                .setFirstName("Victor")
                .setLastName("S")
                .setUserEmail("test@test.com")
                .setGender("Male")
                .setMobileNumber("0123456789")
                .setDateOfBirth("1", "January", "2000")
                .setSubjects("English")
                .setHobbies("Sports")
                .uploadTestPicture()
                .setCurrentAddress("Address")
                .setStateAndCity("Haryana", "Lucknow")
                .submitForm()
                .checkThanksTitle();
    }

    @Test
    public void mobileNumberHasLessThan10DigitsTest() {
        formPage.openStartPage()
                .setMobileNumber("012345678")
                .submitForm();
        formPage.userNumber.shouldHave(cssValue("border-color", "rgb(220, 53, 69)"));
    }

    @Test
    public void genderNotSelectedTest() {
        formPage.openStartPage()
                .submitForm();
        formPage.genderMaleRadio.shouldHave(cssValue("border-color", "rgb(220, 53, 69)"));
        formPage.genderFemaleRadio.shouldHave(cssValue("border-color", "rgb(220, 53, 69)"));
        formPage.genderOtherRadio.shouldHave(cssValue("border-color", "rgb(220, 53, 69)"));
    }
}