package tests.MethodStep;

import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;

public class MethodDemoqaTest {

    public BaseStep steps = new BaseStep();

    @Test
    @DisplayName("Регистрация пользователя")
    @Tags({@Tag("web"), @Tag("critical")})
    @Owner("Ilya Fedorov")
    @Feature("AutoAssign")  // поиск  по  фичам

    public void RegistrationForm(){
        steps.openMainPage();
        steps.EnterFirstName();
        steps.EnterLastName();
        steps.EnterEmail();
        steps.ChooseGenderMale();
        steps.EnterPhoneNumber();
        steps.SelectDateInput();
        steps.SelectMonthofBirth();
        steps.SelectYearofBirth();
        steps.SelectDayofBirth();
        steps.EnterYourSkill();
        steps.SelectHobbieSport();
        steps.SelectHobbieReading();
        steps.UploadImage();
        steps.EnterYourAdres();
        steps.SelectStateAndcity();
        steps.ClickSubmitButton();

        steps.AssertThanksSubmiting();
        steps.AssertLastName();
        steps.AssertEmail();
        steps.AssertGender();
        steps.AssertPhoneNumber();
        steps.AssertDayOfBirth();
        steps.AssertSubject();
        steps.AssertHobbies();
        steps.AssertUploadFiles();
        steps.AssertStateAndCity();
        steps.AssertCloseformRegistration();

    }}
