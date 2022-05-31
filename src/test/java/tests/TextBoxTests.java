package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class TextBoxTests {

    @BeforeAll // выполняется 1 раз перед всеми тестами
    static void beforeAll() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920x1080"; //задать размер окна
        //Configuration.holdBrowserOpen = true; //чтобы бразузер после теста не закрывался
    }

    @Test
    void successfulTest() {

        String name = "Alex";

        open("/text-box");
        executeJavaScript("$('footer').remove()"); // удаляет рекламу (executeJavaScript - выполняет код на стороне браузера)
        executeJavaScript("$('#fixedben').remove()");

        $("[id=userName]").setValue(name); //ввод данных
        $("[id=userEmail]").setValue("alex@egorov.com");
        $("[id=currentAddress]").setValue("Some address 1");
        $("[id=permanentAddress]").setValue("Another address 2");
        $("[id=submit]").click(); //клик по кнопке
        $("[id=output]").shouldHave(text(name), // проверяет что элемент имеет данный текст
                text("alex@egorov.com"), text("Some address 1"), text("Another address 2"));
    }
}
