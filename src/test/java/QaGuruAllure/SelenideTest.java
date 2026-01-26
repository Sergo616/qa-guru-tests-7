package QaGuruAllure;

import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class SelenideTest {

    @Test
    public void testIssueSearch() {
        SelenideLogger.addListener("allure", new AllureSelenide());

        open("https://github.com/");
                //ввести в поле поиска selenide и нажать enter
                $("button.header-search-button").click();
                $("#query-builder-test").setValue("selenide").pressEnter();
                //кликнуть на первый репозиторий из списка найденных
                $$("[data-testid=results-list] div").first().$("a").click();
                //проверка: заголовок selenide/selenide
                $("#repository-container-header####################").shouldHave(text("selenide / selenide"));
                sleep(2000);
    }
}


