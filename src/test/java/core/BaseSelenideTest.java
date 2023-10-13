package core;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;

public class BaseSelenideTest {

    @BeforeAll
    public static void beforeAll() {
        Configuration.browserSize = "1920x1080";
    }
}
