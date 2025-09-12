import com.codeborne.selenide.Condition;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.Severity;
import io.qameta.allure.TmsLink;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static io.qameta.allure.SeverityLevel.*;
import static org.openqa.selenium.By.linkText;

public class SelenideTest extends BaseTest {



    @TmsLink("sdfdsfd")
    @Severity(BLOCKER)
    @Test
    public void testIssueSearch(){

        SelenideLogger.addListener("allure", new AllureSelenide());

        $("[data-target='qbsearch-input.inputButtonText']").click();
        $("#query-builder-test").click();
        $("#query-builder-test").setValue("eroshenkoam/allure-example").pressEnter();

        $(linkText("eroshenkoam/allure-example")).click();
        $("[data-content='Pull requests']").click();
        $(withText("#91")).should(Condition.exist);


    }
}
