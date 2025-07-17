package com.demoqa.tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class BaseRegistrationTest {

    @BeforeAll
    static void cofigureWebdriverForTests() {
        Configuration.baseUrl = "https://demoqa.com";
        configureLocalDriver();
    }

    @AfterAll
    static void closeDriver() {
        WebDriverRunner.closeWebDriver();
    }

    private static void configureLocalDriver() {
        ChromeOptions options = new ChromeOptions();
        String homeDirectory = System.getProperty("user.home");

        String chromeDriverPath = homeDirectory + "/Desktop/chromedriverfolder/chromedriver-mac-x64/chromedriver";
        String chromeBinaryPath = homeDirectory +
                "/Desktop/chromedriverfolder/chrome-mac-x64/Google Chrome for Testing.app/Contents/MacOS/Google Chrome for Testing";

        if (chromeDriverPath == null || chromeBinaryPath == null) {
            throw new IllegalStateException("Одна или обе переменные окружения не заданы !");
        }

        System.setProperty("webdriver.chrome.driver", chromeDriverPath);
        options.setBinary(chromeBinaryPath);
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().setSize(new Dimension(1920, 1080));
        driver.manage().window().setPosition(new Point(2, 2));
        WebDriverRunner.setWebDriver(driver);
    }
}