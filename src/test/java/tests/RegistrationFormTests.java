package tests;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.$;

public class RegistrationFormTests extends TestBase{
    @Test
    void successfulTest() {
        String firstName = "Alex";
        String lastName = "Egorov";

        open("/automation-practice-form");
        $(".practice-form-wrapper").shouldHave(text("Student Registration Form"));
        executeJavaScript("$('footer').remove()");
        executeJavaScript("$('#fixedban').remove()");

        $("#firstName").setValue(firstName);
        $("#lastName").setValue(lastName);
        $("#userEmail").setValue("alex@egorov.com");
        $("#genterWrapper").$(byText("Other")).click(); //ок
//        $("#gender-radio-3").parent().click(); // ок, клик по элементу на уровень выше
//        $("#gender-radio-3").click(); // не сработает, тк перекрыт другим элементом
//        $(byText("Other")).click(); // плохо, тк будет искать элемент по всей странице
//        $("[for=gender-radio-3]").click(); //норм
        $("#userNumber").setValue("1231231230");
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption("July");
        $(".react-datepicker__year-select").selectOption("2008");
        $(".react-datepicker__day--030:not(.react-datepicker__day--outside-month)").click();// not в сss значит чтобы не было класса
//<div class="react-datepicker__day react-datepicker__day--030 react-datepicker__day--outside-month" aria-label="Choose Monday, June 30th, 2008">30</div>
//<div class="react-datepicker__day react-datepicker__day--030"                                      aria-label="Choose Wednesday, July 30th, 2008" >30</div>
        $("#subjectsInput").sendKeys("Maths");
        $("#subjectsInput").pressEnter();
        $("#hobbiesWrapper").$(byText("Sports")).click();
        $("#uploadPicture").uploadFromClasspath("img/summer.jpeg");
//        $("#uploadPicture").uploadFile(new File("src/test/resources/img/summer.jpeg"));
        $("#currentAddress").setValue("Some street 1");
        $("#state").click();
        $("#stateCity-wrapper").$(byText("NCR")).click();
        $("#city").click();
        $("#stateCity-wrapper").$(byText("Delhi")).click();
        $("#submit").click();

        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));
//        $(".table-responsive").shouldHave(text(firstName), text(lastName),
//                text("alex@egorov.com"), text("Some address 1"), text("30 July,2008"));
//
//        $(".table-responsive").$(byText("Date of Birth"))
//                .parent().shouldHave(text("30 July,2008"));
        checkTable("Date of Birth", "30 July,2008");
    }

    void checkTable(String key, String value) {
        $(".table-responsive").$(byText(key))
                .parent().shouldHave(text(value));
    }
}
