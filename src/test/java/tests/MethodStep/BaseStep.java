package tests.MethodStep;

import com.github.javafaker.Faker;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class BaseStep {
    Faker faker = new Faker();
    String  fName = faker.name().firstName();
    String   lname = faker.name().lastName();
    String  subj1 = "Computer Science";
    String  subj2 = "Economics";
    String  email = faker.internet().emailAddress();
    String fnumber = faker.number().digits(10);
    String month = "April";
    String daybirth = "09";
    String  adress = faker.address().fullAddress();
    String  state = "Haryana";
    String   city = "Karnal";
    String  year = "1905";

    private static final String Base_URL = "https://www.demoqa.com/automation-practice-form";

    @Step("Открываем  главную  страницу")
    public void openMainPage() {
        open(Base_URL);
    }

    @Step("Введите Имя пользователя")
    public void EnterFirstName() {
        $("#firstName").setValue(fName);
    }

    @Step("Введите Фамилию пользователя")
    public void EnterLastName() {
        $("#lastName").setValue(lname);
    }

    @Step("Введите email пользователя")
    public void EnterEmail() {
        $("#userEmail").setValue(email);
    }

    @Step("Выберите пол")
    public void ChooseGenderMale() {
        $("label[for='gender-radio-1']").click();
    }

    @Step("Введите номер телефона")
    public void EnterPhoneNumber() {
        $("#userNumber").setValue(fnumber);
    }

    @Step("Выберите календарь")
    public void SelectDateInput() {
        $("#dateOfBirthInput").click();
    }

    @Step("Выберите месяц рождения")
    public void SelectMonthofBirth() {
        $(".react-datepicker__month-select").selectOption(month);
    }

    @Step("Выберите год рождения")
    public void SelectYearofBirth() {
        $(".react-datepicker__year-select").selectOption(year);
    }

    @Step("Выберите дату рождения")
    public void SelectDayofBirth() {
        $(".react-datepicker__day--0" + daybirth).click();
    }

    @Step("Выберите ваши  скилы")
    public void EnterYourSkill() {
      $("#subjectsInput").setValue(subj1);
      $(".subjects-auto-complete__menu-list").$(byText(subj1)).click();
      $("#subjectsInput").setValue(subj2);
      $(".subjects-auto-complete__menu-list").$(byText(subj2)).click();
    }

    @Step("Выберите хобби  Sport")
    public void SelectHobbieSport() {
        $("label[for='hobbies-checkbox-1']").click();
    }

    @Step("Выберите хобби  Reading")
    public void SelectHobbieReading() {
        $("label[for='hobbies-checkbox-3']").click();
    }

    @Step("Загрузите файл")
    public void UploadImage() {
        $("#uploadPicture").setValue("F:/IdeaProjects/qa_guru/src/test/resources/doberman.jpg");
    }

    @Step("Введите  ваш  адрес")
    public void EnterYourAdres() {
        $("#currentAddress").setValue(adress);
    }

    @Step("Введите  ваш  город  и штат")
    public void SelectStateAndcity() {
        $("#react-select-3-input").setValue(state).pressEnter();
        $("#react-select-4-input").setValue(city).pressEnter();
    }

    @Step("Клик по кнопке submit")
    public void ClickSubmitButton() {
        $("#submit").click();
    }

    @Step("Проверка  что  на странице  есть  текст юлагодарности ")
    public void AssertThanksSubmiting() {
        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));
    }

    @Step("Проверка  Фамилии и  Имени ")
    public void AssertLastName() {
        $x("//div[@class='table-responsive']//tbody/tr[1]").shouldHave(text("Student Name"), text(fName + " " + lname ));
    }

    @Step("Проверка  email")
    public void AssertEmail() {
        $x("//div[@class='table-responsive']//table//tr[2]").shouldHave(text("Student Email"), text(email));
    }

    @Step("Проверка  пола")
    public void AssertGender() {
        $x("//div[@class='table-responsive']//table//tr[3]").shouldHave(text("Gender"), text("Male"));
    }

    @Step("Проверка  номера телефона")
    public void AssertPhoneNumber() {
        $x("//div[@class='table-responsive']//table//tr[4]").shouldHave(text("Mobile"), text(fnumber));
    }

    @Step("Проверка  даты рождения")
    public void AssertDayOfBirth() {
        $x("//div[@class='table-responsive']//table//tr[5]").shouldHave(text("Date of Birth"), text(daybirth + " " + month + "," + year));
    }

    @Step("Проверка  выбранных  скилов")
    public void AssertSubject() {
        $x("//div[@class='table-responsive']//table//tr[6]").shouldHave(text("Subjects"), text(subj1 + ", " + subj2));
    }

    @Step("Проверка  выбранных хобби ")
    public void AssertHobbies() {
        $x("//div[@class='table-responsive']//table//tr[7]").shouldHave(text("Hobbies"), text("Sports, Music"));
    }

    @Step("Проверка  загрузки файлов ")
    public void AssertUploadFiles() {
        $x("//div[@class='table-responsive']//table//tr[8]").shouldHave(text("Picture"), text("doberman.jpg"));
    }

    @Step("Проверка  адреса ")
    public void AssertAdres() {
        $x("//div[@class='table-responsive']//table//tr[9]").shouldHave(text("Address"), text(adress));
    }


    @Step("Проверка города и штата")
    public void AssertStateAndCity() {
        $x("//div[@class='table-responsive']//table//tr[10]").shouldHave(text("State and City"), text(state + " " + city));
    }

    @Step("Закрытие формы подтверждения")
    public void AssertCloseformRegistration() {
        $("#closeLargeModal").click();
    }

}

