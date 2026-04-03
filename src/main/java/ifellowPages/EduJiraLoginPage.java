package ifellowPages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import java.time.Duration;

import static com.codeborne.selenide.Selenide.$x;

public class EduJiraLoginPage {
    private final SelenideElement usernameInput = $x("//input[@id='login-form-username']").as("Поле ввода логина");
    private final SelenideElement passwordInput = $x("//input[@id='login-form-password']").as("Поле ввода пароля");
    private final SelenideElement loginButton = $x("//input[@id='login']").as("Кнопка авторизации");

    public void login(String username, String password) {
        usernameInput.shouldBe(Condition.visible, Duration.ofSeconds(5)).setValue(username);
        passwordInput.shouldBe(Condition.visible, Duration.ofSeconds(5)).setValue(password);
        loginButton.click();
    }

}
