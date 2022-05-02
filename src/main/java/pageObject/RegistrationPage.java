package pageObject;

import com.codeborne.selenide.SelenideElement;
import enums.Calendar;
import enums.PageComponent;
import io.qameta.allure.Step;

import java.time.LocalDate;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class RegistrationPage {

    Calendar calendar = new Calendar();
    PageComponent stateAndCity = new PageComponent();

    SelenideElement inputFirstName = $("#firstName");
    SelenideElement inputLastName = $("#lastName");
    SelenideElement inputEmail = $("#userEmail");
    SelenideElement inputGender = $("#genterWrapper");
    SelenideElement inputPhoneNumber = $("#userNumber");
    SelenideElement dateOfBirth = $("#dateOfBirthInput");
    SelenideElement inputSubject = $("#subjectsInput");
    SelenideElement inputHobby = $("#hobbiesWrapper");
    SelenideElement pictureUpload = $("#uploadPicture");
    SelenideElement inputAddress = $("#currentAddress");

    @Step("Открываем страницу")
    public RegistrationPage openPage() {
        open("/automation-practice-form");
       return this;
    }
    @Step("Заполняем Имя")
    public RegistrationPage setFirstName(String firstName) {
        inputFirstName.setValue(firstName);
        return this;
    }
    @Step("Заполняем Фамилию")
    public RegistrationPage setLastName(String lastName) {
        inputLastName.setValue(lastName);
        return this;
    }
    @Step("Заполняем Эл.почту")
    public RegistrationPage setEmail(String userEmail) {
        inputEmail.setValue(userEmail);
        return this;
    }
    @Step("Выбираем пол")
    public RegistrationPage setGender(String gender) {
        inputGender.$(byText(gender)).click();
        return this;
    }
    @Step("Заполняем номер телефона")
    public RegistrationPage setPhoneNumber(String PhoneNumber) {
        inputPhoneNumber.setValue(PhoneNumber);
        return this;
    }
    @Step("Заполняем дату рождения")
    public RegistrationPage setBirthDate(LocalDate birth) {
        dateOfBirth.click();
        calendar.setDate(birth);
        return this;
    }
    @Step("Заполняем предмет")
    public RegistrationPage setSubject(String subject) {
        inputSubject.setValue(subject).pressEnter();
        return this;
    }
    @Step("Заполняем хобби")
    public RegistrationPage setHobby(String hobby) {
        inputHobby.$(byText(hobby)).click();
        return this;
    }
    @Step("Загружаем файл")
    public RegistrationPage uploadPicture(String image) {
        pictureUpload.uploadFromClasspath(image);
        return this;
    }
    @Step("Заполняем адрес")
    public RegistrationPage setAddress(String address) {
        inputAddress.setValue(address);
        return this;
    }
    @Step("Выбираем штат и город")
    public RegistrationPage setStateAndCity(String state, String city) {
        $("#state").click();
        stateAndCity.setState(state);
        $("#city").click();
        stateAndCity.setCity(city);
        return this;
    }
    @Step("Нажимаем Submit")
    public RegistrationPage submitForm() {
        $("#submit").click();
        return this;
    }
}
