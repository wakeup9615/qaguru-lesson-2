package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;

public class TestBase {
    @BeforeAll // выполняется 1 раз перед всеми тестами
    static void beforeAll() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920x1080"; //задать размер окна
        //Configuration.holdBrowserOpen = true; //чтобы бразузер после теста не закрывался
    }
}
