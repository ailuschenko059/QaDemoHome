package enums;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class PageComponent {
    SelenideElement stateCityInput = $("#stateCity-wrapper");

    public void setState(String state) {
        stateCityInput.$(byText(state)).click();
    }

    public void setCity(String city) {
        stateCityInput.$(byText(city)).click();
    }
}
