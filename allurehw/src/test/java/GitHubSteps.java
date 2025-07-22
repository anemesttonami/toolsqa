import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;

public class GitHubSteps {

    public void openMainPage() {
        step("открываем главную страницу github", () -> open("https://github.com"));
    }

    public void searchClick() {
        step("клик по поиску", () -> $("span[data-target='qbsearch-input.inputButtonText']").click());
    }

    public void passValuesToSearch() {
        step("ввод репозитория + enter", () -> $("#query-builder-test").setValue("anemesttonami/toolsqa").pressEnter());
    }

    public void hyperlinkClick() {
        step("клик по гиперссылке репозитория", () -> $("a[href='/anemesttonami/toolsqa']").click());
    }

    public void isIssueSectionPresent() {
        step("проверяем , что раздел Issue существует", () -> $("span[data-content='Issues']").should(Condition.exist));
    }
}
