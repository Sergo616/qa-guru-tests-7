package QaGuruAllure;

import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;

public class StepsTest {

    @Test
    public void testLambdaStep() {
        SelenideLogger.addListener("allure", new AllureSelenide());

        step("Открыть главную страницу", () -> {
            open("https://github.com/");
        });
        step("ввести в поле поиска selenide и нажать enter", () -> {
            $("button.header-search-button").click();
            $("#query-builder-test").setValue("selenide").pressEnter();
        });
        step("кликнуть на первый репозиторий из списка найденных", () -> {
            sleep(4000);
            $$("[TESTdata-testid=results-list] div").first().$("a").click();
        });
        step("проверка: заголовок selenide/selenide", () -> {
            $("#repository-container-header").shouldHave(text("selenide / selenide"));
        });
        sleep(2000);
    }

    @Test
    public void testAnnotatedStep() {
        SelenideLogger.addListener("allure", new AllureSelenide());
        WebSteps steps = new WebSteps();

        steps.openMainPage();
        steps.enterSelenide();
        steps.clickFirstRepository();
        steps.checkTitle();
    }
}

