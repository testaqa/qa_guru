
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;

import static com.codeborne.selenide.Selenide.*;

public class DemoqaTests {

    @BeforeAll
    static void setup() {
        Configuration.startMaximized = true;
    }
    String  fName = "Ilya",
            lname = "Fedorov",
            email = "test@test.com",
            fnumber = "8900000000",
            adress = "test test test",
            region = "Haryana",
            city = "Karnal";

    @Test
    void RegistrationFormTest() {
        open("https://www.demoqa.com/automation-practice-form");
        $("#firstName").setValue(fName);
        $("#lastName").setValue(lname);

        $("#userEmail").setValue(email);

        $("label[for='gender-radio-1']").click();
        $("#userNumber").setValue(fnumber);

        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption("April");
        $(".react-datepicker__year-select").selectOption("1905");
        $("[aria-label='Choose Sunday, April 9th, 1905']").click();

        $("#subjectsInput").setValue("Computer Science").pressEnter();

        $("label[for='hobbies-checkbox-1']").click();
        $("label[for='hobbies-checkbox-3']").click();

        $("#uploadPicture").setValue("F:/IdeaProjects/qa_guru/src/test/resources/doberman.jpg");

        $("#currentAddress").setValue(adress);

        $("#react-select-3-input").setValue(region).pressEnter();
        $("#react-select-4-input").setValue(city).pressEnter();

        $("#submit").click();

        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));
        $x("//div[@class='table-responsive']//tbody/tr[1]").shouldHave(text("Student Name"),text(fName));
        $x("//div[@class='table-responsive']//table//tr[2]").shouldHave(text("Student Email"),text(email));
        $x("//div[@class='table-responsive']//table//tr[3]").shouldHave(text("Gender"),text("Male"));
        $x("//div[@class='table-responsive']//table//tr[4]").shouldHave(text("Mobile"),text(fnumber));
        $x("//div[@class='table-responsive']//table//tr[5]").shouldHave(text("Date of Birth"),text("09 April,1905"));
        $x("//div[@class='table-responsive']//table//tr[6]").shouldHave(text("Subjects"),text("Computer Science"));
        $x("//div[@class='table-responsive']//table//tr[7]").shouldHave(text("Hobbies"),text("Sports, Music"));
        $x("//div[@class='table-responsive']//table//tr[8]").shouldHave(text("Picture"),text("doberman.jpg"));
        $x("//div[@class='table-responsive']//table//tr[9]").shouldHave(text("Address"),text(adress));
        $x("//div[@class='table-responsive']//table//tr[10]").shouldHave(text("State and City"),text(region));
        $("#closeLargeModal").click();
















    }







}
