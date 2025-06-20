import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class OpenSelenidePage {

    @BeforeAll
    static void cofigureWebdriverForTests() {
        Configuration.baseUrl = "https://github.com/selenide/selenide";
        Configuration.browserSize = "1980x1020";
        Configuration.pageLoadStrategy = "eager";
    }
    
    @Test
    void successfulSearchTest() {
        open("");
        $("#wiki-tab").click();
        $(byText("Soft assertions")).click();

        //проверка: заголовок про Junit5 существует и его видно
        $("#user-content-3-using-junit5-extend-test-class")
                .parent()
                .$$("*")
                .find(exactText("3. Using JUnit5 extend test class:"))
                .shouldBe(visible);

        //проверка: код про Junit5 существует и его видно
        $("#user-content-3-using-junit5-extend-test-class")
                .parent()
                .sibling(0)
                .shouldHave(exactText("@ExtendWith({SoftAssertsExtension.class})\n" +
                        "class Tests {\n" +
                        "  @Test\n" +
                        "  void test() {\n" +
                        "    Configuration.assertionMode = SOFT;\n" +
                        "    open(\"page.html\");\n" +
                        "\n" +
                        "    $(\"#first\").should(visible).click();\n" +
                        "    $(\"#second\").should(visible).click();\n" +
                        "  }\n" +
                        "}"))
                .shouldBe(visible);
    }
}