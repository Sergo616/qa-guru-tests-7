package QaGuruAllure;

import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LabelsTest {

    @Test
    @Feature("Issue в репозитории")
    @Story("Создание Issue")
    @Owner("Isaichenko")
    @Severity(SeverityLevel.BLOCKER)
    @Link(value = "Google link", url = "https://google.com")

    @DisplayName("Создание Issue для авторизованного пользователя")
    public void testStaticLabels() {
    }

    @Test
    public void testDynamicLabels() {
        Allure.getLifecycle().updateTestCase(t -> t.setName("Создание Issue для авторизованного пользователя"));
        Allure.feature("Issue в репозитории");
        Allure.story("Создание Issue");
        Allure.label("owner", "Isaichenko");
        Allure.label("severity", SeverityLevel.CRITICAL.value());
        Allure.link("Google link", "https://google.com");
    }
}

