import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Keys;

import java.io.File;

import static com.codeborne.selenide.Selenide.*;

public class SearchTests {

    @BeforeAll
    static void cofigureWebdriverForTests(){
    Configuration.browserSize="1980x1020";
    Configuration.pageLoadStrategy = "eager";
    }

    @Test
    void successfulSearchTest() {
        open("https://demoqa.com/automation-practice-form");
        $("#firstName").setValue("Виктор");
        $("#lastName").setValue("Степаныч");
        $("#userEmail").setValue("ВикторСтепаныч@mail.ru");
        $("label[for=gender-radio-1]").click();
        $("#userNumber").setValue("+79131234567");
        $("#dateOfBirthInput").shouldBe(Condition.visible).click();
        $$("[role='option']").filter(Condition.visible).first().click();
        $("#subjectsContainer input").setValue("12341241");
        $("label[for=hobbies-checkbox-1]").click();
        File file = new File("C:\\image.png");
        System.out.println("File exists ? : " + file.exists());
        $("#uploadPicture").uploadFile(file);
        $("#currentAddress").setValue("Карла Фаберже");
        $("#state").click();
        $("#react-select-3-option-0").click();
        $("#city").click();
        $("#react-select-4-option-1").click();
    }
}