import static com.codeborne.selenide.Selenide.open;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import enums.Generator;
import org.apache.commons.lang3.StringUtils;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import pageObject.RegistrationPage;
import pageObject.ResultPage;
import testBase.TestBase;

import java.time.LocalDate;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static java.lang.String.format;


public class CheckForms extends TestBase {
 RegistrationPage registrationPage = new RegistrationPage();
 ResultPage resultPage = new ResultPage();
 Generator gen = new Generator();

 String firstName = gen.getFirstName();
 String lastName = gen.getLastName();
 String email = gen.getEmail();
 String gender = gen.getGender();
 String phoneNumber = gen.getPhoneNumber();
 LocalDate birthDate = gen.getDate();
 String subject = gen.getSubject();
 String hobby = gen.getHobby();
 String image = "screen.png";
 String address = gen.getAddress();
 String state = gen.getState();
 String city = gen.getCity(state);

 String expFullName = format("%s %s", firstName, lastName);
 String expMonth = StringUtils.capitalize(birthDate.getMonth().toString().toLowerCase()); //Capitalized month name
 String expDate = format("%s %s,%s", birthDate.getDayOfMonth(), expMonth, birthDate.getYear());
 String expLocation = format("%s %s", state, city);
 String expFileName = image.substring(4);



 @Test
 void testForm() {
 registrationPage.openPage()
         .setFirstName(firstName)
         .setLastName(lastName)
         .setEmail(email)
         .setGender(gender)
         .setPhoneNumber(phoneNumber)
         .setBirthDate(birthDate)
         .setSubject(subject)
         .setHobby(hobby)
         .uploadPicture(image)
         .setAddress(address)
         .setStateAndCity(state, city)
         .submitForm();

 resultPage.checkTitle("Thanks for submitting the form")
         .checkResult("Student Name", expFullName)
         .checkResult("Student Email", email)
         .checkResult("Gender", gender)
         .checkResult("Mobile", phoneNumber)
         .checkResult("Date of Birth", expDate)
         .checkResult("Subjects", subject)
         .checkResult("Hobbies", hobby)
         .checkResult("Picture", expFileName)
         .checkResult("Address", address)
         .checkResult("State and City", expLocation);



 }



}




