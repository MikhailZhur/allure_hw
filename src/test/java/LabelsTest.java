import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;



public class LabelsTest {

    @Test
    @Feature("Pull requests � �����������")
    @Story("�������� Pull requests")
    @Owner("mzhuravlev")
    @Severity(SeverityLevel.BLOCKER)
    @Link(value = "Testing", url = "https://testing.github.com")
    @DisplayName("�������� ���� �������� ��������������� ������������")
    public void testStaticLabels() {

    }

    @Test
    public void testDynamicLabels() {
        Allure.getLifecycle().updateTestCase(
                t -> t.setName("�������� Issue ��� ��������������� ������������")
        );
        Allure.feature("Issue � �����������");
        Allure.story("�������� Issue");
        Allure.label("owner", "eroshenkoam");
        Allure.label("severity", SeverityLevel.CRITICAL.value());
        Allure.link("Testing", "https://testing.github.com");
    }
}
