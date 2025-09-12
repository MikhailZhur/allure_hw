import org.junit.jupiter.api.BeforeAll;

import static com.codeborne.selenide.Selenide.open;

public class BaseTest {
    @BeforeAll
    public static void beforeAll(){

        open("https://github.com");
    }
}
