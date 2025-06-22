import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.interactions.Actions;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.withTagAndText;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.*;

public class SolutionsEnterprize {
    @BeforeAll
    static void cofigureWebdriverForTests() {
        Configuration.browserSize = "1980x1020";
    }

    @Test
    public void checkAiPowered(){
        open("https://github.com/git-guides");
        $(withTagAndText("button","Solutions"))
                .hover();
        $(withTagAndText("button","Solutions"))
                .sibling(0)
                .$(withText("Enterprises"))
                .hover()
                .click();
        $("#hero-section-brand-heading").shouldHave(Condition.exactText("The AI-powered\ndeveloper platform"));
    }



    @Test
    void dragAndDropWithActions() {
        open("https://the-internet.herokuapp.com/drag_and_drop");
        dragAndDropAndCheckResult($("#column-a"),$("#column-b"),"B","A");
    }


    protected void dragAndDropAndCheckResult(SelenideElement whatToDrag , SelenideElement dropTarget, String aMustHave,String bMustHave) {
        var columnA = whatToDrag;
        var columnB = dropTarget;

        Actions actions = new Actions(WebDriverRunner.getWebDriver());
        actions
                .clickAndHold(columnA)
                .moveToElement(columnB)
                .release()
                .perform();

        // Проверка: текст в колонках должен поменяться местами
        columnA.shouldHave(text(aMustHave));
        columnB.shouldHave(text(bMustHave));
    }
}