package tests;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class GoogleTests {

    @Test
    void selenideSearchTests() {
    // открыть Google
        open("https://www.google.ru/");
    // ввести в поиск Seleniude
     //   $("[name='q']").setValue('Selenide');
        $(By.name("q")).setValue("Selenide").pressEnter();
    // убедится что он появился в  результатах поиска

        $(By.cssSelector("#search")).shouldHave(text("selenide.org"));
        // для поиска по  id  можно использовать  #
    }

    @Test
    void selenideYandexSearch() {
        open("https://www.ya.ru/");
        $("#text").setValue("Selenide").pressEnter();

        $$("a > b").first().shouldHave(text("selenide.org"));
    }
}

