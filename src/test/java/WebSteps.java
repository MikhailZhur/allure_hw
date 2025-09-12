import com.codeborne.selenide.Condition;
import com.codeborne.selenide.WebDriverRunner;
import io.qameta.allure.Attachment;
import io.qameta.allure.Step;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.openqa.selenium.By.linkText;

public class WebSteps {

    @Step("��������� ������� ��������")
    public void openMainPage() {
        open("https://github.com");
    }

    @Step("���� ����������� {repo}")
    public void searchForRepository(String repo) {
        $("[data-target='qbsearch-input.inputButtonText']").click();
        $("#query-builder-test").click();
        $("#query-builder-test").setValue(repo).pressEnter();
    }

    @Step("������� �� ������ ����������� {repo}")
    public void clickOnRepositoryLink(String repo) {
        $(linkText(repo)).click();
    }

    @Step("��������� ��� Pull requests")
    public void openPullRequests() {
        $("[data-content='Pull requests']").click();
    }

    @Step("��������� ������� Pull requests � ������� {pr}")
    public void shouldSeePullRequestsWithNumber(int pr) {
        $(withText("#" + pr)).should(Condition.exist);

    }

    @Attachment(value = "Screenshot", type = "image/png", fileExtension = "png")
    public byte[] takeScreenshot() {
        return ((TakesScreenshot) WebDriverRunner.getWebDriver()).getScreenshotAs(OutputType.BYTES);
    }
}
