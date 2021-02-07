import com.codeborne.selenide.*;
import helpers.Configurationhelp;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class GitHubTests extends Configurationhelp {

    @BeforeAll
    static void setup() {
        Configuration.startMaximized = true;
    }

    @Test
    void findSoftAssertionsTest() {
        open(URL);
        $("[name='q']").setValue("Selenide").pressEnter();

        // find repo
        $$(".repo-list li").first().$("a").click();
        $("ul.UnderlineNav-body li",4).shouldHave(text("Wiki"));
        $("[ href*=wiki]").$("span").click();

        // $$(".UnderlineNav-body li").get(4).click();
        //$("#wiki-pages-box [href*=SoftAssertions]").shouldHave(text("SoftAssertions"));

        $$("#wiki-pages-box ul li").findBy(text("SoftAssertions")).click();


        $(".highlight",5).shouldHave(text("@RegisterExtension"));
        $("#wiki-body").$("[start='3']").shouldHave(text("Using JUnit5 extend test class:"));


    }}
