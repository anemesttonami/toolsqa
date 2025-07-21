import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class GitHubSteps {

    @Step("открываем главную страницу github")
    public void openMainPage() {
        open("https://github.com");
        
    }

    @Step("клик по поиску")
    public void searchClick() {
        $("span[data-target='qbsearch-input.inputButtonText']").click();
        
    }

    @Step("ввод репозитория + enter")
    public void passValuesToSearch() {
        $("#query-builder-test").setValue("anemesttonami/toolsqa").pressEnter();
        
    }

    @Step("клик по гиперссылке репозитория")
    public void hyperlinkClick() {
        $("a[href='/anemesttonami/toolsqa']").click();
        
    }

    @Step("проверяем , что раздел Issue существует")
    public void isIssueSectionPresent() {
        $("span[data-content='Issues']").should(Condition.exist);
        
    }
}
