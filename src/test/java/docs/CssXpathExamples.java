package docs;

import org.openqa.selenium.By;

import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class CssXpathExamples {
    void cssXpathExamples() {
        //спец тестовый атрибут
        // <input type="email" class="inputtext login_form_input_box" name="email" id="email" data-testid="email">
        $("[data-testid=email]").setValue("123");//по атрибуту и его значению !!!
        $(by("data-testid", "email")).setValue("123");//по названию атрибуту

        //id
        // <input type="email" class="inputtext login_form_input_box" name="email" id="email">
        $("[id=email]").setValue("123");//по id и его знаечнию
        $("#email").setValue("123");//# = id !!!
        $(byId("email")).setValue("123");
        $(By.id("email")).setValue("123");
        $x("//*[@id='email']").setValue("123"); //xpath
        $(byXpath("//*[@id='email']")).setValue("123"); //xpath

        //name
        // <input type="email" class="inputtext login_form_input_box" name="email">
        $("[name=email]").setValue("123");
        $(byName("email")).setValue("123");//!!!

        //class
        // <input type="email" class="inputtext login_form_input_box" name="email">
        $("[class=login_form_input_box]").setValue("123");
        $(".login_form_input_box").setValue("123");//. = class !!!
        $(".inputtext.login_form_input_box").setValue("123"); //2 класса
        $("input.inputtext.login_form_input_box").setValue("123");
        $x("//input[@class='login_form_input_box']").setValue("123");
        $x("//input[@class='inputtext'][@class='login_form_input_box']").setValue("123");

        //если нужно достучаться до вложенного элемента
        // <div class="inputtext">
        //      <input type="email" class="login_form_input_box" name="email">
        // </div>
        $(".inputtext .login_form_input_box").setValue("123");

        //все локаторы выше по максимум
        // <input type="email" class="inputtext login_form_input_box" name="email" id="email" data-testid="email">
        $("input.inputtext.login_form_input_box#email[name=email][data-testid=email]").setValue("123");

        //по тексту
        // <div>Hello qa.guru</div>
        $x("//div[text()='Hello qa.guru']");
        $x("//div[contains(text(), 'ello qa.gur')]");
        $x("//div[text()[contains(.,'ello qa.gur')]]");
        //поиск по тексту средствами селенида
        $(byText("Hello qa.guru"));
        $(withText("ello qa.gur"));
    }
}