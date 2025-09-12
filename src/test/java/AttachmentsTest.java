import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.Severity;
import io.qameta.allure.TmsLink;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.Test;

import java.util.Objects;

import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.attachment;
import static io.qameta.allure.Allure.step;
import static io.qameta.allure.SeverityLevel.*;

public class AttachmentsTest {

    @TmsLink("sfdgsfgsfg")
    @Severity(CRITICAL)
    @Test
    public void testLamblaAttachments(){

        SelenideLogger.addListener("allure", new AllureSelenide());

        step("Открываем главную страницу", () -> {
            open("https://github.com");
            attachment("Source", Objects.requireNonNull(webdriver().driver().source()));
        });

    }

    @Test
    public void testAnnotationAttachmentsp(){
        SelenideLogger.addListener("allure", new AllureSelenide());

        WebSteps webSteps = new WebSteps();

        webSteps.openMainPage();
        webSteps.takeScreenshot();

    }
}

