
import enums.Generator;
import org.apache.commons.lang3.StringUtils;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pageObject.RegistrationPage;
import pageObject.ResultPage;
import testBase.TestBase;
import java.time.LocalDate;
import static java.lang.String.format;

@DisplayName("Проверка формы")
public class CheckForms extends TestBase {

 RegistrationPage registrationPage = new RegistrationPage();
 ResultPage resultPage = new ResultPage();
 Generator generator = new Generator();

 String firstName = generator.getFirstName();
 String lastName = generator.getLastName();
 String email = generator.getEmail();
 String gender = generator.getGender();
 String phoneNumber = generator.getPhoneNumber();
 LocalDate birthDate = generator.getDate();
 String subject = generator.getSubject();
 String hobby = generator.getHobby();
 String image = "screen.png";
 String address = generator.getAddress();
 String state = generator.getState();
 String city = generator.getCity(state);

 String expFullName = format("%s %s", firstName, lastName);
 String expMonth = StringUtils.capitalize(birthDate.getMonth().toString().toLowerCase());
 String expDate = format("%s %s,%s", birthDate.getDayOfMonth(), expMonth, birthDate.getYear());
 String expLocation = format("%s %s", state, city);
 String expFileName = image.substring(4);



 @Test
 @DisplayName("Заполнение формы и проверка данных")
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




