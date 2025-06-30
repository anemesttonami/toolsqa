package com.demoqa.tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.BeforeAll;

import static com.codeborne.selenide.Selenide.open;

public class BaseRegistrationTest {

    @BeforeAll
    static void cofigureWebdriverForTests() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1980x1020";
        Configuration.pageLoadStrategy = "eager";
    }

    public void openStartPage() {
        open("/automation-practice-form");
    }
}
