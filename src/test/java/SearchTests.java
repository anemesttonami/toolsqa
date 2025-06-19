import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;


import static com.codeborne.selenide.Selenide.*;

public class SearchTests {

    @BeforeAll
    static void cofigureWebdriverForTests() {
        Configuration.baseUrl = "https://demoqa.com/automation-practice-form";
        Configuration.browserSize = "1980x1020";
        Configuration.pageLoadStrategy = "eager";
    }

    @Test
    void successfulSearchTest() {
        open("");
        $("#firstName").setValue("Виктор");
        $("#lastName").setValue("Степаныч");
        $("#userEmail").setValue("vs@mail.ru");
        $("label[for=gender-radio-1]").click();
        $("#userNumber").setValue("0123456789");
        $("#dateOfBirthInput").shouldBe(Condition.visible).click();
        $$("[role='option']").filter(Condition.visible).first().click();
        $("#subjectsContainer input").setValue("12341241");
        $("label[for=hobbies-checkbox-1]").click();
        $("#uploadPicture").uploadFromClasspath("image.png");
        $("#currentAddress").setValue("Карла Фаберже");
        $("#state").click();
        $("#react-select-3-option-0").click();
        $("#city").click();
        $("#react-select-4-option-1").click();
        $("#submit").click();
        $("#example-modal-sizes-title-lg").shouldBe(Condition.innerText("Thanks for submitting the form"));
    }
}