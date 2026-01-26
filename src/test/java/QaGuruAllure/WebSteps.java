package QaGuruAllure;

import com.codeborne.selenide.WebDriverRunner;
import io.qameta.allure.Attachment;
import io.qameta.allure.Step;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class WebSteps {

    @Step("Открыть главную страницу")
    public void openMainPage() {
        open("https://github.com/");
    }

    @Step("ввести в поле поиска selenide и нажать enter")
    public void enterSelenide() {
        $("button.header-search-button").click();
        $("#query-builder-test").setValue("selenide").pressEnter();
    }

    @Step("кликнуть на первый репозиторий из списка найденных")
    public void clickFirstRepository() {
        $$("[data-testid=results-list] div").first().$("a").click();
    }

    @Step("проверка: заголовок selenide/selenide")
    public void checkTitle() {
        $("#repository-container-header").shouldHave(text("selenide / selenide"));
    }

    @Attachment(value = "Screenshot", type = "image/png", fileExtension = "png")
    public byte[] takeScreenshot() {
        return ((TakesScreenshot)WebDriverRunner.getWebDriver()).getScreenshotAs(OutputType.BYTES);
    }
}