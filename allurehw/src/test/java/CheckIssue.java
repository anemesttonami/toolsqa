import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;

public class CheckIssue {

    @BeforeAll
    static void cofigureWebdriverForTests() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1980x1020";
        Configuration.pageLoadStrategy = "eager";
        SelenideLogger.addListener("allure", new AllureSelenide());
    }

    @Test
    public void chekIssueClearSelenide() {
        open("https://github.com");
        $("span[data-target='qbsearch-input.inputButtonText']").click();
        $("#query-builder-test").setValue("anemesttonami/toolsqa").pressEnter();
        $("a[href='/anemesttonami/toolsqa']").click();
        $("span[data-content='Issues']").should(Condition.exist);
    }

    @Test
    public void chekIssueThroughStepWithLambda() {
        step("открываем главную страницу github", () -> open("https://github.com"));
        step("клик по поиску", () -> $("span[data-target='qbsearch-input.inputButtonText']").click());
        step("ввод репозитория + enter", () -> $("#query-builder-test").setValue("anemesttonami/toolsqa").pressEnter());
        step("клик по гиперссылке репозитория", () -> $("a[href='/anemesttonami/toolsqa']").click());
        step("проверяем , что раздел Issue существует", () -> $("span[data-content='Issues']").should(Condition.exist));
    }

    @Test
    public void chekIssueThroughStepInMethods() {
        GitHubSteps ghs = new GitHubSteps();
        ghs.openMainPage();
        ghs.searchClick();
        ghs.passValuesToSearch();
        ghs.hyperlinkClick();
        ghs.isIssueSectionPresent();
    }
}
