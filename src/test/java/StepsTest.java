import com.codeborne.selenide.Condition;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.Severity;
import io.qameta.allure.TmsLink;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;
import static io.qameta.allure.SeverityLevel.*;
import static org.openqa.selenium.By.linkText;

public class StepsTest {

public static final String REPOSITORY = "eroshenkoam/allure-example";
public static final int PUlLREQUESTS = 91;

    @TmsLink("sfdgsfgsfg")
    @Severity(CRITICAL)
    @Test
    public void testLamblaStep(){

        SelenideLogger.addListener("allure", new AllureSelenide());

        step("��������� ������� ��������", () -> {
            open("https://github.com");
        });

        step("���� ����������� " + REPOSITORY, () -> {
            $("[data-target='qbsearch-input.inputButtonText']").click();
            $("#query-builder-test").click();
            $("#query-builder-test").setValue(REPOSITORY).pressEnter();
        });

        step("������� �� ������ ����������� " + REPOSITORY, () -> {
            $(linkText(REPOSITORY)).click();
        });

        step("��������� ��� Pull requests", () -> {
            $("[data-content='Pull requests']").click();
        });

        step("��������� ������� Pull requests � ������� " + PUlLREQUESTS, () ->{
            $(withText("#" + PUlLREQUESTS)).should(Condition.exist);
        });
    }

    @Test
    public void testAnnotationStep(){
        SelenideLogger.addListener("allure", new AllureSelenide());

        WebSteps webSteps = new WebSteps();

        webSteps.openMainPage();
        webSteps.searchForRepository(REPOSITORY);
        webSteps.clickOnRepositoryLink(REPOSITORY);
        webSteps.openPullRequests();
        webSteps.shouldSeePullRequestsWithNumber(PUlLREQUESTS);

    }
}