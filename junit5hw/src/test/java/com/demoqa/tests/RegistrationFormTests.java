package com.demoqa.tests;

import com.codeborne.selenide.Condition;
import com.demoqa.data.Gender;
import com.demoqa.pages.PracticeFormPage;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.EnumSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;
import java.util.stream.Stream;

import static com.codeborne.selenide.Condition.cssValue;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$$;


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

    @ParameterizedTest (name = "Проверка ,что {0} гендер отображается в модальном окне Thanks")
    @ValueSource(strings = {"Male","Female","Other"})
    public void thanksModuleShouldDisplayAllGendersValueSource (String gender) {
        formPage.openStartPage()
                .setFirstName("Victor")
                .setLastName("S")
                .setUserEmail("test@test.com")
                .setGender(gender)
                .setMobileNumber("0123456789")
                .setDateOfBirth("1", "January", "2000")
                .setSubjects("English")
                .setHobbies("Sports")
                .uploadTestPicture()
                .setCurrentAddress("Address")
                .setStateAndCity("Haryana", "Lucknow")
                .submitForm()
                .checkThanksTitle();
        $$("tbody tr").find(text(gender)).shouldBe(Condition.visible);
    }

    @EnumSource(Gender.class)
    @ParameterizedTest (name = "Проверка ,что {0} гендер отображается в модальном окне Thanks")
    public void thanksModuleShouldDisplayAllGendersEnumSource (Gender gender) {
        formPage.openStartPage()
                .setFirstName("Victor")
                .setLastName("S")
                .setUserEmail("test@test.com")
                .setGender(gender.genderName)
                .setMobileNumber("0123456789")
                .setDateOfBirth("1", "January", "2000")
                .setSubjects("English")
                .setHobbies("Sports")
                .uploadTestPicture()
                .setCurrentAddress("Address")
                .setStateAndCity("Haryana", "Lucknow")
                .submitForm()
                .checkThanksTitle();
        $$("tbody tr").find(text(gender.genderName)).shouldBe(Condition.visible);
    }

    @MethodSource
    @ParameterizedTest (name = "Проверка ,что {0} гендер отображается в модальном окне Thanks")
    public void thanksModuleShouldDisplayAllGendersMethodSource (String gender) {
        formPage.openStartPage()
                .setFirstName("Victor")
                .setLastName("S")
                .setUserEmail("test@test.com")
                .setGender(gender)
                .setMobileNumber("0123456789")
                .setDateOfBirth("1", "January", "2000")
                .setSubjects("English")
                .setHobbies("Sports")
                .uploadTestPicture()
                .setCurrentAddress("Address")
                .setStateAndCity("Haryana", "Lucknow")
                .submitForm()
                .checkThanksTitle();
        $$("tbody tr").find(text(gender)).shouldBe(Condition.visible);
    }

    public static Stream<Arguments> thanksModuleShouldDisplayAllGendersMethodSource(){
        return Stream.of(
                Arguments.of("Male"),
                Arguments.of("Female"),
                Arguments.of("Other")
        );
    }

}