package QaGuruAllure;

import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.Allure;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;

public class AttachmentsTest {

    @Test
    public void testLambdaAttachments() {
        SelenideLogger.addListener("allure", new AllureSelenide());

        step("Открыть главную страницу", () -> {
            open("https://github.com/");
            Allure.addAttachment("Source", webdriver().driver().source());
        });
    }

    @Test
    public void testAnnotatedAttachments() {
        SelenideLogger.addListener("allure", new AllureSelenide());
        WebSteps steps = new WebSteps();

        steps.openMainPage();
        steps.takeScreenshot();
    }
}

