import static com.codeborne.selenide.Selenide.open;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;


public class CheckForms {


    @BeforeAll
    static void setUp() {
        Configuration.holdBrowserOpen = true;
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920x1080";
        //onfiguration.browserSize = "2560x1600";
    }


        @Test
        void testForm() {

           open("/automation-practice-form");
            $("#firstName").setValue("Joe");
            $("#lastName").setValue("Biden");
            $("#userEmail").setValue("JBiden@mail.ru");
            $("#genterWrapper").$(byText("Male")).click();
            $("#userNumber").setValue("5554547788");
            $("#dateOfBirthInput").setValue("20 Jan 1942");
            $(".react-datepicker__input-container").click();
            $(".react-datepicker__month-select").selectOption("January");
            $(".react-datepicker__year-select").selectOption("1942");
            $(".react-datepicker__day--020").click();
           // $("#subjectsInput").click();
            $("#subjectsInput").setValue("text check form");
            $("#hobbiesWrapper").$(byText("Reading")).click();
            $("#uploadPicture").uploadFromClasspath("screen.png");
            $("#currentAddress").setValue("current Address");
            $(byText("Select State")).scrollTo();
            $("#stateCity-wrapper").click();
            $(byText("Haryana")).click();
            $("#city").click();
            $(byText("Karnal")).click();
            $("#submit").click();

            //Asserts
            $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));
            $(".table-responsive").shouldHave(
                    text("Joe Biden"),
                    text("JBiden@mail.ru"),
                    text("Male"),
                    text("5554547788"),
                    text("20 January,1942"),
               //   text("text check form"),
                    text("Reading"),
                    text("screen.png"),
                    text("current Address"),
                    text("Haryana Karnal"));

        }

}




